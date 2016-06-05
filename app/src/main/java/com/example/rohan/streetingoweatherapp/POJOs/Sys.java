package com.example.rohan.streetingoweatherapp.POJOs;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Rohan on 05-Jun-16.
 */
public class Sys {

    @SerializedName("sunrise")
    private String sunrise;

    @SerializedName("sunset")
    private String sunset;


    public String getSunrise() {

        return sunrise;
    }

    public String getSunset() {
        return sunset;
    }
}
