package com.example.rohan.streetingoweatherapp;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Handler;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;

import com.example.rohan.streetingoweatherapp.POJOs.Response;

import retrofit2.Call;

public class SplashScreenActtivity extends AppCompatActivity {

    LocationManager mLocationManager;
    boolean GPSEnabled;
    LocationListener mLocationListener;

    double latitude;
    double longitude;

    Intent launchHomeActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_splash_screen_acttivity);

        if (Build.VERSION.SDK_INT >= 21)
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));

        initialize();

        launchHomeActivity = new Intent(SplashScreenActtivity.this, HomeActivity.class);
        launchHomeActivity.putExtra("latitude", latitude);
        launchHomeActivity.putExtra("longitude", longitude);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if (getGPSStatus()) {
                    getLocation();

                } else {
                    Toast.makeText(SplashScreenActtivity.this, "Please enable GPS and restart app.", Toast.LENGTH_SHORT).show();
                    finish();
                }

            }
        }, 5000);
    }

    public void initialize() {
        mLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        latitude = 0.0;
        longitude = 0.0;

    }

    public boolean getGPSStatus() {
        if (mLocationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            GPSEnabled = true;
            return true;
        }

        return false;
    }

    public void getLocation() {

        mLocationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                latitude = location.getLatitude();
                longitude = location.getLongitude();
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            Toast.makeText(SplashScreenActtivity.this, "Please enable location to get weather data", Toast.LENGTH_SHORT).show();
            return;
        }

        mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, mLocationListener);

        startActivity(launchHomeActivity);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        finish();

    }

//    public void enableGPS() {
//
//        GPSEnabled = false;
//
//        GPSEnabled = mLocationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
//
//        if (!GPSEnabled) {
//            dialog = new AlertDialog.Builder(this);
//
//            dialog.setCancelable(false);
//            dialog.setMessage("Please enable location to get weather data");
//
//            dialog.setPositiveButton("Enable", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    Intent getLocation = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
//                    startActivity(getLocation);
//                }
//            });
//
//            dialog.show();
//        }
//
//    }

}

