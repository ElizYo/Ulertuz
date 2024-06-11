package org.tensorflow.lite.examples.objectdetection.login;

import com.google.gson.annotations.SerializedName;

public class ObtenerPalabras {

    @SerializedName("params")
    private Params params;

    public ObtenerPalabras(Object[][] filters) {
        this.params = new Params(filters);
    }

    public static class Params {

        @SerializedName("filters")
        private Object[][] filters;

        @SerializedName("db")
        private final String db = "odoo";

        @SerializedName("login")
        private final String login = "odoo";

        @SerializedName("password")
        private final String password = "odoo";

        public Params(Object[][] filters) {
            this.filters = filters;
        }
    }
}

