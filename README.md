#  Pagination Exception Handling API

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge\&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0-brightgreen?style=for-the-badge\&logo=springboot)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue?style=for-the-badge\&logo=mysql)
![Maven](https://img.shields.io/badge/Maven-Build-red?style=for-the-badge\&logo=apachemaven)
![REST API](https://img.shields.io/badge/REST-API-success?style=for-the-badge)
![Swagger](https://img.shields.io/badge/Swagger-OpenAPI-green?style=for-the-badge\&logo=swagger)

A production-ready **Spring Boot REST API** demonstrating **CRUD Operations**, **Pagination**, **DTO Mapping**, and **Global Exception Handling** using **Spring Boot**, **Spring Data JPA**, **Hibernate**, and **MySQL**.

This project follows a clean layered architecture and is designed to showcase backend development best practices with structured APIs, centralized exception handling, and efficient data retrieval.

---

#  Table of Contents

* Features
* Tech Stack
* Project Architecture
* Project Structure
* Getting Started
* Configuration
* API Endpoints
* Pagination
* Exception Handling
* Swagger Documentation
* Future Enhancements
* Author

---

#  Features

*  CRUD Operations
*  Pagination using Spring Data JPA
*  DTO (Data Transfer Object) Pattern
*  Global Exception Handling
*  Custom Exception Classes
*  Structured Error Responses
*  Layered Architecture
*  RESTful APIs
*  MySQL Database Integration
*  Hibernate ORM
*  Swagger/OpenAPI Documentation
*  Maven Build System

---

#  Tech Stack

| Technology        | Version |
| ----------------- | ------- |
| Java              | 21      |
| Spring Boot       | 4.x     |
| Spring Data JPA   | Latest  |
| Hibernate         | 7.x     |
| MySQL             | 8.x     |
| Maven             | Latest  |
| Lombok            | Latest  |
| SpringDoc OpenAPI | Latest  |

---

#  Project Architecture

```text
                  Client
                     │
                     ▼
              REST Controller
                     │
                     ▼
                  Service
                     │
                     ▼
                Repository
                     │
                     ▼
             MySQL Database
```

---

#  Project Structure

```text
src
└── main
    ├── java
    │
    ├── controller
    │     └── StudentController.java
    │
    ├── dto
    │     └── StudentDTO.java
    │
    ├── entity
    │     └── Student.java
    │
    ├── error
    │     ├── GlobalExceptionHandler.java
    │     ├── ResourceNotFoundException.java
    │     └── ErrorResponse.java
    │
    ├── repository
    │     └── StudentRepository.java
    │
    ├── service
    │     ├── StudentService.java
    │     └── StudentServiceImpl.java
    │
    └── PaginationExceptionHandlingApplication.java

resources
│
├── application.properties
└── ...
```

---

# ⚙ Getting Started

## Clone the Repository

```bash
git clone https://github.com/harshdwivedi-tech/PaginationExceptionHandling.git
```

## Navigate to Project

```bash
cd PaginationExceptionHandling
```

## Build the Project

```bash
./mvnw clean install
```

## Run the Application

```bash
./mvnw spring-boot:run
```

The application will start at

```text
http://localhost:8080
```

---

#  Configuration

Update your `application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/pagination
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

#  API Endpoints

| Method | Endpoint         | Description                           |
| ------ | ---------------- | ------------------------------------- |
| GET    | `/students`      | Retrieve all students with pagination |
| GET    | `/students/{id}` | Retrieve a student by ID              |
| POST   | `/students`      | Create a new student                  |
| PUT    | `/students/{id}` | Update an existing student            |
| DELETE | `/students/{id}` | Delete a student                      |

---

#  Pagination Example

Retrieve the first page containing five records.

```http
GET /students?page=0&size=5
```

Example URL

```text
http://localhost:8080/students?page=0&size=5
```

---

#  Global Exception Handling

The project uses **centralized exception handling** with `@RestControllerAdvice` to return consistent and meaningful error responses.

### Handles

* Resource Not Found Exception
* Invalid Request Exception
* Runtime Exceptions
* Generic Exceptions

Example Response

```json
{
  "timestamp": "2026-07-07T17:10:51",
  "status": 404,
  "error": "Not Found",
  "message": "Student not found with id 15",
  "path": "/students/15"
}
```

---

#  Swagger Documentation

Once the application is running, open

```text
http://localhost:8080/swagger-ui/index.html
```

to explore and test the REST APIs.

---

#  Future Enhancements

*  Spring Security
*  JWT Authentication
*  Searching
*  Sorting
*  Filtering
*  Docker Support
*  Deployment on Render
*  Unit & Integration Testing
*  CI/CD Pipeline using GitHub Actions

---

#  Learning Outcomes

This project demonstrates practical implementation of:

* Spring Boot REST APIs
* Layered Architecture
* Spring Data JPA
* Hibernate ORM
* DTO Pattern
* Pagination
* Global Exception Handling
* REST API Best Practices
* MySQL Integration
* Maven Project Management
* Swagger/OpenAPI Documentation

---

#  Author

**Harsh Dwivedi**

**GitHub**

https://github.com/harshdwivedi-tech

---

##  Support

If you found this project useful, consider giving it a **Star ⭐** on GitHub.

It helps others discover the project and motivates further development.
