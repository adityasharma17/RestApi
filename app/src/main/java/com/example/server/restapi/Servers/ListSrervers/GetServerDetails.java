
package com.example.server.restapi.Servers.ListSrervers;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetServerDetails {

    @SerializedName("servers")
    @Expose
    private List<Server> servers = null;

    public List<Server> getServers() {
        return servers;
    }

    public void setServers(List<Server> servers) {
        this.servers = servers;
    }

}
