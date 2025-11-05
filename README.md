# Portfolio Service

A Spring Boot REST API for managing portfolio data including **About**, **Work Experience**, **Projects**, and **Skills**. Implements modern practices like **global exception handling**, **BaseResponse standard**, and **Swagger/OpenAPI documentation**.

---

## Table of Contents

- [Features](#features)
- [Technologies](#technologies)
- [Getting Started](#getting-started)
- [API Endpoints](#api-endpoints)
- [Response Structure](#response-structure)
- [Global Exception Handling](#global-exception-handling)
- [Swagger Documentation](#swagger-documentation)
- [License](#license)

---

## Features

- CRUD operations for:
  - About information
  - Work experiences
  - Projects
  - Skills
- Centralized API response format with `BaseResponse`
- Global exception handling for validation and runtime errors
- Swagger/OpenAPI integration for easy API exploration
- CORS enabled
- MongoDB as the data store

---

## Technologies

- Java 17
- Spring Boot 3.x
- Spring Data MongoDB
- Lombok
- Jakarta Validation
- Swagger (springdoc-openapi)
- Maven

---

## Getting Started

### Prerequisites

- Java 17+
- Maven 3.9+
- MongoDB running locally on `mongodb://localhost:27017/portfolio`

### Installation

1. Clone the repository:

```bash
git clone https://github.com/<username>/portfolio-service.git
cd portfolio-service
