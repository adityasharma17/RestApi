package com.example.server.restapi.ListKeys;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface KeysApi {

    @GET("v2.1/os-keypairs")
    Call<ListKeys> listKeys(@Header("X-Auth-Token") String key);
}
