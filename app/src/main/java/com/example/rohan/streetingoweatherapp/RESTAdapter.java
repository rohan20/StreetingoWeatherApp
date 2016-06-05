package com.example.rohan.streetingoweatherapp;

import android.content.Context;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Rohan on 05-Jun-16.
 */
public class RESTAdapter {

    Retrofit retrofit;
    WeatherAPI weatherAPI;

    public RESTAdapter(String base_url) {

        retrofit = new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        weatherAPI = retrofit.create(WeatherAPI.class);

    }

    public WeatherAPI getAPI() {
        return weatherAPI;
    }
}
