
package com.example.server.restapi.Servers.DetailedInfo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Flavor {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("links")
    @Expose
    private List<Link__> links = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Link__> getLinks() {
        return links;
    }

    public void setLinks(List<Link__> links) {
        this.links = links;
    }

}
