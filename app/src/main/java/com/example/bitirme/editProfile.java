package com.example.bitirme;// editProfile.java

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class editProfile extends AppCompatActivity {
    private EditText nameEditText, surnameEditText, heightEditText, weightEditText, birthDateEditText;
    private Button saveButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        nameEditText = findViewById(R.id.nameEditText);
        surnameEditText = findViewById(R.id.surnameEditText);
        heightEditText = findViewById(R.id.heightEditText);
        weightEditText = findViewById(R.id.weightEditText);
        birthDateEditText = findViewById(R.id.birthDateEditText);
        saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString().trim();
                String surname = surnameEditText.getText().toString().trim();
                String heightStr = heightEditText.getText().toString().trim();
                String weightStr = weightEditText.getText().toString().trim();
                String birthDate = birthDateEditText.getText().toString().trim();
                if (name.isEmpty() || surname.isEmpty() || heightStr.isEmpty() || weightStr.isEmpty() || birthDate.isEmpty()) {
                    // Eksik bilgi varsa kullanıcıya uyarı ver
                    Toast.makeText(editProfile.this, "Lütfen tüm bilgileri girin.", Toast.LENGTH_SHORT).show();
                    return;
                }
                double height = Double.parseDouble(heightStr);
                double weight = Double.parseDouble(weightStr);
                SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name", name);
                editor.putString("surname", surname);
                editor.putString("height", heightStr);
                editor.putString("weight", weightStr);
                editor.putString("birthDate", birthDate);
                editor.apply();
                Toast.makeText(editProfile.this, "Profil bilgileriniz kaydedildi.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(editProfile.this, anasayfa.class);
                startActivity(intent);
                finish();
            }
        });
    }
}