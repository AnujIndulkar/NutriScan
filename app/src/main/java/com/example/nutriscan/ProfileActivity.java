package com.example.nutriscan;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    private EditText nameEditText, ageEditText, allergiesEditText;
    private Spinner genderSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Initialize the views
        nameEditText = findViewById(R.id.name_edit_text);
        ageEditText = findViewById(R.id.age_edit_text);
        allergiesEditText = findViewById(R.id.allergies_edit_text);
        genderSpinner = findViewById(R.id.gender_spinner);
        Button saveProfileButton = findViewById(R.id.save_profile_button);

        // Set up the gender spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.gender_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderSpinner.setAdapter(adapter);

        // Set up the save button listener
        saveProfileButton.setOnClickListener(v -> {
            // For now, we will just show a confirmation message.
            // In the future, we will save this data to a database.
            Toast.makeText(ProfileActivity.this, "Profile Saved (simulation)", Toast.LENGTH_SHORT).show();

            // TODO: Navigate to the User Dashboard
        });
    }
}
