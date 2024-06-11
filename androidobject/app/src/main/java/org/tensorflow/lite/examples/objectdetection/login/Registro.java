package org.tensorflow.lite.examples.objectdetection.login;

import com.google.gson.annotations.SerializedName;

public class Registro {
    @SerializedName("params")
    private Params params;

    public Registro(String name, String email, String login, String password) {
        this.params = new Params(name, email, login, password);
    }

    private static class Params {
        @SerializedName("model")
        private final String model = "res.users";

        @SerializedName("vals")
        private Vals vals;

        @SerializedName("db")
        private final String db = "odoo";

        @SerializedName("login")
        private final String login = "odoo";

        @SerializedName("password")
        private final String password = "odoo";

        public Params(String name, String email, String login, String password) {
            this.vals = new Vals(name, login, password, email);
        }
    }

    private static class Vals {
        @SerializedName("name")
        private String name;

        @SerializedName("login")
        private String login;

        @SerializedName("password")
        private String password;

        @SerializedName("email")
        private String email;

        public Vals(String name, String login, String password, String email) {
            this.name = name;
            this.login = login;
            this.password = password;
            this.email = email;
        }
    }
}
