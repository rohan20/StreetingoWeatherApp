package com.example.rohan.streetingoweatherapp.POJOs;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rohan on 05-Jun-16.
 */
public class Response {

    @SerializedName("weather")
    private List<Weather> weatherInfo = new ArrayList<>();

    @SerializedName("main")
    private Main main;

    @SerializedName("wind")
    private Wind wind;

    @SerializedName("sys")
    private Sys sys;

    public List<Weather> getWeatherInfo() {
        return weatherInfo;
    }

    public Main getMain() {
        return main;
    }

    public Wind getWind() {
        return wind;
    }

    public Sys getSys() {
        return sys;
    }

}
