package org.tensorflow.lite.examples.objectdetection.fragments;

import java.lang.System;

/**
 * A simple [Fragment] subclass.
 * Use the [PerfilFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 *2\u00020\u0001:\u0001*B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0016H\u0002J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0006H\u0002J\n\u0010\u001c\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\u001d\u001a\u00020\u00162\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J&\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010&\u001a\u00020\u0016H\u0002J\u0010\u0010\'\u001a\u00020\u00162\u0006\u0010(\u001a\u00020)H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00060\u00060\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u0006X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\bR\u0014\u0010\u0010\u001a\u00020\u0006X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\bR\u0014\u0010\u0012\u001a\u00020\u0006X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\bR\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lorg/tensorflow/lite/examples/objectdetection/fragments/PerfilFragment;", "Landroidx/fragment/app/Fragment;", "()V", "apiService", "Lorg/tensorflow/lite/examples/objectdetection/RetroFit/ConsumirApi;", "db", "", "getDb", "()Ljava/lang/String;", "galleryLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "kotlin.jvm.PlatformType", "imageView", "Landroid/widget/ImageView;", "login", "getLogin", "model", "getModel", "password", "getPassword", "userUid", "enviarDatos", "", "jsonRequestParams", "LJsonRequestParams;", "guardarCambios", "obtenerDatosUser", "id", "obtenerImagenBase64", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "openGallery", "updateUI", "userData", "Lorg/tensorflow/lite/examples/objectdetection/login/UserData;", "Companion", "app_debug"})
public final class PerfilFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String db = "odoo";
    @org.jetbrains.annotations.NotNull
    private final java.lang.String login = "odoo";
    @org.jetbrains.annotations.NotNull
    private final java.lang.String password = "odoo";
    @org.jetbrains.annotations.NotNull
    private final java.lang.String model = "res.users";
    private final org.tensorflow.lite.examples.objectdetection.RetroFit.ConsumirApi apiService = null;
    private java.lang.String userUid;
    private android.widget.ImageView imageView;
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String> galleryLauncher = null;
    @org.jetbrains.annotations.NotNull
    public static final org.tensorflow.lite.examples.objectdetection.fragments.PerfilFragment.Companion Companion = null;
    
    public PerfilFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDb() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getLogin() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getPassword() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getModel() {
        return null;
    }
    
    @java.lang.Override
    public void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void openGallery() {
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void guardarCambios() {
    }
    
    private final void enviarDatos(JsonRequestParams jsonRequestParams) {
    }
    
    private final java.lang.String obtenerImagenBase64() {
        return null;
    }
    
    private final void obtenerDatosUser(java.lang.String id) {
    }
    
    private final void updateUI(org.tensorflow.lite.examples.objectdetection.login.UserData userData) {
    }
    
    @org.jetbrains.annotations.NotNull
    @kotlin.jvm.JvmStatic
    public static final org.tensorflow.lite.examples.objectdetection.fragments.PerfilFragment newInstance(@org.jetbrains.annotations.NotNull
    java.lang.String userUid) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0007"}, d2 = {"Lorg/tensorflow/lite/examples/objectdetection/fragments/PerfilFragment$Companion;", "", "()V", "newInstance", "Lorg/tensorflow/lite/examples/objectdetection/fragments/PerfilFragment;", "userUid", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        @kotlin.jvm.JvmStatic
        public final org.tensorflow.lite.examples.objectdetection.fragments.PerfilFragment newInstance(@org.jetbrains.annotations.NotNull
        java.lang.String userUid) {
            return null;
        }
    }
}