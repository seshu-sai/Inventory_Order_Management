package com.InventoryManagement.api_gateway.Filter;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

@Component
public class RouteValidator {

    public static final List<String> endURL =
            List.of(

                    //products
                    "/api/products",
                    "/api/products/{id}",
                    "/api/products/{id}",
                    "/api/products/reduce-stock",
                    "/api/products/increase-stock",

                    //categories
                    "/api/categories",
                    "/api/categories",
                    "/api/categories/{id}",

                    //suppliers
                    "/api/suppliers",
                    "/api/suppliers/{id}",
                    "/api/suppliers/{id}",

                    //orders
                    "/api/orders",
                     "/api/orders/{id}",

                    //order-items
                    "/api/order-items",

                    //stock Movements
                    "/api/stock-movements",

                    //customers
                    "/api/customers",
                    "/api/customers/{id}",
                    "/api/customers/{id}"
            );

    public Predicate<ServerHttpRequest> isSecured =
            request -> endURL.stream()
                    .anyMatch(uri -> request.getURI().getPath().startsWith(uri));
}
