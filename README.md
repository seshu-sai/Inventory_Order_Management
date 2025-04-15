# 🧾 Inventory and Order Management System

A distributed microservices-based Inventory & Order Management System built using Spring Boot, Spring Cloud (Eureka, Config Server, API Gateway), and secured with JWT authentication.

---

## 🛠 Tech Stack

- **Spring Boot 3.4.4**
- **Spring Cloud 2024.0.1**
- **Spring Cloud Eureka** - Service Discovery
- **Spring Cloud Config Server** - Centralized Configuration
- **Spring Cloud Gateway** - API Gateway
- **Spring Security with JWT** - Authentication & Authorization
- **Spring Data JPA + MySQL** - Persistence
- **OpenFeign** - Inter-Service Communication
- **Postman** - API Testing

---

## 📦 Microservices Overview

### 🔐 `auth-service`
- User registration and login
- JWT token generation and validation

### 🛍️ `product-service`
- Manage products with details, stock, category, and supplier association
- Stock adjustment operations

### 📂 `category-service`
- Add, update, delete, list categories

### 🚚 `supplier-service`
- Manage suppliers and link them to products

### 🧾 `order-service`
- Create and retrieve customer orders
- Communicates with `order-item-service` to store order items

### 📦 `order-item-service`
- Manages individual order items
- Used when creating orders

### 👥 `customer-service`
- Manages customer information

### 🔄 `stock-movement-service`
- Tracks changes in product stock levels with timestamps

### 🌐 `api-gateway`
- Unified entry point for all microservices
- Route mapping based on path and service name
- Applies security filters (JWT)

---

## 🚀 How to Run

### Prerequisites:
- Java 17+
- MySQL
- Maven
- Postman (for testing APIs)

---

### 1️⃣ Start Required Services
- Run **Eureka Server**
- Run **Config Server** (linked to a GitHub config repo or local file system)

---

### 2️⃣ Start Microservices (in this order ideally):
- `auth-service`
- `api-gateway`
- Other business services (`product`, `category`, `supplier`, `customer`, etc.)

---

## 🔑 JWT Auth Flow

- **Register:** `POST /auth/register`
- **Login:** `POST /auth/token` → returns JWT token
- **Validate:** `GET /auth/validate?token=xxx`

Use the token as a Bearer token in Authorization header:


---

## 🔗 Sample Routes

| Path                      | Mapped To               |
|---------------------------|-------------------------|
| `/api/products/**`        | product-service         |
| `/api/categories/**`      | category-service        |
| `/api/suppliers/**`       | supplier-service        |
| `/api/orders/**`          | order-service           |
| `/api/order-items/**`     | order-item-service      |
| `/api/stock-movements/**` | stock-movement-service  |
| `/api/customers/**`       | customer-service        |
| `/auth/**`                | auth-service            |

---

## 🧪 Postman Collections

A set of Postman requests is recommended for:
- Creating categories, products, suppliers
- Registering and logging in a user
- Placing orders
- Viewing stock movements

---

## 🧠 Future Enhancements

- Role-based access using JWT claims
- Email notifications for orders
- Product image uploads (S3/GCP)
- Admin dashboard UI (React/Angular)

---

## 👨‍💻 Author

Shesha Sai Ganduri — Java Full Stack Developer 

---

