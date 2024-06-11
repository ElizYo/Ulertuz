package org.tensorflow.lite.examples.objectdetection.login;

import com.google.gson.annotations.SerializedName;

public class Login {
    @SerializedName("params")
    private Params params;

    public Login(String db, String login, String password) {
        this.params = new Params(db, login, password);
    }
    private class Params {
        @SerializedName("db")
        private String db;
        @SerializedName("login")
        private String login;
        @SerializedName("password")
        private String password;

        public Params(String db, String login, String password) {
            this.db = db;
            this.login = login;
            this.password = password;
        }
    }
}
