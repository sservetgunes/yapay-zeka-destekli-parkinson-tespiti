package com.example.bitirme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class beslenme extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beslenme);

        // Örnek Diyet Listeleri Butonu'nun referansını al
        Button buttonSampleDiets = findViewById(R.id.buttonSampleDiets);

        // Örnek Diyet Listeleri Butonu'na tıklama dinleyicisi ekle
        buttonSampleDiets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Örnek Diyet Listeleri sayfasını başlat
                startActivity(new Intent(beslenme.this, diyetlisteleri.class));
            }
        });
    }
}