package org.tensorflow.lite.examples.objectdetection.login;

import com.google.gson.annotations.SerializedName;

public class ObtenerUser {
    @SerializedName("params")
    private Params params;

    public ObtenerUser(String model, String db, String login, String password) {
        this.params = new Params(model, db, login, password);
    }

    private static class Params {
        @SerializedName("model")
        private String model;
        @SerializedName("db")
        private String db;
        @SerializedName("login")
        private String login;
        @SerializedName("password")
        private String password;

        public Params(String model, String db, String login, String password) {
            this.model = model;
            this.db = db;
            this.login = login;
            this.password = password;
        }
    }
}