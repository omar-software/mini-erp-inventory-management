# SAP CAP / BTP Learning Notes

This folder contains learning notes about SAP CAP and SAP BTP in relation to the Mini ERP Inventory Management System.

The goal is to understand basic cloud and SAP development concepts that are mentioned in Junior SAP / ABAP Developer job descriptions.

## What is SAP BTP?

SAP BTP stands for SAP Business Technology Platform.

It is a cloud platform used to build, extend and integrate SAP applications.

Typical use cases:

- Build cloud applications
- Extend SAP S/4HANA
- Integrate systems
- Develop services and APIs
- Use SAP Fiori / UI5 frontends
- Deploy business applications to the cloud

## What is SAP CAP?

SAP CAP stands for Cloud Application Programming Model.

It is a framework from SAP for building enterprise applications.

CAP applications often contain:

- Data models
- Services
- Business logic
- APIs
- Integration with SAP systems
- Deployment to SAP BTP

CAP can be used with Node.js or Java.

## Relation to This Project

The Mini ERP Inventory Management System was built with:

- Java Spring Boot backend
- Angular frontend
- MariaDB database
- REST API
- Swagger documentation

A similar SAP CAP application could contain:

- CDS data model for materials
- CDS data model for suppliers
- Service for stock movements
- Service for stock reports
- Fiori / UI5 frontend
- Deployment to SAP BTP

## Possible CAP Data Model Idea

The following business entities from the project could be represented in CAP:

- Products / Materials
- Suppliers
- Stock Movements
- Stock Reports

## Example CAP-Style Entity Idea

```text
entity Products {
  key ID          : Integer;
      materialNo  : String;
      name        : String;
      unit        : String;
      stock       : Integer;
      minStock    : Integer;
}
```

## Example CAP-Style Service Idea

```text
service InventoryService {
  entity Products as projection on db.Products;
  entity Suppliers as projection on db.Suppliers;
  entity StockMovements as projection on db.StockMovements;
}
```

## SAP BTP Relevance

This project is not deployed to SAP BTP.

However, the architecture is similar to cloud-based enterprise applications:

```text
Frontend
   |
REST API / Service Layer
   |
Business Logic
   |
Database
```

In SAP BTP / CAP, a similar structure could be:

```text
SAP UI5 / Fiori Frontend
   |
CAP Service
   |
CDS Model
   |
Database
```

## Job Advertisement Relevance

This learning note relates to job requirements such as:

- SAP BTP
- CAP
- Cloud development
- Modern SAP solutions
- ERP-related applications
- Service-based architecture
- Frontend-backend integration

## Summary

These notes show a basic understanding of how the Mini ERP project could conceptually be transferred into the SAP CAP / BTP world.

The current project is implemented with Java Spring Boot and Angular, while these notes document the learning connection to SAP cloud technologies.