package org.tensorflow.lite.examples.objectdetection.RetroFit

import JsonRequestParams
import RegistroResponse
import org.tensorflow.lite.examples.objectdetection.login.LoginResponse

import org.tensorflow.lite.examples.objectdetection.login.PalabraRespuesta
import org.tensorflow.lite.examples.objectdetection.login.PalabrasResponse

import org.tensorflow.lite.examples.objectdetection.login.Login
import org.tensorflow.lite.examples.objectdetection.login.ObtenerPalabra
import org.tensorflow.lite.examples.objectdetection.login.ObtenerPalabras
import org.tensorflow.lite.examples.objectdetection.login.ObtenerUser
import org.tensorflow.lite.examples.objectdetection.login.Registro
import org.tensorflow.lite.examples.objectdetection.login.UserData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface ConsumirApi {
    @POST("odoo-api/common/login")
    fun login(@Body request: Login?): Call<LoginResponse?>?

    @POST("odoo-api/object/create")
    fun registro(@Body request: Registro?): Call<RegistroResponse?>?

    @POST("odoo-api/gestos/search")
    fun obtenerpalabras(@Body request: ObtenerPalabras?): Call<PalabrasResponse?>?

    @POST("odoo-api/gestos/{id}")
    fun obtenerpalabra(@Path("id") id: String, @Body request: ObtenerPalabra?): Call<PalabraRespuesta?>?

    @POST("odoo-api/object/search/{id}")
    fun obtenerUser(@Path("id") id: String, @Body request: ObtenerUser?): Call<UserData?>?

    @POST("/odoo-api/object/write")
    fun writeToOdoo(@Body params: JsonRequestParams): Call<Any>

}
