package com.example.bitirme;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.Manifest;
import android.content.pm.PackageManager;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;

public class anasayfa extends AppCompatActivity {
    private Button editProfileButton, hareketbuton, hatirlaticibuton, egzersizbuton, beslenmebuton, testbuton,
            randevubuton, logoutButton;
    private ImageView profileImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anasayfa);
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "");
        String email = sharedPreferences.getString("email", "");
        String password = sharedPreferences.getString("password", "");

        if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            Intent intent = new Intent(anasayfa.this, signup.class);
            startActivity(intent);
            finish();
        } else {
            String name = sharedPreferences.getString("name", "");
            if (name.isEmpty()) {
                Intent intent = new Intent(anasayfa.this, editProfile.class);
                startActivity(intent);
                finish();
            }
        }
        editProfileButton = findViewById(R.id.editProfileButton);
        hareketbuton = findViewById(R.id.hareketbuton);
        hatirlaticibuton = findViewById(R.id.hatirlaticibuton);
        egzersizbuton = findViewById(R.id.egzersizbuton);
        beslenmebuton = findViewById(R.id.beslenmebuton);
        testbuton = findViewById(R.id.testbuton);
        randevubuton = findViewById(R.id.randevubuton);
        logoutButton = findViewById(R.id.logoutButton);
        profileImageView = findViewById(R.id.profileImageView);
        loadProfileImage();
        editProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Profil düzenleme sayfasına git
                Intent intent = new Intent(anasayfa.this, editProfile.class);
                startActivity(intent);
            }
        });
        hareketbuton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(anasayfa.this, accelerometer.class);
                startActivity(intent);
            }
        });
        hatirlaticibuton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(anasayfa.this, hatirlatici.class);
                startActivity(intent);
            }
        });
        egzersizbuton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(anasayfa.this, ExerciseActivity.class);
                startActivity(intent);
            }
        });
        beslenmebuton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(anasayfa.this, beslenme.class);
                startActivity(intent);
            }
        });
        testbuton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(anasayfa.this, test.class);
                startActivity(intent);
            }
        });
        randevubuton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.mhrs.gov.tr";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });
        logoutButton.setOnClickListener(v -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.apply();
            Intent intent = new Intent(anasayfa.this, signup.class);
            startActivity(intent);
            finish();
        });
    }
    private static final int PERMISSION_REQUEST_CODE = 100;
    private void loadProfileImage() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
        } else {
            SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
            String profileImageUriString = sharedPreferences.getString("profileImageUri", null);
            if (profileImageUriString != null) {
                try {
                    Uri profileImageUri = Uri.parse(profileImageUriString);
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), profileImageUri);
                    profileImageView.setImageBitmap(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

