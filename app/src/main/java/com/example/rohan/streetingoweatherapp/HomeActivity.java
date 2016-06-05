package com.example.rohan.streetingoweatherapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.rohan.streetingoweatherapp.POJOs.Response;

import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;

public class HomeActivity extends AppCompatActivity {

    TextView date;
    TextView temp;
    TextView main;
    TextView tempMin;
    TextView tempMax;
    TextView humidity;
    TextView pressure;
    TextView windSpeed;
    TextView windDeg;
    TextView sunrise;
    TextView sunset;

    RESTAdapter adapter;

    Call<Response> request;

    double latitude;
    double longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        date = (TextView) findViewById(R.id.date);
        temp = (TextView) findViewById(R.id.temp);
        tempMax = (TextView) findViewById(R.id.temp_max);
        tempMin = (TextView) findViewById(R.id.temp_min);
        humidity = (TextView) findViewById(R.id.humidity);
        pressure = (TextView) findViewById(R.id.pressure);
        windDeg = (TextView) findViewById(R.id.wind_deg);
        windSpeed = (TextView) findViewById(R.id.wind_speed);
        main = (TextView) findViewById(R.id.weather_main);
        sunrise = (TextView) findViewById(R.id.sunrise);
        sunset = (TextView) findViewById(R.id.sunset);

        adapter = new RESTAdapter(Constants.RETROFIT_BASE_URL);

        Intent i = getIntent();
        latitude = i.getDoubleExtra("latitude", 0.0);
        longitude = i.getDoubleExtra("longitude", 0.0);

        String currentDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        date.setText(currentDate);

        setWeatherData(latitude, longitude);

    }

    public void setWeatherData(Double latitude, Double longitude) {

        request = adapter.getAPI().getWeatherInfo(latitude + "", longitude + "", Constants.API_KEY);

        request.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {

                String currentDate = new SimpleDateFormat("EEE, dd MMM yyyy").format(new Date());
                date.setText(currentDate);

                humidity.setText(response.body().getMain().getHumidity());
                pressure.setText(response.body().getMain().getPressure());
                tempMax.setText(response.body().getMain().getTemp_max());
                tempMin.setText(response.body().getMain().getTemp_min());
                temp.setText(response.body().getMain().getTemp());

                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM hh:mm a");

                Date sunriseDate = new Date(Long.parseLong(response.body().getSys().getSunrise()) * 1000);
                Date sunsetDate = new Date(Long.parseLong(response.body().getSys().getSunset()) * 1000);

                String sunriseTime = formatter.format(sunriseDate);
                String sunsetTime = formatter.format(sunsetDate);

                sunrise.setText(sunriseTime);
                sunset.setText(sunsetTime);

                main.setText(response.body().getWeatherInfo().get(0).getMain());

                windDeg.setText(response.body().getWind().getDeg());
                windSpeed.setText(response.body().getWind().getSpeed());


            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {

            }
        });


    }

}
