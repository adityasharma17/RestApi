package com.example.server.restapi.UserFormation;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface AssignRolesToUser {


@PUT("/v3/projects/{project_id}/users/{user_id}/roles/{role_id}")
    Call<ResponseBody> assignRoles(@Path("project_id") String projectId, @Path("user_id") String userId, @Path("role_id") String role_id, @Header("X-Auth-Token") String key);

}
