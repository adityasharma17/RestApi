package com.example.server.restapi.api.model.TokenVerification.service;

import com.example.server.restapi.MainActivity;
import com.example.server.restapi.api.model.TokenVerification.Example;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface UserClient {



// api model for authentication

    @Headers("Content-Type: application/json")
    @POST("tokens")
   Call<ResponseBody> login(@Body Example example);





}
