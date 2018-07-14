
package com.example.server.restapi.Servers.DetailedInfo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Addresses {

    @SerializedName("private_network")
    @Expose
    private List<PrivateNetwork> privateNetwork = null;

    public List<PrivateNetwork> getPrivateNetwork() {
        return privateNetwork;
    }

    public void setPrivateNetwork(List<PrivateNetwork> privateNetwork) {
        this.privateNetwork = privateNetwork;
    }

}
