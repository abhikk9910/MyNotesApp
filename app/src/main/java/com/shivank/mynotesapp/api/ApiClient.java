package com.shivank.mynotesapp.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

        private static final String BASE_URL = "https://native007.000webhostapp.com/api/";
    private static Retrofit retrofit;

    public static Retrofit getApiClient() {


        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }


        return retrofit;
    }
}
