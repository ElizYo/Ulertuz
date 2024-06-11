package org.tensorflow.lite.examples.objectdetection.login

import com.google.gson.annotations.SerializedName

class PalabrasResponse {
    @SerializedName("jsonrpc")
    var jsonrpc: String? = null
        private set

    @SerializedName("id")
    var id: Any? = null
        private set

    @SerializedName("result")
    var result: List<Result>? = null
        internal set
}

class Result {
    @SerializedName("id")
    var id = 0
        private set

    @SerializedName("nombre")
    var nombre: String? = null
        private set

    @SerializedName("imagenes")
    var imagenes: List<Imagen>? = null
        private set

    @SerializedName("descripcion")
    var descripcion: String? = null
        private set

    @SerializedName("categoria")
    var categoria: String? = null
        private set
}

class Imagen {
    @SerializedName("nombre")
    var nombre: String? = null
        private set

    @SerializedName("url")
    var url: String? = null
        private set
}

