package com.example.server.restapi.Servers.serverAction;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ServerPause {



    @Headers("Content-Type: application/json")
    @POST("{Project_id}/servers/{server_id}/action")
    Call<ResponseBody> pauseServer(@Body RequestBody params , @Path("Project_id") String projectId, @Header("X-Auth-Token") String key, @Path("server_id") String serverId);


}
