# 🏥 Patient Management System (Microservices Architecture)

This repository contains the implementation of a **Patient Management System** designed using the **Microservice Architecture** approach. The system modularizes core healthcare functionalities into separate, independently deployable services to ensure scalability, maintainability, and reliability.

---

## ⚙️ Technologies Used

- **Language & Framework:** Java 21 with Spring Boot 3
- **Message Broker:** Apache Kafka
- **Containerization:** Docker
- **Deployment Environment:** LocalStack simulating AWS services

---

## 🧩 Microservices Overview

The system is composed of the following core microservices:

- **API Gateway:**  
  Acts as the single entry point to route and manage incoming client requests to respective services.

- **Auth Service:**  
  Handles authentication and authorization using industry-standard practices such as JWT.

- **Patient Service:**  
  Manages patient-related data including registration, updates, and medical history tracking.

- **Billing Service:**  
  Manages billing information, invoicing, and payment history for patients.

- **Analytics Service:**  
  Collects and processes data for generating insights, reports, and usage statistics across services.

- **Notification Service:**  
  Sends email/SMS notifications to patients and staff triggered by various system events (e.g., appointment reminders, billing updates).

---

## 🧪 Development & Deployment

- All services are containerized using **Docker**.
- The infrastructure is emulated with **LocalStack**, enabling local development and testing against simulated AWS services.
- **Apache Kafka** is integrated for asynchronous communication between microservices.

---

## 🏗️ Architecture Summary

Each service is designed to be:

- **Independent** and **loosely coupled**
- Communicating via **REST APIs** and **Kafka topics**
- Secure, using centralized authentication
- Scalable and fault-tolerant under distributed load

---

## 📦 Getting Started

> Prerequisites:
> - Docker & Docker Compose
> - Java 21
> - LocalStack CLI (optional but recommended)

1. **Clone the repository**
   ```bash
   git clone https://github.com/your-username/patient-management-system.git
   cd patient-management-system
   ```

2. **Start services using Docker Compose**
   ```bash
   docker-compose up --build
   ```

3. **Access Services**
    - API Gateway: `http://localhost:8080`
    - LocalStack Dashboard (if used): `http://localhost:4566`

---

## 📚 Future Enhancements

- Integration with real AWS cloud resources
- UI for patient/staff portal
- CI/CD pipeline setup
- Role-based access control

---

## 👨‍💻 Authors

This system is developed as part of learning project by **Dulip Sameera Weliwaththa**.

---

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.