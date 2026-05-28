# Mini ERP Inventory Management System

A full-stack ERP-inspired inventory management system built with Java Spring Boot, Angular and MariaDB.

The project simulates basic ERP/SAP-like inventory processes such as material management, supplier management, stock movements and stock reporting.

## Project Goal

The goal of this project is to build a simple full-stack application that represents a small part of an ERP inventory module.

It focuses on:

- Products / Materials
- Suppliers
- Stock Movements
- Current Stock Reports
- Low Stock Reports
- Angular frontend for user interaction

This project was created as a portfolio project for Junior Java / SAP / ABAP Developer positions.

## SAP / ERP Relevance

This project is technically implemented with Java Spring Boot and Angular, but the business logic is inspired by ERP and SAP MM processes.

It includes ERP-related concepts such as:

- Material management
- Supplier management
- Goods receipt: `EINGANG`
- Goods issue: `AUSGANG`
- Current stock calculation
- Low-stock reporting
- REST-based interfaces between frontend and backend
- Unit tests for stock movement logic

A detailed explanation of the SAP-related business context is available here:

```text
docs/sap-relevance.md
```

## Tech Stack

### Backend

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- MariaDB / MySQL
- Hibernate
- Bean Validation
- Swagger / OpenAPI
- Maven
- JUnit
- Mockito

### Frontend

- Angular
- TypeScript
- HTML
- CSS
- Angular Routing
- Angular Services
- FormsModule
- HttpClient

### Tools

- Git
- GitHub
- VS Code
- XAMPP / MariaDB
- PowerShell

## Features

### Product / Material Management

- Create products
- Read all products
- Read product by ID
- Update products
- Delete products
- Search products by name or material number
- Validate required fields
- Unique material number
- Low stock status display in frontend

### Supplier Management

- Create suppliers
- Read all suppliers
- Read supplier by ID
- Update suppliers
- Delete suppliers
- Search suppliers by name or city

### Stock Movements

- Create stock movement records
- Incoming stock movement: `EINGANG`
- Outgoing stock movement: `AUSGANG`
- Automatic stock increase for incoming goods
- Automatic stock decrease for outgoing goods
- Validation for insufficient stock
- View stock movements by product
- Create stock movements from Angular frontend

### Stock Reports

- Current stock report
- Low stock report
- Minimum stock check
- Low stock highlighting in frontend

### Frontend Pages

- Products page
- Suppliers page
- Stock Movements page
- Stock Report page
- Navigation with Angular Router
- Forms for creating products, suppliers and stock movements
- Tables for displaying backend data

### Tests

The backend contains unit tests for the stock movement service.

Tested business logic:

- `EINGANG` increases the current stock
- `AUSGANG` decreases the current stock
- Goods issue is blocked if the available stock is not sufficient

## API Documentation

Swagger UI is available after starting the backend application:

```text
http://localhost:8080/swagger-ui.html
```

## Database

Database name:

```text
mini_erp_inventory
```

The application uses MariaDB / MySQL.

Example database creation:

```sql
CREATE DATABASE mini_erp_inventory;
```

## Backend Configuration

The database connection is configured in:

```text
src/main/resources/application.properties
```

Example configuration:

```properties
spring.datasource.url=jdbc:mariadb://localhost:3306/mini_erp_inventory
spring.datasource.username=root
spring.datasource.password=

spring.datasource.driver-class-name=org.mariadb.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

server.port=8080

springdoc.swagger-ui.path=/swagger-ui.html
```

## REST API Endpoints

### Products

```text
GET     /api/products
GET     /api/products/{id}
POST    /api/products
PUT     /api/products/{id}
DELETE  /api/products/{id}
GET     /api/products/search?keyword=laptop
```

### Suppliers

```text
GET     /api/suppliers
GET     /api/suppliers/{id}
POST    /api/suppliers
PUT     /api/suppliers/{id}
DELETE  /api/suppliers/{id}
GET     /api/suppliers/search?keyword=Berlin
```

### Stock Movements

```text
GET     /api/stock-movements
POST    /api/stock-movements
GET     /api/stock-movements/product/{productId}
```

### Reports

```text
GET     /api/reports/stock
GET     /api/reports/stock/low-stock
```

## Example Product Request

```json
{
  "materialNumber": "MAT-1001",
  "name": "Laptop Lenovo ThinkPad",
  "description": "Business Laptop fuer Mitarbeiter",
  "unit": "STK",
  "currentStock": 15,
  "minimumStock": 3
}
```

## Example Supplier Request

```json
{
  "name": "Tech Supplier GmbH",
  "contactPerson": "Max Mueller",
  "email": "max.mueller@techsupplier.de",
  "phone": "+49 30 123456",
  "city": "Berlin"
}
```

## Example Stock Movement Request

```json
{
  "productId": 1,
  "supplierId": 1,
  "movementType": "EINGANG",
  "quantity": 5,
  "note": "Wareneingang vom Lieferanten"
}
```

## How to Run the Project

### 1. Clone the repository

```powershell
git clone https://github.com/omar-software/mini-erp-inventory-management.git
```

### 2. Open the project folder

```powershell
cd mini-erp-inventory-management
```

### 3. Create the database

```sql
CREATE DATABASE mini_erp_inventory;
```

### 4. Start the backend

From the main project folder:

```powershell
.\mvnw spring-boot:run
```

The backend runs on:

```text
http://localhost:8080
```

Swagger UI:

```text
http://localhost:8080/swagger-ui.html
```

### 5. Start the frontend

Open a second terminal and go to the Angular frontend folder:

```powershell
cd frontend
```

Install dependencies:

```powershell
npm install
```

Start Angular:

```powershell
npm start
```

The frontend runs on:

```text
http://localhost:4200
```

## Running Tests

To run the backend tests:

```powershell
.\mvnw test
```

The tests verify important inventory business logic such as incoming and outgoing stock movements.

## Project Structure

```text
mini-erp-inventory
│
├── docs
│   └── sap-relevance.md
│
├── src
│   ├── main
│   │   └── java
│   │       └── com
│   │           └── omar
│   │               └── minierp
│   │                   │
│   │                   ├── controller
│   │                   │   ├── ProductController.java
│   │                   │   ├── SupplierController.java
│   │                   │   ├── StockMovementController.java
│   │                   │   └── ReportController.java
│   │                   │
│   │                   ├── dto
│   │                   │   ├── StockMovementRequest.java
│   │                   │   └── StockReportDTO.java
│   │                   │
│   │                   ├── entity
│   │                   │   ├── Product.java
│   │                   │   ├── Supplier.java
│   │                   │   ├── StockMovement.java
│   │                   │   └── MovementType.java
│   │                   │
│   │                   ├── repository
│   │                   │   ├── ProductRepository.java
│   │                   │   ├── SupplierRepository.java
│   │                   │   └── StockMovementRepository.java
│   │                   │
│   │                   ├── service
│   │                   │   ├── ProductService.java
│   │                   │   ├── SupplierService.java
│   │                   │   ├── StockMovementService.java
│   │                   │   └── ReportService.java
│   │                   │
│   │                   └── MiniErpInventoryApplication.java
│   │
│   └── test
│       └── java
│           └── com
│               └── omar
│                   └── minierp
│                       └── service
│                           └── StockMovementServiceTest.java
│
├── frontend
│   └── src
│       └── app
│           │
│           ├── models
│           │   ├── product.ts
│           │   ├── supplier.ts
│           │   ├── stock-movement.ts
│           │   ├── stock-movement-request.ts
│           │   └── stock-report.ts
│           │
│           ├── services
│           │   ├── product.ts
│           │   ├── supplier.ts
│           │   ├── stock-movement.ts
│           │   └── report.ts
│           │
│           ├── pages
│           │   ├── products
│           │   ├── suppliers
│           │   ├── stock-movements
│           │   └── stock-report
│           │
│           ├── app.routes.ts
│           ├── app.config.ts
│           ├── app.html
│           ├── app.css
│           └── app.ts
│
├── pom.xml
└── README.md
```

## Frontend Pages

### Products Page

```text
http://localhost:4200/products
```

Features:

- Display products from backend
- Add new product
- Search products
- Delete product
- Show low stock status

### Suppliers Page

```text
http://localhost:4200/suppliers
```

Features:

- Display suppliers from backend
- Add new supplier
- Search suppliers
- Delete supplier

### Stock Movements Page

```text
http://localhost:4200/stock-movements
```

Features:

- Select product
- Select supplier
- Create `EINGANG` movement
- Create `AUSGANG` movement
- Display stock movement history
- Automatically update current stock

### Stock Report Page

```text
http://localhost:4200/stock-report
```

Features:

- Display current stock
- Show low stock products
- Highlight low stock rows

## Portfolio Relevance

This project demonstrates practical knowledge of:

- Java Spring Boot backend development
- REST API design
- Database modeling with JPA entities
- ERP-inspired inventory processes
- Material and supplier management
- Stock movement logic
- Angular frontend development
- Angular services and routing
- REST API integration with Angular HttpClient
- API documentation with Swagger
- Unit testing with JUnit and Mockito
- Git and GitHub workflow
- SAP-related business process documentation

## Future Improvements

- Authentication and authorization
- Dashboard with inventory statistics
- Pagination and sorting
- Better exception handling
- More unit and integration tests
- Docker setup
- UI improvements with Bootstrap or Angular Material
- SAP UI5 / Fiori learning demo
- SAP CAP learning demo