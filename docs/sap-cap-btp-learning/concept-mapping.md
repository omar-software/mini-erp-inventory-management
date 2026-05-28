# Concept Mapping: Mini ERP Project to SAP CAP / BTP

This document maps the current Mini ERP Inventory Management System to SAP CAP and SAP BTP concepts.

## Current Project Architecture

```text
Angular Frontend
    |
Spring Boot REST API
    |
Service Layer
    |
JPA Repositories
    |
MariaDB Database
```

## Possible SAP CAP / BTP Architecture

```text
SAP UI5 / Fiori Frontend
    |
CAP Service
    |
CDS Data Model
    |
SAP HANA Cloud or SQLite for local development
```

## Entity Mapping

| Current Project | SAP / CAP Concept |
|---|---|
| Product Entity | CDS Entity: Product / Material |
| Supplier Entity | CDS Entity: Supplier |
| StockMovement Entity | CDS Entity: StockMovement |
| StockReportDTO | CAP Service Projection / Report View |
| ProductController | CAP Service Endpoint |
| ProductService | CAP Business Logic |
| Angular Frontend | SAP UI5 / Fiori Frontend |

## Process Mapping

| Current Process | SAP / ERP Term |
|---|---|
| Create Product | Material anlegen |
| Create Supplier | Lieferant anlegen |
| EINGANG | Wareneingang |
| AUSGANG | Warenausgang |
| Current Stock | Aktueller Lagerbestand |
| Low Stock Report | Mindestbestand / Bestandswarnung |

## Why This Is Useful

The current project helps understand business processes before implementing them in SAP technologies.

For a Junior ABAP / SAP Developer role, it is important to understand both:

- Technical implementation
- Business process logic

This project covers the business logic and connects it to SAP-related learning topics.