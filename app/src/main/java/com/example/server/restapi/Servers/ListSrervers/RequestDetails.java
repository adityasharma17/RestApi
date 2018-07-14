package com.example.server.restapi.Servers.ListSrervers;

import com.example.server.restapi.Servers.DetailedInfo.DetailedServerDetails;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface RequestDetails
{

    @Headers("Content-Type: application/json")
    @GET("{Project_id}/servers/{server_id}")
    Call<DetailedServerDetails> getDetailsServer(@Path("Project_id") String projectId, @Header("X-Auth-Token") String key, @Path("server_id") String serverId);


}



