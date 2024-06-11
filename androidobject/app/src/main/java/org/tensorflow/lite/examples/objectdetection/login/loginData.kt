package org.tensorflow.lite.examples.objectdetection.login

import com.google.gson.annotations.SerializedName


class LoginResponse {
    @SerializedName("result")
    val result: Result? = null

    inner class Result {
        @SerializedName("user_uid")
        val userUid = 0

        @SerializedName("authentification")
        val isAuthentication = false
    }
}



