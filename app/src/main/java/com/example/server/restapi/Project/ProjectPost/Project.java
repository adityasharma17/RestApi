
package com.example.server.restapi.Project.ProjectPost;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Project {

    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("domain_id")
    @Expose
    private String domainId;
    @SerializedName("enabled")
    @Expose
    private Boolean enabled;
    @SerializedName("is_domain")
    @Expose
    private Boolean isDomain;
    @SerializedName("name")
    @Expose
    private String name;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDomainId() {
        return domainId;
    }

    public void setDomainId(String domainId) {
        this.domainId = domainId;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getIsDomain() {
        return isDomain;
    }

    public void setIsDomain(Boolean isDomain) {
        this.isDomain = isDomain;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
