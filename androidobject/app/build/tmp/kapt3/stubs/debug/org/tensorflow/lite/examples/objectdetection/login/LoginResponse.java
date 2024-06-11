package org.tensorflow.lite.examples.objectdetection.login;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0007B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\b\u0018\u00010\u0004R\u00020\u00008\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\b"}, d2 = {"Lorg/tensorflow/lite/examples/objectdetection/login/LoginResponse;", "", "()V", "result", "Lorg/tensorflow/lite/examples/objectdetection/login/LoginResponse$Result;", "getResult", "()Lorg/tensorflow/lite/examples/objectdetection/login/LoginResponse$Result;", "Result", "app_debug"})
public final class LoginResponse {
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "result")
    private final org.tensorflow.lite.examples.objectdetection.login.LoginResponse.Result result = null;
    
    public LoginResponse() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final org.tensorflow.lite.examples.objectdetection.login.LoginResponse.Result getResult() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0005R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2 = {"Lorg/tensorflow/lite/examples/objectdetection/login/LoginResponse$Result;", "", "(Lorg/tensorflow/lite/examples/objectdetection/login/LoginResponse;)V", "isAuthentication", "", "()Z", "userUid", "", "getUserUid", "()I", "app_debug"})
    public final class Result {
        @com.google.gson.annotations.SerializedName(value = "user_uid")
        private final int userUid = 0;
        @com.google.gson.annotations.SerializedName(value = "authentification")
        private final boolean isAuthentication = false;
        
        public Result() {
            super();
        }
        
        public final int getUserUid() {
            return 0;
        }
        
        public final boolean isAuthentication() {
            return false;
        }
    }
}