package com.lastbite.app;

import android.os.Bundle;
import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;
import com.lastbite.app.managers.LocationManager;
import com.lastbite.app.services.GoogleLocationService;
import com.lastbite.app.services.LocationCallback;
import java.util.Arrays;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1001;

    private GoogleMap googleMap;
    private MapView mapView;
    private LocationManager locationManager;
    private Button useCurrentLocationBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Places SDK
        if (!Places.isInitialized()) {
            Places.initialize(getApplicationContext(), getString(R.string.google_maps_key));
        }

        // Initialize location services
        locationManager = new LocationManager(new GoogleLocationService(this));

        // Initialize Map and UI components
        initializeViews(savedInstanceState);
        setupPlacesAutocomplete();
    }

    private void initializeViews(Bundle savedInstanceState) {
        useCurrentLocationBtn = findViewById(R.id.useCurrentLocationBtn);
        mapView = findViewById(R.id.mapView);

        // Set up click listener for current location button
        useCurrentLocationBtn.setOnClickListener(v -> handleGetCurrentLocation());

        // Initialize map
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);
    }

    private void setupPlacesAutocomplete() {
        AutocompleteSupportFragment autocompleteFragment = (AutocompleteSupportFragment)
                getSupportFragmentManager().findFragmentById(R.id.autocomplete_fragment);

        if (autocompleteFragment != null) {
            // Specify the types of place data to return
            autocompleteFragment.setPlaceFields(Arrays.asList(
                    Place.Field.ID,
                    Place.Field.NAME,
                    Place.Field.ADDRESS,
                    Place.Field.LAT_LNG
            ));

            // Customize the fragment
            autocompleteFragment.setHint("Search location");

            // Get the fragment's view and customize it
            View fragmentView = autocompleteFragment.getView();
            if (fragmentView != null) {
                // Find the EditText within the fragment
                EditText searchInput = fragmentView.findViewById(com.google.android.libraries.places.R.id.places_autocomplete_search_input);
                if (searchInput != null) {
                    searchInput.setTextSize(16);
                    searchInput.setBackgroundResource(android.R.color.transparent);
                    searchInput.setHint("Enter location");
                }
            }

            autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
                @Override
                public void onPlaceSelected(@NonNull Place place) {
                    String placeName = place.getName();
                    LatLng latLng = place.getLatLng();

                    if (latLng != null) {
                        updateMapLocation(latLng);
                        Toast.makeText(MainActivity.this,
                                "Selected: " + placeName, Toast.LENGTH_SHORT).show();
                        proceedToPlayerSetup(latLng);
                    }
                }

                @Override
                public void onError(@NonNull Status status) {
                    Toast.makeText(MainActivity.this,
                            "Error: " + status.getStatusMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private void handleGetCurrentLocation() {
        if (!checkLocationPermission()) {
            requestLocationPermission();
            return;
        }

        useCurrentLocationBtn.setEnabled(false);
        locationManager.getCurrentLocation(new LocationCallback() {
            @Override
            public void onLocationReceived(Location location) {
                useCurrentLocationBtn.setEnabled(true);
                LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
                updateMapLocation(latLng);
                proceedToPlayerSetup(latLng);
            }

            @Override
            public void onLocationError(String error) {
                useCurrentLocationBtn.setEnabled(true);
                showError(error);
            }
        });
    }

    private boolean checkLocationPermission() {
        return ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED;
    }

    private void requestLocationPermission() {
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                LOCATION_PERMISSION_REQUEST_CODE);
    }

    private void updateMapLocation(LatLng latLng) {
        if (googleMap != null) {
            googleMap.clear();
            googleMap.addMarker(new MarkerOptions().position(latLng));
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15f));
        }
    }

    private void proceedToPlayerSetup(LatLng location) {
        Intent intent = new Intent(this, PlayerSetupActivity.class);
        intent.putExtra("latitude", location.latitude);
        intent.putExtra("longitude", location.longitude);
        startActivity(intent);
    }

    private void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onMapReady(@NonNull GoogleMap map) {
        googleMap = map;
        if (checkLocationPermission()) {
            googleMap.setMyLocationEnabled(true);
            googleMap.getUiSettings().setMyLocationButtonEnabled(true);
        }
        // Set default location
        LatLng defaultLocation = new LatLng(37.7749, -122.4194);
        updateMapLocation(defaultLocation);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                handleGetCurrentLocation();
            }
        }
    }

    // MapView lifecycle methods
    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        mapView.onPause();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        mapView.onDestroy();
        super.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }
}