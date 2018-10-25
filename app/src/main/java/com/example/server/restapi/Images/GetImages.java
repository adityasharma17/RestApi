package com.example.server.restapi.Images;

import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

import com.example.server.restapi.MainActivity;
import com.example.server.restapi.api.model.TokenVerification.Example;

import java.util.List;

public interface GetImages {

   // String subject_token = MainActivity.globalToken;

    @GET("v2/images")
    Call<GetImageDetails> getImagesb(@Header("X-Auth-Token") String key);



}
