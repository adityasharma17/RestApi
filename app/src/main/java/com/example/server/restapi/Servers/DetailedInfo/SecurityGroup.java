
package com.example.server.restapi.Servers.DetailedInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SecurityGroup {

    @SerializedName("name")
    @Expose
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
