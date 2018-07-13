package com.example.server.restapi.Servers.ListSrervers;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface RequestInterface {




    @Headers("Content-Type: application/json")
    @GET("{Project_id}/servers")
    Call<GetServerDetails> getServerData(@Path("Project_id") String projectId, @Header("X-Auth-Token") String key);



}

