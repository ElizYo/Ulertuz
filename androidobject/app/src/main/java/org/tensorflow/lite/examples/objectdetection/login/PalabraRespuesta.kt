package org.tensorflow.lite.examples.objectdetection.login
import com.google.gson.annotations.SerializedName

class PalabraRespuesta {
    @SerializedName("jsonrpc")
    var jsonrpc: String? = null
        private set

    @SerializedName("id")
    var id: Any? = null
        private set

    @SerializedName("result")
    var result: Resultado? = null
        internal set
}

class Resultado {
    @SerializedName("id")
    var id = 0
        private set

    @SerializedName("nombre")
    var nombre: String? = null
        private set

    @SerializedName("imagenes")
    var imagenes: List<Imagenes>? = null
        private set

    @SerializedName("descripcion")
    var descripcion: String? = null
        private set

    @SerializedName("categoria")
    var categoria: String? = null
        private set
}

class Imagenes {
    @SerializedName("nombre")
    var nombre: String? = null
        private set

    @SerializedName("url")
    var url: String? = null
        private set
}

data class Palabra(val nombre: String, val id: Int)