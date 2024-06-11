package org.tensorflow.lite.examples.objectdetection.login

import com.google.gson.annotations.SerializedName

class UserData {
    @SerializedName("jsonrpc")
    var jsonrpc: String? = null
        private set

    @SerializedName("id")
    var id: Any? = null
        private set

    @SerializedName("result")
    var result: ResultUser? = null
        internal set
}

class ResultUser {

    @SerializedName("name")
    var name: String? = null
        private set

    @SerializedName("login")
    var login: String? = null
        private set

    @SerializedName("email")
    var email: String? = null
        private set

    @SerializedName("image_url")
    var image_url: String? = null
        private set
}