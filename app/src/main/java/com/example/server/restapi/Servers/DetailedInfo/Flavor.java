
package com.example.server.restapi.Servers.DetailedInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Flavor {

    @SerializedName("id")
    @Expose
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
