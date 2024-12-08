package com.lastbite.app.managers;

import android.location.Location;
import com.lastbite.app.services.LocationCallback;
import com.lastbite.app.services.LocationService;

public class LocationManager {
    private final LocationService locationService;
    private Location currentLocation;

    public LocationManager(LocationService locationService) {
        this.locationService = locationService;
    }

    public void getCurrentLocation(LocationCallback callback) {
        locationService.getCurrentLocation(new LocationCallback() {
            @Override
            public void onLocationReceived(Location location) {
                currentLocation = location;
                if (callback != null) {
                    callback.onLocationReceived(location);
                }
            }

            @Override
            public void onLocationError(String error) {
                if (callback != null) {
                    callback.onLocationError(error);
                }
            }
        });
    }

    public Location getLastKnownLocation() {
        return currentLocation;
    }

    public boolean hasLocationPermission() {
        return locationService.isLocationPermissionGranted();
    }

    public void requestLocationPermission() {
        locationService.requestLocationPermission();
    }
}