package com.lastbite.app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayerSetupActivity extends AppCompatActivity {
    EditText numPlayersInput;
    Button confirmPlayersBtn;
    LinearLayout playerInputsContainer;
    Button startGameBtn;
    private List<String> playerPreferences;
    private double latitude;
    private double longitude;
    private ArrayList<PlayerPreference> playersList;

    // List of cuisine types from Google Places API
    private final String[] cuisineTypes = {
            "American", "Chinese", "French", "Greek", "Indian", "Italian", "Japanese",
            "Korean", "Mexican", "Mediterranean", "Thai", "Vietnamese", "BBQ",
            "Seafood", "Pizza", "Vegetarian", "Vegan", "Halal", "Kosher"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_setup);

        // Get location from intent
        latitude = getIntent().getDoubleExtra("latitude", 0);
        longitude = getIntent().getDoubleExtra("longitude", 0);

        // Initialize views
        initializeViews();

        confirmPlayersBtn.setOnClickListener(v -> createPlayerInputs());
        startGameBtn.setOnClickListener(v -> validateAndProceed());
    }

    private void initializeViews() {
        numPlayersInput = findViewById(R.id.numPlayersInput);
        confirmPlayersBtn = findViewById(R.id.confirmPlayersBtn);
        playerInputsContainer = findViewById(R.id.playerInputsContainer);
        startGameBtn = findViewById(R.id.startGameBtn);
        playerPreferences = new ArrayList<>();
        playersList = new ArrayList<>();
    }

    private void createPlayerInputs() {
        String numPlayersStr = numPlayersInput.getText().toString();
        if (numPlayersStr.isEmpty()) {
            showError("Please enter number of players");
            return;
        }

        int numPlayers = Integer.parseInt(numPlayersStr);
        if (numPlayers < 2 || numPlayers > 10) {
            showError("Number of players must be between 2 and 10");
            return;
        }

        // Clear previous inputs
        playerInputsContainer.removeAllViews();
        playerPreferences.clear();

        // Create input fields for each player
        for (int i = 0; i < numPlayers; i++) {
            View playerView = getLayoutInflater().inflate(R.layout.player_input_item, null);

            EditText playerNameInput = playerView.findViewById(R.id.playerNameInput);
            Spinner cuisineSpinner = playerView.findViewById(R.id.cuisineSpinner);

            playerNameInput.setHint("Player " + (i + 1) + " name");

            // Set up the cuisine spinner
            ArrayAdapter<String> adapter = new ArrayAdapter<>(
                    this,
                    android.R.layout.simple_spinner_dropdown_item,
                    cuisineTypes
            );
            cuisineSpinner.setAdapter(adapter);

            playerInputsContainer.addView(playerView);
        }

        // Show start game button
        startGameBtn.setVisibility(View.VISIBLE);
    }

    private void validateAndProceed() {
        boolean isValid = true;
        playersList.clear(); // Clear existing list

        // Collect all preferences
        for (int i = 0; i < playerInputsContainer.getChildCount(); i++) {
            View playerView = playerInputsContainer.getChildAt(i);
            EditText playerNameInput = playerView.findViewById(R.id.playerNameInput);
            Spinner cuisineSpinner = playerView.findViewById(R.id.cuisineSpinner);

            String name = playerNameInput.getText().toString().trim();
            String cuisine = cuisineSpinner.getSelectedItem().toString();

            if (name.isEmpty()) {
                isValid = false;
                showError("Please enter all player names");
                break;
            }

            playersList.add(new PlayerPreference(name, cuisine));
        }

        if (isValid) {
            Intent intent = new Intent(this, GameActivity.class);
            intent.putExtra("latitude", latitude);
            intent.putExtra("longitude", longitude);
            intent.putParcelableArrayListExtra("players", (ArrayList<? extends Parcelable>) playersList);
            startActivity(intent);
        }
    }

    private void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}