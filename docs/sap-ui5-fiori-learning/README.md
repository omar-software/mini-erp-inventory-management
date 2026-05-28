# SAP UI5 / Fiori Learning Demo

This folder contains a small SAP UI5 / Fiori-style learning demo related to the Mini ERP Inventory Management System.

The goal is to understand basic SAP UI5 concepts that are relevant for Junior SAP / ABAP Developer roles.

## Purpose

This is not a productive SAP application.  
It is a learning example that shows how ERP-related data such as materials and stock status could be displayed in a Fiori-style UI.

## Covered Topics

- SAP UI5 bootstrap
- XML View
- Controller
- JSON Model
- Simple material list
- Stock status display
- Fiori-style structure

## Relation to the Main Project

The main project uses Angular as frontend technology.

This additional learning demo shows how similar material and stock data could be displayed with SAP UI5 / Fiori concepts.

## Example Use Case

The demo displays materials with:

- Material number
- Material name
- Unit
- Current stock
- Minimum stock
- Stock status

## Folder Structure

```text
webapp
├── controller
│   └── App.controller.js
├── model
│   └── materials.json
├── view
│   └── App.view.xml
├── index.html
└── manifest.json

##SAP Relevance

This demo is related to the job requirements:

SAP UI5
Fiori
ERP-related frontend development
Material and stock overview