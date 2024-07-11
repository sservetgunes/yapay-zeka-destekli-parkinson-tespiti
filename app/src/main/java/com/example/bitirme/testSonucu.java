package com.example.bitirme;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class testSonucu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_sonucu);

        // Sonuç mesajını al
        String resultMessage = getIntent().getStringExtra("RESULT_MESSAGE"); // Doğru ekstra veriyi aldığımızı doğruluyoruz

        // Log mesajı ekle
        Log.d("ResultActivity", "Sonuç mesajı: " + resultMessage);
        // Sonucu göster
        TextView resultTextView = findViewById(R.id.resultTextView);
        resultTextView.setText(resultMessage);
    }


}