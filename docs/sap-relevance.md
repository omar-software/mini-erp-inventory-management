# SAP-Relevanz des Projekts

Dieses Dokument beschreibt, wie das Projekt **Mini ERP Inventory Management System** mit typischen ERP- und SAP-nahen Geschäftsprozessen zusammenhängt.

Das Projekt wurde nicht mit einem echten SAP-System oder ABAP entwickelt.  
Es dient als praxisnahes Lern- und Portfolio-Projekt, um grundlegende ERP-Prozesse technisch zu verstehen und mit modernen Web-Technologien umzusetzen.

## Bezug zu ERP und SAP

ERP-Systeme wie SAP unterstützen Unternehmen bei der Verwaltung von Geschäftsprozessen, zum Beispiel in den Bereichen Materialwirtschaft, Einkauf, Lagerverwaltung und Reporting.

Dieses Projekt bildet einen kleinen, vereinfachten Ausschnitt solcher Prozesse ab.

Der Fokus liegt auf:

- Materialverwaltung
- Lieferantenverwaltung
- Lagerbewegungen
- Wareneingang
- Warenausgang
- Aktuellem Lagerbestand
- Low-Stock-Berichten
- REST-Schnittstellen zwischen Frontend und Backend

## Bezug zu SAP MM

Das Projekt orientiert sich fachlich an Prozessen aus dem Bereich **SAP MM (Materials Management)**.

### Materialverwaltung

Im Projekt werden Produkte als Materialien abgebildet.

Beispiele:

- Materialnummer
- Materialname
- Beschreibung
- Mengeneinheit
- Aktueller Lagerbestand
- Mindestbestand

Diese Struktur ist an das Konzept eines Materialstamms angelehnt.

### Lieferantenverwaltung

Lieferanten werden im Projekt separat verwaltet.

Ein Lieferant enthält zum Beispiel:

- Name
- Ansprechpartner
- E-Mail
- Telefonnummer
- Stadt

Dies ist fachlich vergleichbar mit einfachen Lieferantenstammdaten in einem ERP-System.

### Wareneingang

Ein Wareneingang wird im Projekt durch den Bewegungstyp `EINGANG` dargestellt.

Wenn ein Wareneingang gebucht wird, erhöht das System automatisch den aktuellen Lagerbestand des ausgewählten Materials.

Beispiel:

```text
Material: MAT-1002 - Monitor Samsung
Aktueller Bestand: 5
Wareneingang: 3
Neuer Bestand: 8
```

### Warenausgang

Ein Warenausgang wird im Projekt durch den Bewegungstyp `AUSGANG` dargestellt.

Wenn ein Warenausgang gebucht wird, reduziert das System automatisch den aktuellen Lagerbestand.

Zusätzlich prüft das Backend, ob genügend Bestand vorhanden ist.

Beispiel:

```text
Aktueller Bestand: 8
Warenausgang: 3
Neuer Bestand: 5
```

Wenn der Bestand nicht ausreicht, wird die Buchung verhindert.

## Reports

Das Projekt enthält einfache Lagerberichte.

### Aktueller Lagerbestand

Der Stock Report zeigt pro Material:

- Materialnummer
- Materialname
- Mengeneinheit
- Aktuellen Bestand
- Mindestbestand
- Status

### Low-Stock-Bericht

Wenn der aktuelle Bestand kleiner oder gleich dem Mindestbestand ist, wird das Material als `Low Stock` markiert.

Dies entspricht einem einfachen Bestandswarnsystem.

## Schnittstellen

Das Backend stellt REST-Schnittstellen bereit.

Beispiele:

```text
GET     /api/products
POST    /api/products
GET     /api/suppliers
POST    /api/stock-movements
GET     /api/reports/stock
GET     /api/reports/stock/low-stock
```

Diese Schnittstellen verbinden das Angular-Frontend mit dem Spring-Boot-Backend.

Auch wenn das Projekt kein OData verwendet, zeigt es das Grundprinzip einer datenbasierten Kommunikation zwischen Benutzeroberfläche und Backend-System.

## Bezug zu ABAP-Entwicklung

In der ABAP-Entwicklung werden häufig Reports, Erweiterungen und Schnittstellen für Geschäftsprozesse erstellt.

Dieses Projekt bereitet fachlich auf solche Aufgaben vor, weil es typische betriebliche Abläufe technisch abbildet:

- Materialien anzeigen und verwalten
- Lieferanten anzeigen und verwalten
- Lagerbewegungen buchen
- Bestände berechnen
- Berichte erstellen
- Schnittstellen bereitstellen
- Validierungen durchführen
- Geschäftslogik testen

Die technische Umsetzung erfolgt hier mit Java Spring Boot und Angular, die fachliche Logik ist jedoch ERP- und SAP-nah.

## Bezug zur Stellenausschreibung Junior ABAP Developer

Das Projekt passt besonders zu Junior-Rollen im SAP-Umfeld, weil es folgende Themen berührt:

- ERP-Prozesse
- Materialwirtschaft
- Lagerverwaltung
- Reports
- Schnittstellen
- Validierung
- Tests
- Frontend-Backend-Kommunikation
- Strukturierte Softwareentwicklung
- GitHub-Dokumentation

## Technische Umsetzung

Das Projekt besteht aus zwei Hauptteilen.

### Backend

Das Backend wurde mit Java Spring Boot umgesetzt.

Verwendete Konzepte:

- REST Controller
- Service Layer
- Repository Layer
- JPA Entities
- DTOs
- Bean Validation
- MariaDB-Anbindung
- Swagger / OpenAPI
- Unit Tests mit JUnit und Mockito

### Frontend

Das Frontend wurde mit Angular umgesetzt.

Verwendete Konzepte:

- Angular Components
- Angular Routing
- Angular Services
- HttpClient
- FormsModule
- Tabellenansichten
- Formulare
- Statusanzeigen

## Fazit

Das Projekt ist ein praxisnahes Full-Stack-Lernprojekt mit ERP- und SAP-MM-nahem fachlichem Bezug.

Es zeigt, dass grundlegende Geschäftsprozesse wie Materialverwaltung, Lieferantenverwaltung, Wareneingang, Warenausgang und Lagerbestandsberichte verstanden und technisch umgesetzt wurden.

Damit eignet sich das Projekt gut als Portfolio-Projekt für Bewerbungen im Bereich:

- Junior Java Developer
- Junior SAP Developer
- Junior ABAP Developer
- ERP-Anwendungsentwickler
- Full-Stack Junior Developer