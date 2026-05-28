sap.ui.define([
    "sap/ui/core/mvc/Controller"
], function (Controller) {
    "use strict";

    return Controller.extend("mini.erp.demo.controller.App", {

        onInit: function () {
            // Wird beim Start der View ausgefuehrt
            // Das JSON Model wird ueber manifest.json geladen
        },

        formatStatusState: function (sStatus) {
            // Statusanzeige im Fiori-Stil
            if (sStatus === "Low Stock") {
                return "Warning";
            }

            return "Success";
        }

    });
});