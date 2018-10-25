
package com.example.server.restapi.api.model.TokenVerification;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Identity {

    @SerializedName("methods")
    @Expose
    private List<String> methods = null;
    @SerializedName("password")
    @Expose
    private Password password;

    public List<String> getMethods() {
        return methods;
    }

    public void setMethods(List<String> methods) {
        this.methods = methods;
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
    }

}
