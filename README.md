# Keystone Field Service Management System – Backend

<div align="center">

# 🚀 Keystone Field Service Management System

### Backend REST API

Developed as part of the **Zidio Development Internship Program**

**Backend Domain:** Spring Boot REST API

---

**Java 21 • Spring Boot 4 • Spring Security • JWT • PostgreSQL • Flyway • Hibernate • Maven • Swagger/OpenAPI**

</div>

---

# Table of Contents

- Project Overview
- Objectives
- Backend Features
- Technology Stack
- System Architecture
- Backend Project Structure
- Design Principles
- Authentication & Authorization
- Backend Modules
- REST API Overview
- Database Design
- Work Order Lifecycle
- Security Implementation
- API Documentation
- Installation Guide
- Configuration
- Running the Project
- Database Migration
- Deployment
- Future Enhancements
- Acknowledgements

---

# Project Overview

The **Keystone Field Service Management System** is an enterprise-level field service management platform designed to streamline customer service operations, technician assignments, work order processing, service tracking, and operational monitoring.

This repository contains the complete **Spring Boot Backend** implementation developed as part of the **Zidio Development Internship Program**.

The backend exposes secure RESTful APIs that communicate with the frontend application while managing authentication, authorization, business logic, database operations, scheduling, and reporting.

The system is built using modern Java development practices with layered architecture, JWT authentication, PostgreSQL, Hibernate ORM, Flyway database migrations, and OpenAPI documentation.

---

# Objectives

The primary objectives of the backend system are:

- Build secure REST APIs
- Authenticate users using JWT
- Manage technicians and administrators
- Manage customers and customer sites
- Create and manage work orders
- Assign technicians to work orders
- Track work order status
- Record technician working hours
- Record spare part usage
- Track SLA deadlines
- Provide dashboard analytics
- Maintain work order status history
- Support scalable enterprise architecture

---

# Backend Features

## Authentication

- JWT Authentication
- Secure Login
- Password Encryption using BCrypt
- Role-Based Authorization
- Stateless Authentication

---

## User Management

- Create User
- Update User
- Delete User
- View User
- List Users
- Technician Management
- Role Management

---

## Customer Management

- Create Customer
- Update Customer
- Delete Customer
- View Customer
- Customer Listing

---

## Site Management

- Create Site
- Update Site
- Delete Site
- Customer-wise Site Retrieval
- Site Information Management

---

## Work Order Management

- Create Work Order
- Update Work Order
- Delete Work Order
- Retrieve Work Order
- List All Work Orders

---

## Technician Assignment

- Assign Technician
- Remove Technician Assignment
- Technician Work Order Retrieval

---

## Work Order Status Management

Supported statuses:

- NEW
- ASSIGNED
- IN_PROGRESS
- COMPLETED
- CLOSED
- CANCELLED

Includes status validation and controlled state transitions.

---

## Time Logging

Technicians can:

- Log working hours
- Record work duration
- Maintain service records

---

## Parts Usage

Technicians can:

- Record spare parts
- Track quantity used
- Maintain maintenance records

---

## SLA Monitoring

The backend automatically supports:

- SLA Deadline Tracking
- SLA Breach Detection
- Scheduled SLA Monitoring

---

## Dashboard Analytics

Dashboard provides:

- Total Customers
- Total Sites
- Total Work Orders
- New Work Orders
- Assigned Work Orders
- In Progress Work Orders
- Completed Work Orders
- Closed Work Orders
- Cancelled Work Orders
- Total Technicians

---

# Technology Stack

| Category | Technology |
|----------|------------|
| Language | Java 21 |
| Framework | Spring Boot 4 |
| Security | Spring Security 7 |
| Authentication | JWT |
| ORM | Hibernate |
| Database | PostgreSQL |
| Migration | Flyway |
| Build Tool | Maven |
| Documentation | Swagger / OpenAPI |
| IDE | Eclipse |
| Version Control | Git |
| Repository | GitHub |

---

# System Architecture

```text
                Client Application
                       │
                       ▼
                Spring Boot REST API
                       │
        ┌──────────────┼──────────────┐
        ▼              ▼              ▼
 Authentication    Business Logic   Validation
        │              │
        ▼              ▼
 Spring Security    Service Layer
        │              │
        └──────────────┼──────────────┘
                       ▼
                 Repository Layer
                       │
                       ▼
                PostgreSQL Database
```

---

# Backend Project Structure

```text
src/main/java
│
├── config
├── controller
├── dto
├── entity
├── enums
├── exception
├── repository
├── scheduler
├── security
├── service
├── service/impl
└── KeystoneBackendApplication.java
```

---

# Design Principles

The backend follows a layered architecture to ensure maintainability, scalability, and separation of concerns.

### Controller Layer

- Exposes REST APIs
- Validates incoming requests
- Delegates business logic to service classes
- Returns standardized HTTP responses

### Service Layer

- Implements business logic
- Performs validations
- Coordinates data access
- Handles application workflows

### Repository Layer

- Uses Spring Data JPA
- Performs CRUD operations
- Executes database queries
- Interacts directly with PostgreSQL

### Entity Layer

- Represents database tables
- Defines entity relationships
- Uses JPA and Hibernate annotations

### Security Layer

- Implements JWT authentication
- Configures Spring Security
- Protects REST endpoints
- Manages role-based authorization

---

# Authentication & Authorization

Authentication is implemented using **JSON Web Tokens (JWT)**.

After a successful login, the server generates a JWT token which must be included in subsequent requests.

Example:

```http
Authorization: Bearer <JWT_TOKEN>
```

Passwords are securely encrypted using **BCrypt Password Encoder** before being stored in the database.

---

## User Roles

The application supports role-based access control.

### Administrator

- Manage users
- Manage customers
- Manage sites
- Create work orders
- Assign technicians
- View dashboard
- Monitor SLA

### Technician

- View assigned work orders
- Update work order status
- Record time logs
- Record parts usage

---

# Backend Modules

## 1. Authentication Module

Responsible for:

- User login
- JWT token generation
- User authentication
- Password encryption
- Request authorization

---

## 2. User Management Module

Provides APIs to:

- Create users
- Update users
- Delete users
- View user details
- List all users

---

## 3. Customer Management Module

Supports:

- Customer registration
- Customer updates
- Customer deletion
- Customer retrieval

---

## 4. Site Management Module

Each customer may have multiple service sites.

Features include:

- Create site
- Update site
- Delete site
- View customer sites

---

## 5. Work Order Management

The work order module manages the complete service lifecycle.

Features:

- Create work order
- Update work order
- Delete work order
- Retrieve work order
- View all work orders

---

## 6. Technician Assignment

Allows administrators to:

- Assign technicians
- Remove technician assignments
- Prevent assignment of closed work orders

---

## 7. Work Order Status Tracking

Every work order progresses through predefined stages.

Supported statuses:

- NEW
- ASSIGNED
- IN_PROGRESS
- COMPLETED
- CLOSED
- CANCELLED

Status updates are recorded to maintain service history.

---

## 8. Time Logging

Technicians can record:

- Work performed
- Hours worked
- Service duration

These logs help monitor productivity and service effort.

---

## 9. Parts Usage

Allows technicians to record:

- Spare part name
- Quantity used
- Usage history

---

## 10. SLA Monitoring

Each work order contains an SLA deadline.

A scheduled task automatically checks overdue work orders and flags SLA breaches.

---

## 11. Dashboard Module

Provides operational statistics including:

- Total Customers
- Total Sites
- Total Work Orders
- New Work Orders
- Assigned Work Orders
- In Progress Work Orders
- Completed Work Orders
- Closed Work Orders
- Cancelled Work Orders
- Total Technicians

---

# Database Design

The backend uses **PostgreSQL** as the primary relational database.

Database migrations are managed using **Flyway**, ensuring consistent schema updates.

Primary entities include:

- User
- Customer
- Site
- WorkOrder
- TimeLog
- PartUsage
- WorkOrderStatusHistory

---

# Entity Relationships

```text
Customer
    │
    ├──────────────► Site
    │                     │
    │                     │
    │                     ▼
    │               WorkOrder
    │                     │
    │        ┌────────────┴────────────┐
    │        ▼                         ▼
    │    TimeLog                 PartUsage
    │
    ▼
User (Technician/Admin)
```

---

# Work Order Lifecycle

```text
NEW
   │
   ▼
ASSIGNED
   │
   ▼
IN_PROGRESS
   │
   ▼
COMPLETED
   │
   ▼
CLOSED

or

CANCELLED
```

---

# Security Implementation

Security is implemented using Spring Security.

Features include:

- JWT Authentication
- Stateless Session Management
- BCrypt Password Encryption
- Protected REST Endpoints
- Role-Based Authorization

---

# REST API Overview

## Authentication

| Method | Endpoint |
|---------|----------|
| POST | /api/auth/login |

---

## Users

| Method | Endpoint |
|---------|----------|
| GET | /api/users |
| GET | /api/users/{id} |
| POST | /api/users |
| PUT | /api/users/{id} |
| DELETE | /api/users/{id} |

---

## Customers

| Method | Endpoint |
|---------|----------|
| GET | /api/customers |
| GET | /api/customers/{id} |
| POST | /api/customers |
| PUT | /api/customers/{id} |
| DELETE | /api/customers/{id} |

---

## Sites

| Method | Endpoint |
|---------|----------|
| GET | /api/sites |
| GET | /api/sites/{id} |
| POST | /api/sites |
| PUT | /api/sites/{id} |
| DELETE | /api/sites/{id} |

---

## Work Orders

| Method | Endpoint |
|---------|----------|
| GET | /api/work-orders |
| GET | /api/work-orders/{id} |
| POST | /api/work-orders |
| PUT | /api/work-orders/{id} |
| DELETE | /api/work-orders/{id} |

---

## Technician Assignment

| Method | Endpoint |
|---------|----------|
| PUT | /api/work-orders/{id}/assign/{technicianId} |
| PUT | /api/work-orders/{id}/remove-technician |

---

## Time Logs

| Method | Endpoint |
|---------|----------|
| POST | /api/work-orders/{id}/time-logs |

---

## Parts Usage

| Method | Endpoint |
|---------|----------|
| POST | /api/work-orders/{id}/parts |

---

## Dashboard

| Method | Endpoint |
|---------|----------|
| GET | /api/dashboard |

---

# API Documentation

Swagger/OpenAPI is integrated for interactive API documentation.

After running the application:

```
http://localhost:8080/swagger-ui/index.html
```

The Swagger UI provides:

- API testing
- Request examples
- Response schemas
- JWT authorization support

---

# Installation Guide

## Clone Repository

```bash
git clone <repository-url>
```

---

## Open Project

Import the project into Eclipse or IntelliJ IDEA as a Maven project.

---

## Configure Database

Create a PostgreSQL database.

Update the following properties:

```properties
spring.datasource.url=
spring.datasource.username=
spring.datasource.password=
```

---

## Install Dependencies

```bash
mvn clean install
```

---

## Run the Application

```bash
mvn spring-boot:run
```

or run the main application class from your IDE.

---

# Flyway Database Migration

Flyway automatically creates and updates database tables during application startup.

Benefits include:

- Version-controlled database schema
- Consistent migrations
- Easy deployment
- Automatic initialization

---

# Deployment

The backend is designed for cloud deployment.

Recommended stack:

- Backend: Render
- Database: Neon PostgreSQL
- API Documentation: Swagger/OpenAPI
- Version Control: GitHub

---

# Future Enhancements

Potential improvements include:

- Email notifications
- SMS alerts
- File attachment support
- Work order priority matrix
- Technician GPS tracking
- Analytics dashboard
- Audit logging
- Docker containerization
- CI/CD pipeline
- Kubernetes deployment

---

# Acknowledgements

This backend project was developed as part of the **Zidio Development Internship Program**.

The project demonstrates enterprise backend development using Spring Boot, REST APIs, JWT authentication, PostgreSQL, Hibernate, Flyway, and Spring Security while following layered architecture and RESTful design principles.

---

# Author

**Harikrishna Gangadi**


- Java
- Spring Boot
- Spring Security
- PostgreSQL
- Hibernate
- REST APIs
- JWT Authentication
- Flyway
- Maven

---

## Thank You

Thank you for reviewing this project.

Feedback and suggestions are always welcome.
