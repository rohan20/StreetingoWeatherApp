package com.example.rohan.streetingoweatherapp.POJOs;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Rohan on 05-Jun-16.
 */
public class Wind {

    @SerializedName("speed")
    private String speed;

    @SerializedName("deg")
    private String deg;

    public String getSpeed() {
        return speed;
    }

    public String getDeg() {
        return deg;
    }
}
