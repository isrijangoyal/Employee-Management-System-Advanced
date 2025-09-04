# Employee Management System
A Spring Boot RESTful API for managing employees, built with modern backend practices.
This project demonstrates CRUD operations, validation, error handling, database integration, 
Swagger documentation, and role-based authentication.

---

## Features
- **CRUD Operations** -
*Create, Read, Update, Delete* employees.
Supports both single employee creation and bulk insert.

- **Validation** -
`name` : must be a non-empty string.
`email` : must follow a valid format `(abc@abc.ab)`.
`salary` : must be a positive number.

- **Error Handling** -
Returns meaningful error messages (e.g., invalid input, resource not found).
Standard HTTP response codes (`400`, `404`, `500`).

- **Partial Updates (PATCH)** -
Update only selected fields without overwriting the entire employee record.

- **Database Integration (MySQL)** -
Data persisted in MySQL using Spring Data JPA & Hibernate.

- **Authentication & Authorization** -
Basic authentication enabled.
Only users with HR role can access `/api/employees/**` endpoints.
Unauthorized users receive `401 Unauthorized` or `403 Forbidden`.

---

## Tech Stack
- **Backend** - Java 21, Spring Boot 3
- **Database** - MySQL + Spring Data JPA + Hibernate
- **Validation** - Jakarta Validation (`@Valid`, `@Email`, `@NotBlank`, `@Positive`)
- **Authentication** - Spring Security (Basic Auth, Role-based Access)
- **Build Tool** - Maven

---
