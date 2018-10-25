package com.example.server.restapi.ListKeys;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface KeysApi {


  // Keys are used for logging into the compute instances.
  //this Api gets the available keys from the server and display it to user


    @GET("v2.1/os-keypairs")
    Call<ListKeys> listKeys(@Header("X-Auth-Token") String key);
}
