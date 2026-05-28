REPORT z_stock_service_abap_oo.

" Einfaches ABAP-OO-Beispiel fuer Lagerbewegungen
" Ziel: Wareneingang und Warenausgang logisch abbilden

CLASS lcl_stock_service DEFINITION.

  PUBLIC SECTION.
    METHODS:
      increase_stock
        IMPORTING
          iv_current_stock TYPE i
          iv_quantity      TYPE i
        RETURNING
          VALUE(rv_stock)  TYPE i,

      decrease_stock
        IMPORTING
          iv_current_stock TYPE i
          iv_quantity      TYPE i
        RETURNING
          VALUE(rv_stock)  TYPE i.

ENDCLASS.

CLASS lcl_stock_service IMPLEMENTATION.

  METHOD increase_stock.
    " Wareneingang: Bestand wird erhoeht
    rv_stock = iv_current_stock + iv_quantity.
  ENDMETHOD.

  METHOD decrease_stock.
    " Warenausgang: Bestand wird reduziert
    IF iv_current_stock < iv_quantity.
      WRITE: / 'Fehler: Nicht genug Lagerbestand vorhanden.'.
      rv_stock = iv_current_stock.
    ELSE.
      rv_stock = iv_current_stock - iv_quantity.
    ENDIF.
  ENDMETHOD.

ENDCLASS.

DATA: lo_stock_service TYPE REF TO lcl_stock_service,
      lv_stock         TYPE i.

CREATE OBJECT lo_stock_service.

lv_stock = 5.

WRITE: / 'Startbestand:', lv_stock.

lv_stock = lo_stock_service->increase_stock(
  iv_current_stock = lv_stock
  iv_quantity      = 3
).

WRITE: / 'Nach Wareneingang:', lv_stock.

lv_stock = lo_stock_service->decrease_stock(
  iv_current_stock = lv_stock
  iv_quantity      = 2
).

WRITE: / 'Nach Warenausgang:', lv_stock.
