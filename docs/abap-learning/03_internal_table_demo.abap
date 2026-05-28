REPORT z_internal_table_demo.

" Einfaches Beispiel fuer interne Tabellen in ABAP
" Interne Tabellen werden haeufig fuer Reports und Datenverarbeitung verwendet

TYPES: BEGIN OF ty_supplier,
         supplier_id TYPE i,
         name        TYPE string,
         city        TYPE string,
       END OF ty_supplier.

DATA: lt_suppliers TYPE STANDARD TABLE OF ty_supplier,
      ls_supplier  TYPE ty_supplier.

ls_supplier-supplier_id = 1.
ls_supplier-name        = 'Tech Supplier GmbH'.
ls_supplier-city        = 'Berlin'.
APPEND ls_supplier TO lt_suppliers.

ls_supplier-supplier_id = 2.
ls_supplier-name        = 'Office Supply GmbH'.
ls_supplier-city        = 'Hamburg'.
APPEND ls_supplier TO lt_suppliers.

WRITE: / 'Supplier List'.
WRITE: / '-------------'.

LOOP AT lt_suppliers INTO ls_supplier.
  WRITE: / ls_supplier-supplier_id,
           ls_supplier-name,
           ls_supplier-city.
ENDLOOP.
