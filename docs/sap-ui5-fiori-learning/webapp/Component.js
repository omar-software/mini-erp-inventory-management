sap.ui.define([
    "sap/ui/core/UIComponent"
], function (UIComponent) {
    "use strict";

    return UIComponent.extend("mini.erp.demo.Component", {

        metadata: {
            manifest: "json"
        },

        init: function () {
            // Standard-Initialisierung der UI5 Component
            UIComponent.prototype.init.apply(this, arguments);
        }
    });
});