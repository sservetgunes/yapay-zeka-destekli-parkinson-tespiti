package com.example.bitirme;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
public class diyetlisteleri extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diyetlisteleri);
// Geri dönüş butonunu bul
        Button backButton = findViewById(R.id.buttonBack);
        // Geri dönüş butonuna tıklama işlevi ekle
        backButton.setOnClickListener(view -> onBackPressed());
        // Gün 1
        TextView textViewDay1Title = findViewById(R.id.textViewTitleSampleDiets1);
        TextView textViewDay1BreakfastTitle = findViewById(R.id.textViewTitle1);
        TextView textViewDay1BreakfastContent = findViewById(R.id.textViewContent1);
        TextView textViewDay1MorningSnackTitle = findViewById(R.id.textViewTitle2);
        TextView textViewDay1MorningSnackContent = findViewById(R.id.textViewContent2);
        TextView textViewDay1LunchTitle = findViewById(R.id.textViewTitle3);
        TextView textViewDay1LunchContent = findViewById(R.id.textViewContent3);
        TextView textViewDay1AfternoonSnackTitle = findViewById(R.id.textViewTitle4);
        TextView textViewDay1AfternoonSnackContent = findViewById(R.id.textViewContent4);
        TextView textViewDay1DinnerTitle = findViewById(R.id.textViewTitle5);
        TextView textViewDay1DinnerContent = findViewById(R.id.textViewContent5);

        // Gün 2
        TextView textViewDay2Title = findViewById(R.id.textViewTitleSampleDiets2);
        TextView textViewDay2BreakfastTitle = findViewById(R.id.textViewTitle6);
        TextView textViewDay2BreakfastContent = findViewById(R.id.textViewContent6);
        TextView textViewDay2MorningSnackTitle = findViewById(R.id.textViewTitle7);
        TextView textViewDay2MorningSnackContent = findViewById(R.id.textViewContent7);
        TextView textViewDay2LunchTitle = findViewById(R.id.textViewTitle8);
        TextView textViewDay2LunchContent = findViewById(R.id.textViewContent8);
        TextView textViewDay2AfternoonSnackTitle = findViewById(R.id.textViewTitle9);
        TextView textViewDay2AfternoonSnackContent = findViewById(R.id.textViewContent9);
        TextView textViewDay2DinnerTitle = findViewById(R.id.textViewTitle10);
        TextView textViewDay2DinnerContent = findViewById(R.id.textViewContent10);

        // Gün 3
        TextView textViewDay3Title = findViewById(R.id.textViewSampleDiets3);
        TextView textViewDay3BreakfastTitle = findViewById(R.id.textViewTitle11);
        TextView textViewDay3BreakfastContent = findViewById(R.id.textViewContent11);
        TextView textViewDay3MorningSnackTitle = findViewById(R.id.textViewTitle12);
        TextView textViewDay3MorningSnackContent = findViewById(R.id.textViewContent12);
        TextView textViewDay3LunchTitle = findViewById(R.id.textViewTitle13);
        TextView textViewDay3LunchContent = findViewById(R.id.textViewContent13);
        TextView textViewDay3AfternoonSnackTitle = findViewById(R.id.textViewTitle14);
        TextView textViewDay3AfternoonSnackContent = findViewById(R.id.textViewContent14);
        TextView textViewDay3DinnerTitle = findViewById(R.id.textViewTitle15);
        TextView textViewDay3DinnerContent = findViewById(R.id.textViewContent15);

        // Gün 4
        TextView textViewDay4Title = findViewById(R.id.textViewSampleDiets4);
        TextView textViewDay4BreakfastTitle = findViewById(R.id.textViewTitle16);
        TextView textViewDay4BreakfastContent = findViewById(R.id.textViewContent45);
        TextView textViewDay4MorningSnackTitle = findViewById(R.id.textViewTitle17);
        TextView textViewDay4MorningSnackContent = findViewById(R.id.textViewContent49);
        TextView textViewDay4LunchTitle = findViewById(R.id.textViewTitle18);
        TextView textViewDay4LunchContent = findViewById(R.id.textViewContent50);
        TextView textViewDay4AfternoonSnackTitle = findViewById(R.id.textViewTitle19);
        TextView textViewDay4AfternoonSnackContent = findViewById(R.id.textViewContent54);
        TextView textViewDay4DinnerTitle = findViewById(R.id.textViewTitle20);
        TextView textViewDay4DinnerContent = findViewById(R.id.textViewContent55);

        // Gün 5
        TextView textViewDay5Title = findViewById(R.id.textViewSampleDiets5);
        TextView textViewDay5BreakfastTitle = findViewById(R.id.textViewTitle21);
        TextView textViewDay5BreakfastContent = findViewById(R.id.textViewContent58);
        TextView textViewDay5MorningSnackTitle = findViewById(R.id.textViewTitle22);
        TextView textViewDay5MorningSnackContent = findViewById(R.id.textViewContent62);
        TextView textViewDay5LunchTitle = findViewById(R.id.textViewTitle23);
        TextView textViewDay5LunchContent = findViewById(R.id.textViewContent63);
        TextView textViewDay5AfternoonSnackTitle = findViewById(R.id.textViewTitle24);
        TextView textViewDay5AfternoonSnackContent = findViewById(R.id.textViewContent66);
        TextView textViewDay5DinnerTitle = findViewById(R.id.textViewTitle25);
        TextView textViewDay5DinnerContent = findViewById(R.id.textViewContent67);
    }
}