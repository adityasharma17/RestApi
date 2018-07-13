package com.example.server.restapi.UserFormation;

import com.example.server.restapi.UserFormation.GetDataUser.UserDataFromRequest;
import com.example.server.restapi.api.model.TokenVerification.Example;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface CreateUsers {

    @POST("/v3/users")
    Call<UserDataFromRequest> createUser(@Header("X-Auth-Token") String key, @Body CreateUser user );


}
