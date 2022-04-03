package com.example.testapi.Network;

import com.example.testapi.Response.TaskResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IApiService {
    @GET("api/activity/")
    Call<TaskResponse> getTasks();
}
