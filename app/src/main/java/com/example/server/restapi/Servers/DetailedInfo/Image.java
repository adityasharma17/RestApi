
package com.example.server.restapi.Servers.DetailedInfo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Image {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("links")
    @Expose
    private List<Link_> links = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Link_> getLinks() {
        return links;
    }

    public void setLinks(List<Link_> links) {
        this.links = links;
    }

}
