package com.example.testapi.Handlers;

import com.example.testapi.Network.IApiService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiHandler {
    private static ApiHandler mInstance;

    private static final String BASE_URL = "http://www.boredapi.com/";

    private Retrofit retrofit;

    public ApiHandler() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .addInterceptor(interceptor);

        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).client(builder.build()).addConverterFactory(GsonConverterFactory.create()).build();
    }
    public static ApiHandler getInstance() {
        if(mInstance == null) {
            mInstance = new ApiHandler();
        }
        return mInstance;
    }

    public IApiService getService() {
        return retrofit.create(IApiService.class);
    }
}
