package com.lastbite.app.services;

import android.location.Location;

public interface LocationCallback {
    void onLocationReceived(Location location);
    void onLocationError(String error);
}
