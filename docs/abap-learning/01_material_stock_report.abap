REPORT z_material_stock_report.

" Einfacher ABAP-Report fuer Materialbestand
" Dieses Beispiel ist ein Lernbeispiel und orientiert sich am Mini ERP Projekt

TYPES: BEGIN OF ty_material,
         material_number TYPE string,
         material_name   TYPE string,
         unit            TYPE string,
         current_stock   TYPE i,
         minimum_stock   TYPE i,
       END OF ty_material.

DATA: lt_materials TYPE STANDARD TABLE OF ty_material,
      ls_material  TYPE ty_material.

" Beispieldaten wie im Mini ERP Projekt
ls_material-material_number = 'MAT-1001'.
ls_material-material_name   = 'Laptop Lenovo ThinkPad'.
ls_material-unit            = 'STK'.
ls_material-current_stock   = 3.
ls_material-minimum_stock   = 3.
APPEND ls_material TO lt_materials.

ls_material-material_number = 'MAT-1002'.
ls_material-material_name   = 'Monitor Samsung'.
ls_material-unit            = 'STK'.
ls_material-current_stock   = 8.
ls_material-minimum_stock   = 2.
APPEND ls_material TO lt_materials.

WRITE: / 'Material Stock Report'.
WRITE: / '---------------------'.

LOOP AT lt_materials INTO ls_material.

  WRITE: / 'Materialnummer:', ls_material-material_number.
  WRITE: / 'Name:', ls_material-material_name.
  WRITE: / 'Einheit:', ls_material-unit.
  WRITE: / 'Aktueller Bestand:', ls_material-current_stock.
  WRITE: / 'Mindestbestand:', ls_material-minimum_stock.

  IF ls_material-current_stock <= ls_material-minimum_stock.
    WRITE: / 'Status: LOW STOCK'.
  ELSE.
    WRITE: / 'Status: OK'.
  ENDIF.

  WRITE: / '---------------------'.

ENDLOOP.