package org.tensorflow.lite.examples.objectdetection.RetroFit;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\'J(\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00032\b\b\u0001\u0010\t\u001a\u00020\n2\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u000bH\'J(\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u00032\b\b\u0001\u0010\t\u001a\u00020\n2\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u000eH\'J\u001e\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0011H\'J\u001e\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0014H\'J\u0018\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u0016\u001a\u00020\u0017H\'\u00a8\u0006\u0018"}, d2 = {"Lorg/tensorflow/lite/examples/objectdetection/RetroFit/ConsumirApi;", "", "login", "Lretrofit2/Call;", "Lorg/tensorflow/lite/examples/objectdetection/login/LoginResponse;", "request", "Lorg/tensorflow/lite/examples/objectdetection/login/Login;", "obtenerUser", "Lorg/tensorflow/lite/examples/objectdetection/login/UserData;", "id", "", "Lorg/tensorflow/lite/examples/objectdetection/login/ObtenerUser;", "obtenerpalabra", "Lorg/tensorflow/lite/examples/objectdetection/login/PalabraRespuesta;", "Lorg/tensorflow/lite/examples/objectdetection/login/ObtenerPalabra;", "obtenerpalabras", "Lorg/tensorflow/lite/examples/objectdetection/login/PalabrasResponse;", "Lorg/tensorflow/lite/examples/objectdetection/login/ObtenerPalabras;", "registro", "LRegistroResponse;", "Lorg/tensorflow/lite/examples/objectdetection/login/Registro;", "writeToOdoo", "params", "LJsonRequestParams;", "app_debug"})
public abstract interface ConsumirApi {
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.POST(value = "odoo-api/common/login")
    public abstract retrofit2.Call<org.tensorflow.lite.examples.objectdetection.login.LoginResponse> login(@org.jetbrains.annotations.Nullable
    @retrofit2.http.Body
    org.tensorflow.lite.examples.objectdetection.login.Login request);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.POST(value = "odoo-api/object/create")
    public abstract retrofit2.Call<RegistroResponse> registro(@org.jetbrains.annotations.Nullable
    @retrofit2.http.Body
    org.tensorflow.lite.examples.objectdetection.login.Registro request);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.POST(value = "odoo-api/gestos/search")
    public abstract retrofit2.Call<org.tensorflow.lite.examples.objectdetection.login.PalabrasResponse> obtenerpalabras(@org.jetbrains.annotations.Nullable
    @retrofit2.http.Body
    org.tensorflow.lite.examples.objectdetection.login.ObtenerPalabras request);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.POST(value = "odoo-api/gestos/{id}")
    public abstract retrofit2.Call<org.tensorflow.lite.examples.objectdetection.login.PalabraRespuesta> obtenerpalabra(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Path(value = "id")
    java.lang.String id, @org.jetbrains.annotations.Nullable
    @retrofit2.http.Body
    org.tensorflow.lite.examples.objectdetection.login.ObtenerPalabra request);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.POST(value = "odoo-api/object/search/{id}")
    public abstract retrofit2.Call<org.tensorflow.lite.examples.objectdetection.login.UserData> obtenerUser(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Path(value = "id")
    java.lang.String id, @org.jetbrains.annotations.Nullable
    @retrofit2.http.Body
    org.tensorflow.lite.examples.objectdetection.login.ObtenerUser request);
    
    @org.jetbrains.annotations.NotNull
    @retrofit2.http.POST(value = "/odoo-api/object/write")
    public abstract retrofit2.Call<java.lang.Object> writeToOdoo(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Body
    JsonRequestParams params);
}