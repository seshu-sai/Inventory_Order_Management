package com.InventoryManagement.order_service.Service;

import com.InventoryManagement.order_service.ForiegnDTO.CustomerDTO;
import com.InventoryManagement.order_service.ForiegnDTO.OrderItemDTO;
import com.InventoryManagement.order_service.Model.CustomerClient;
import com.InventoryManagement.order_service.Model.Order;
import com.InventoryManagement.order_service.Model.OrderItemClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailConsumer {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    OrderItemClient orderItemClient;

    @Autowired
    CustomerClient customerClient;

    @Value("${spring.mail.username}")
    private String from;

    @KafkaListener(topics = "email-topic", groupId = "emailNotification-group")
    public void consume(String message) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String[] parts = message.split(":");
            Long orderId = Long.parseLong(parts[0]);
            Long customerId = Long.parseLong(parts[1]);

           CustomerDTO customer =customerClient.getCustomerId(customerId);
           List<OrderItemDTO> orderItemDTO = orderItemClient.getItemsByOrderId(orderId);

            sendMail(customer.getEmail(), orderId, orderItemClient.getItemsByOrderId(orderId));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void sendMail(String to, Long orderId, List<OrderItemDTO> productList) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject("✅ Order Confirmation: #" + orderId);

            StringBuilder html = new StringBuilder();
            html.append("<h2 style='color:#3a86ff;'>Thank you for your order from <strong>InventoryPro Solutions</strong></h2>");
            html.append("<p>Your order <strong>#").append(orderId).append("</strong> has been successfully placed.</p>");

            // Table for Order Items
            html.append("<table border='1' cellpadding='8' cellspacing='0' style='border-collapse: collapse; width: 100%;'>");
            html.append("<thead style='background-color:#f2f2f2;'><tr>")
                    .append("<th>Product</th><th>Quantity</th><th>Price</th>")
                    .append("</tr></thead><tbody>");

            for (OrderItemDTO item : productList) {
                html.append("<tr>")
                        .append("<td>").append(item.getQuantity()).append("</td>")
                        .append("<td>$").append(item.getUnitPrice()).append("</td>")
                        .append("</tr>");
            }

            html.append("</tbody></table>");
            html.append("<br/><p>If you have any questions, contact us at <b>support@inventorypro.com</b></p>");
            html.append("<p style='font-size: 0.9rem; color: #777;'>© 2025 InventoryPro Solutions. All rights reserved.</p>");

            helper.setText(html.toString(), true); // true = HTML

            mailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
