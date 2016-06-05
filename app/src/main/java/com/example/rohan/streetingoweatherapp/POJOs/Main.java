package com.example.rohan.streetingoweatherapp.POJOs;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Rohan on 05-Jun-16.
 */
public class Main {

    @SerializedName("temp")
    private String temp;

    @SerializedName("pressure")
    private String pressure;

    @SerializedName("humidity")
    private String humidity;

    @SerializedName("temp_min")
    private String temp_min;

    @SerializedName("temp_max")
    private String temp_max;

    public String getTemp() {

        return temp;
    }

    public String getPressure() {
        return pressure;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getTemp_min() {
        return temp_min;
    }

    public String getTemp_max() {
        return temp_max;
    }
}