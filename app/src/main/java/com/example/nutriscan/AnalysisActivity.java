package com.example.nutriscan;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class AnalysisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis);

        TextView barcodeTextView = findViewById(R.id.barcode_text_view);

        // Get the barcode from the intent
        String barcode = getIntent().getStringExtra("BARCODE_KEY");

        // Display the barcode
        if (barcode != null) {
            barcodeTextView.setText(getString(R.string.scanned_barcode_label) + barcode);
        }
    }
}
