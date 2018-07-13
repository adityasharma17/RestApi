
package com.example.server.restapi.UserFormation.GetDataUser;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserDataFromRequest {

    @SerializedName("user")
    @Expose
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
