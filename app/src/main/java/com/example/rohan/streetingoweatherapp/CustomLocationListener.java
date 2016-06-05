package com.example.rohan.streetingoweatherapp;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by Rohan on 05-Jun-16.
 */
public class CustomLocationListener implements LocationListener {

    Context mContext;
    Location mLocation;

    public CustomLocationListener(Context context) {
        mContext = context;
    }

    @Override
    public void onLocationChanged(Location location) {
        mLocation = location;
        Toast.makeText(mContext, "Latitude: " + Double.toString(location.getLatitude()) + "\nLongitude: " + location.getLongitude(), Toast.LENGTH_SHORT).show();
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

    public Location getCustomLocation(){
        return mLocation;
    }
}
