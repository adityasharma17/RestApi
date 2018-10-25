package com.example.server.restapi.Project.ProjectPost.service;

import com.example.server.restapi.Project.ProjectPost.GetProject.GetDataProject;
import com.example.server.restapi.Project.ProjectPost.PostDataProject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface CreateProject {


    @POST("/v3/projects")
    Call<GetDataProject> makeProject(@Header("X-Auth-Token") String key, @Body PostDataProject postObject);

    // while the user registers for an account on cloud service a project domain need to be established such that that user can work on different projects right from the mobile application.



}

