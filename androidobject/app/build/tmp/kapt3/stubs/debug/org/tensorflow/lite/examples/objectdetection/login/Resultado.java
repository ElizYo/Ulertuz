package org.tensorflow.lite.examples.objectdetection.login;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R$\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@BX\u0087\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R$\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@BX\u0087\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8\u0006@BX\u0087\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR0\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006@BX\u0087\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@BX\u0087\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0007\u00a8\u0006\u0015"}, d2 = {"Lorg/tensorflow/lite/examples/objectdetection/login/Resultado;", "", "()V", "<set-?>", "", "categoria", "getCategoria", "()Ljava/lang/String;", "descripcion", "getDescripcion", "", "id", "getId", "()I", "", "Lorg/tensorflow/lite/examples/objectdetection/login/Imagenes;", "imagenes", "getImagenes", "()Ljava/util/List;", "nombre", "getNombre", "app_debug"})
public final class Resultado {
    @com.google.gson.annotations.SerializedName(value = "id")
    private int id = 0;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "nombre")
    private java.lang.String nombre;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "imagenes")
    private java.util.List<org.tensorflow.lite.examples.objectdetection.login.Imagenes> imagenes;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "descripcion")
    private java.lang.String descripcion;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "categoria")
    private java.lang.String categoria;
    
    public Resultado() {
        super();
    }
    
    public final int getId() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getNombre() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<org.tensorflow.lite.examples.objectdetection.login.Imagenes> getImagenes() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getDescripcion() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getCategoria() {
        return null;
    }
}