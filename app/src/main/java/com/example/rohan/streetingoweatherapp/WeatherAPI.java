package com.example.rohan.streetingoweatherapp;

import com.example.rohan.streetingoweatherapp.POJOs.Response;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Rohan on 05-Jun-16.
 */
public interface WeatherAPI {

        @GET("weather?")
        Call<Response> getWeatherInfo(@Query("lat") String latitude, @Query("lon") String longitude, @Query("appid") String api_key);


}
