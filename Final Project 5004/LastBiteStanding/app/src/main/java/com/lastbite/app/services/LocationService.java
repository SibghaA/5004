package com.lastbite.app.services;

import android.location.Location;

public interface LocationService {
    void getCurrentLocation(LocationCallback callback);
    void stopLocationUpdates();
    boolean isLocationPermissionGranted();
    void requestLocationPermission();
}