package org.tensorflow.lite.examples.objectdetection;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 ;2\u00020\u00012\u00020\u0002:\u0001;B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0007H\u0002J\u0010\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020%H\u0002J\"\u0010&\u001a\u00020!2\u0006\u0010\'\u001a\u00020(2\u0006\u0010)\u001a\u00020(2\b\u0010*\u001a\u0004\u0018\u00010+H\u0014J\b\u0010,\u001a\u00020!H\u0016J\u0012\u0010-\u001a\u00020!2\b\u0010.\u001a\u0004\u0018\u00010/H\u0014J\u0010\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0016J\u0010\u00104\u001a\u00020!2\u0006\u00105\u001a\u000206H\u0002J\b\u00107\u001a\u00020!H\u0002J\u0010\u00108\u001a\u00020!2\u0006\u00109\u001a\u00020:H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u0007X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\tR\u0014\u0010\u0013\u001a\u00020\u0007X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\tR\u0014\u0010\u0015\u001a\u00020\u0007X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\tR\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006<"}, d2 = {"Lorg/tensorflow/lite/examples/objectdetection/HomeActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/google/android/material/navigation/NavigationView$OnNavigationItemSelectedListener;", "()V", "apiService", "Lorg/tensorflow/lite/examples/objectdetection/RetroFit/ConsumirApi;", "db", "", "getDb", "()Ljava/lang/String;", "drawerLayout", "Landroidx/drawerlayout/widget/DrawerLayout;", "fragmentContainer", "Landroid/widget/FrameLayout;", "items", "", "Lorg/tensorflow/lite/examples/objectdetection/login/Palabra;", "login", "getLogin", "model", "getModel", "password", "getPassword", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "searchAdapter", "Lorg/tensorflow/lite/examples/objectdetection/adapater/SearchAdapter;", "searchView", "Landroidx/appcompat/widget/SearchView;", "sharedPreferences", "Landroid/content/SharedPreferences;", "userUid", "obtenerDatosUser", "", "id", "obtenerPalabras", "request", "Lorg/tensorflow/lite/examples/objectdetection/login/ObtenerPalabras;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNavigationItemSelected", "", "item", "Landroid/view/MenuItem;", "replaceFragment", "fragment", "Landroidx/fragment/app/Fragment;", "startVoiceInput", "updateUI", "userData", "Lorg/tensorflow/lite/examples/objectdetection/login/UserData;", "Companion", "app_debug"})
public final class HomeActivity extends androidx.appcompat.app.AppCompatActivity implements com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener {
    @org.jetbrains.annotations.NotNull
    public static final org.tensorflow.lite.examples.objectdetection.HomeActivity.Companion Companion = null;
    private static final int REQUEST_CODE_SPEECH_INPUT = 100;
    private android.widget.FrameLayout fragmentContainer;
    private androidx.drawerlayout.widget.DrawerLayout drawerLayout;
    private androidx.appcompat.widget.SearchView searchView;
    private org.tensorflow.lite.examples.objectdetection.adapater.SearchAdapter searchAdapter;
    private androidx.recyclerview.widget.RecyclerView recyclerView;
    private java.lang.String userUid = "";
    private java.util.List<org.tensorflow.lite.examples.objectdetection.login.Palabra> items;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String db = "odoo";
    @org.jetbrains.annotations.NotNull
    private final java.lang.String login = "odoo";
    @org.jetbrains.annotations.NotNull
    private final java.lang.String password = "odoo";
    @org.jetbrains.annotations.NotNull
    private final java.lang.String model = "res.users";
    private final org.tensorflow.lite.examples.objectdetection.RetroFit.ConsumirApi apiService = null;
    private android.content.SharedPreferences sharedPreferences;
    
    public HomeActivity() {
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
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void obtenerPalabras(org.tensorflow.lite.examples.objectdetection.login.ObtenerPalabras request) {
    }
    
    private final void startVoiceInput() {
    }
    
    @java.lang.Override
    public boolean onNavigationItemSelected(@org.jetbrains.annotations.NotNull
    android.view.MenuItem item) {
        return false;
    }
    
    @java.lang.Override
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable
    android.content.Intent data) {
    }
    
    private final void obtenerDatosUser(java.lang.String id) {
    }
    
    private final void updateUI(org.tensorflow.lite.examples.objectdetection.login.UserData userData) {
    }
    
    private final void replaceFragment(androidx.fragment.app.Fragment fragment) {
    }
    
    @java.lang.Override
    public void onBackPressed() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lorg/tensorflow/lite/examples/objectdetection/HomeActivity$Companion;", "", "()V", "REQUEST_CODE_SPEECH_INPUT", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}