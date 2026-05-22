package com.example.nutriscan;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

public class MainActivity extends AppCompatActivity {

    private final ActivityResultLauncher<ScanOptions> barcodeLauncher = registerForActivityResult(new ScanContract(),
            result -> {
                if (result.getContents() == null) {
                    // User cancelled the scan
                    Toast.makeText(this, "Scan Cancelled", Toast.LENGTH_LONG).show();
                } else {
                    // Scan successful!
                    String scannedCode = result.getContents();
                    Toast.makeText(this, "Scanned: " + scannedCode, Toast.LENGTH_LONG).show();
                    // Start a new activity to ask personalized questions or show results
                    startAnalysisActivity(scannedCode);
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the Button for scanning
        Button scanButton = findViewById(R.id.btn_now);
        scanButton.setOnClickListener(v -> startScanner());

        // Initialize the Button for the profile
        Button profileButton = findViewById(R.id.btn_profile);
        profileButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            startActivity(intent);
        });

        // Initialize the info logo ImageView
        ImageView infoLogo = findViewById(R.id.iv_info_logo);
        if (infoLogo != null) {
            infoLogo.setOnClickListener(v -> showInfoDialog());
        }
    }

    private void startScanner() {
        ScanOptions options = new ScanOptions();
        options.setDesiredBarcodeFormats(ScanOptions.ALL_CODE_TYPES);
        options.setPrompt("Scan the product barcode");
        options.setCameraId(0);  // Use default rear camera
        options.setBeepEnabled(true);
        options.setBarcodeImageEnabled(true); // Saves the scanned image
        barcodeLauncher.launch(options);
    }

    private void showInfoDialog() {
        // Replace with the actual details
        String creatorName = "Rani D. Bhosale";
        String prnNumber = "2267621242009";
        String creatorName1 = "Anuj H. Indulkar";
        String prnNumber1 = "2267621242017";
        String creatorName2 = "Harshad M. Kshirsagar";
        String prnNumber2 = "2267621242045";

        String message = "Created By: " + creatorName + "\n"
                + "PRN No: " + prnNumber + "\n\n"
                + "Created By: " + creatorName1 + "\n"
                + "PRN No: " + prnNumber1 + "\n\n"
                + "Created By: " + creatorName2 + "\n"
                + "PRN No: " + prnNumber2;

        // Create and show the AlertDialog
        new AlertDialog.Builder(this)
                .setTitle("NutriScan Information")
                .setMessage(message)
                .setPositiveButton("Close", null) // "null" makes the button dismiss the dialog
                .show();
    }

    /*
     * Method to start the next activity for analysis and questions.
     * @param barcode The scanned barcode string.
     */
    private void startAnalysisActivity(String barcode) {
        Intent intent = new Intent(MainActivity.this, AnalysisActivity.class);
        intent.putExtra("BARCODE_KEY", barcode); // Pass the barcode to the next screen
        startActivity(intent);
    }
}