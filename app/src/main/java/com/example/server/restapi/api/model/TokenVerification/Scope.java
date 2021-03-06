
package com.example.server.restapi.api.model.TokenVerification;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Scope {

    @SerializedName("project")
    @Expose
    private Project project;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

}
