package com.example.rohan.streetingoweatherapp.POJOs;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Rohan on 05-Jun-16.
 */
public class Weather {

    @SerializedName("main")
    private String main;

    public String getMain() {
        return main;
    }

}
