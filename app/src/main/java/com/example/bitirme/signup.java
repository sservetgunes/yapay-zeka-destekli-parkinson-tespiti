package com.example.bitirme;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class signup extends AppCompatActivity {
    private static final int PICK_IMAGE = 100;
    private Uri selectedImageUri;

    EditText usernameEditText, emailEditText, passwordEditText;
    ImageView profileImageView;
    Button registerButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "");
        String email = sharedPreferences.getString("email", "");
        String password = sharedPreferences.getString("password", "");

        if (!username.isEmpty() && !email.isEmpty() && !password.isEmpty()) {
            // Kullanıcı bilgileri mevcut, otomatik giriş yap
            Intent intent = new Intent(signup.this, anasayfa.class);
            startActivity(intent);
            finish(); // Kayıt ekranını kapat
        }

        setContentView(R.layout.activity_signup);
        usernameEditText = findViewById(R.id.editTextUsername);
        emailEditText = findViewById(R.id.editTextEmail);
        passwordEditText = findViewById(R.id.editTextPassword);
        profileImageView = findViewById(R.id.profileImageView);
        registerButton = findViewById(R.id.buttonRegister);
        profileImageView.setOnClickListener(v -> openGallery());
        registerButton.setOnClickListener(v -> {
            String newUsername = usernameEditText.getText().toString(); // username değişkenini newUsername olarak değiştirdik
            String newEmail = emailEditText.getText().toString();
            String newPassword = passwordEditText.getText().toString();
            if (newUsername.isEmpty() || newEmail.isEmpty() || newPassword.isEmpty()) {
                Toast.makeText(signup.this, "Lütfen tüm alanları doldurun", Toast.LENGTH_SHORT).show();
            } else {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username", newUsername); // Burada da newUsername kullanılacak
                editor.putString("email", newEmail);
                editor.putString("password", newPassword);
                if (selectedImageUri != null) {
                    editor.putString("profileImageUri", selectedImageUri.toString());
                }
                editor.apply();
                Toast.makeText(signup.this, "Kayıt başarılı", Toast.LENGTH_SHORT).show();
                // Kayıt işlemi başarılı olduğunda anasayfaya geçiş yap
                Intent intent = new Intent(signup.this, anasayfa.class);
                startActivity(intent);
                finish(); // Kayıt ekranını kapat
            }
        });
    }
    private void openGallery() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            Uri imageUri = data.getData();
            profileImageView.setImageURI(imageUri);
            selectedImageUri = imageUri;
        }
    }
}


