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
- SAP / ERP-related learning documentation
- ABAP, SAP UI5 / Fiori and SAP CAP / BTP learning examples

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

## ABAP Learning Examples

This repository also contains small ABAP learning examples related to the ERP inventory process.

The examples are located in:

```text
docs/abap-learning
```

Covered ABAP topics:

- Simple ABAP report
- Internal tables
- LOOP processing
- WRITE output
- ABAP OO basics
- Stock calculation example
- ERP-inspired material and supplier examples

These examples are intended as a learning addition for Junior ABAP Developer roles.

## SAP UI5 / Fiori Learning Demo

The repository contains a small SAP UI5 / Fiori-style learning demo.

The demo is located in:

```text
docs/sap-ui5-fiori-learning
```

The demo shows a simple material stock overview using SAP UI5 concepts.

Covered topics:

- SAP UI5 bootstrap
- Fiori-style UI structure
- Material stock overview
- Object status display
- Low-stock / OK status
- ERP-related frontend example

This learning demo is related to job requirements such as SAP UI5, Fiori and modern SAP frontend development.

## SAP CAP / BTP Learning Notes

The repository also contains learning notes about SAP CAP and SAP BTP.

The documentation is located in:

```text
docs/sap-cap-btp-learning
```

Covered topics:

- SAP BTP basics
- SAP CAP basics
- CAP-style entity idea
- CAP-style service idea
- Concept mapping from the Mini ERP project to SAP CAP / BTP
- Relation to cloud-based SAP development

These notes show how the project concepts could be transferred conceptually into the SAP CAP / BTP world.

## Code Quality and Extension Notes

The repository contains documentation about code structure, possible extensions and simple code review points.

The document is located in:

```text
docs/code-quality-and-extensions.md
```

The document covers:

- Layered backend architecture
- Controller, service and repository responsibilities
- DTO usage
- Validation
- Unit testing
- Code review checklist
- Possible ERP / SAP-related extensions

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

### SAP / ERP Learning

- ABAP basics
- ABAP OO basics
- Internal tables
- SAP UI5 / Fiori learning demo
- SAP CAP / BTP learning notes
- SAP MM-inspired process documentation

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

## Running the SAP UI5 / Fiori Learning Demo

Go to the UI5 demo folder:

```powershell
cd docs\sap-ui5-fiori-learning\webapp
```

Start a simple local server:

```powershell
python -m http.server 5500
```

Open the demo in the browser:

```text
http://localhost:5500
```

The demo shows a simple SAP UI5 / Fiori-style material stock overview.

## Project Structure

```text
mini-erp-inventory
│
├── docs
│   ├── sap-relevance.md
│   ├── code-quality-and-extensions.md
│   │
│   ├── abap-learning
│   │   ├── README.md
│   │   ├── 01_material_stock_report.abap
│   │   ├── 02_stock_service_abap_oo.abap
│   │   └── 03_internal_table_demo.abap
│   │
│   ├── sap-ui5-fiori-learning
│   │   ├── README.md
│   │   └── webapp
│   │       ├── index.html
│   │       ├── manifest.json
│   │       ├── Component.js
│   │       ├── controller
│   │       ├── model
│   │       └── view
│   │
│   └── sap-cap-btp-learning
│       ├── README.md
│       └── concept-mapping.md
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

## SAP / Job Advertisement Coverage

This project covers several topics from Junior ABAP / SAP Developer job descriptions.

Covered topics:

- ABAP basics
- ABAP OO basics
- Reports
- Internal tables
- ERP processes
- SAP MM-inspired material management
- SAP UI5 / Fiori learning demo
- SAP CAP / BTP learning notes
- Interfaces / REST APIs
- Testing with JUnit and Mockito
- Code quality documentation
- Possible application extensions
- Java and TypeScript programming experience

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
- ABAP learning examples
- SAP UI5 / Fiori learning concepts
- SAP CAP / BTP learning concepts
- Code quality and extension planning

## Future Improvements

- Authentication and authorization
- Dashboard with inventory statistics
- Pagination and sorting
- Better exception handling
- More unit and integration tests
- Docker setup
- UI improvements with Bootstrap or Angular Material
- More advanced ABAP examples
- OData-style service documentation
- CAP demo project with CDS model