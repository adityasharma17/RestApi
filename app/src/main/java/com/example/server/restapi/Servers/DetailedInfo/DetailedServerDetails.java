
package com.example.server.restapi.Servers.DetailedInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DetailedServerDetails {
 //  These are POJO classes that we are using to store server data received from openstack server.
    @SerializedName("server")
    @Expose
    private Server server;

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

}
