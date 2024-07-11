package com.example.bitirme;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
public class ExerciseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        // Yüz Egzersizi Butonu
        Button buttonFaceExercises = findViewById(R.id.buttonFaceExercises);
        buttonFaceExercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Yüz egzersizleri sayfasına yönlendir
                Intent intent = new Intent(ExerciseActivity.this, FaceExercisesActivity.class);
                startActivity(intent);
            }
        });
        // Göz Egzersizi Butonu
        Button buttonEyeExercises = findViewById(R.id.buttonEyeExercises);
        buttonEyeExercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Göz egzersizleri sayfasına yönlendir
                Intent intent = new Intent(ExerciseActivity.this, EyeExercisesActivity.class);
                startActivity(intent);
            }
        });
        // Boyun Egzersizi Butonu
        Button buttonNeckExercises = findViewById(R.id.buttonNeckExercises);
        buttonNeckExercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Boyun egzersizleri sayfasına yönlendir
                Intent intent = new Intent(ExerciseActivity.this, NeckExercisesActivity.class);
                startActivity(intent);
            }
        });
        // Omuz Egzersizi Butonu
        Button buttonShoulderExercises = findViewById(R.id.buttonShoulderExercises);
        buttonShoulderExercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Omuz egzersizleri sayfasına yönlendir
                Intent intent = new Intent(ExerciseActivity.this, ShoulderExercisesActivity.class);
                startActivity(intent);
            }
        });
        // Kol Egzersizi Butonu
        Button buttonArmExercises = findViewById(R.id.buttonArmExercises);
        buttonArmExercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Kol egzersizleri sayfasına yönlendir
                Intent intent = new Intent(ExerciseActivity.this, ArmExercisesActivity.class);
                startActivity(intent);
            }
        });
        // El Egzersizi Butonu
        Button buttonHandExercises = findViewById(R.id.buttonHandExercises);
        buttonHandExercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // El egzersizleri sayfasına yönlendir
                Intent intent = new Intent(ExerciseActivity.this, HandExercisesActivity.class);
                startActivity(intent);
            }
        });
        // Gövde Egzersizi Butonu
        Button buttonCoreExercises = findViewById(R.id.buttonCoreExercises);
        buttonCoreExercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Gövde egzersizleri sayfasına yönlendir
                Intent intent = new Intent(ExerciseActivity.this, CoreExercisesActivity.class);
                startActivity(intent);
            }
        });
        // Bacak Egzersizi Butonu
        Button buttonLegExercises = findViewById(R.id.buttonLegExercises);
        buttonLegExercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Bacak egzersizleri sayfasına yönlendir
                Intent intent = new Intent(ExerciseActivity.this, LegExercisesActivity.class);
                startActivity(intent);
            }
        });
        // Duruş Egzersizi Butonu
        Button buttonPostureExercises = findViewById(R.id.buttonPostureExercises);
        buttonPostureExercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Duruş egzersizleri sayfasına yönlendir
                Intent intent = new Intent(ExerciseActivity.this, PostureExercisesActivity.class);
                startActivity(intent);
            }
        });
    }
}