package com.example.bitirme;
import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class HandExercisesActivity extends AppCompatActivity {

    // Yüz egzersizlerinin bilgilerini içeren dizi
    private ExerciseInfo[] handExercises = {
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hand_exercises);

        // ListView'i bul
        ListView listViewHandExercises = findViewById(R.id.listViewHandExercises);

        // ArrayAdapter ile ListView'e egzersizleri bağla
        ExerciseAdapter adapter = new ExerciseAdapter(this,handExercises);
        listViewHandExercises.setAdapter(adapter);

        // ListView'de bir öğeye tıklandığında o egzersizi göster
        listViewHandExercises.setOnItemClickListener((parent, view, position, id) -> {
            ExerciseInfo selectedExercise = handExercises[position];
            Toast.makeText(HandExercisesActivity.this, selectedExercise.getTitle(), Toast.LENGTH_SHORT).show();
            // Burada tıklanan egzersizin detaylarını göstermek için ilgili işlevselliği ekleyebilirsiniz
        });
    }

    // Egzersiz bilgilerini tutan iç içe sınıf
    private static class ExerciseInfo {
        private String title;
        private String description;
        private int imageResourceId;

        ExerciseInfo(String title, String description, int imageResourceId) {
            this.title = title;
            this.description = description;
            this.imageResourceId = imageResourceId;
        }

        String getTitle() {
            return title;
        }

        String getDescription() {
            return description;
        }

        int getImageResourceId() {
            return imageResourceId;
        }
    }

    // ListView için özel bir ArrayAdapter
    private static class ExerciseAdapter extends ArrayAdapter<ExerciseInfo> {

        ExerciseAdapter(HandExercisesActivity context, ExerciseInfo[] exercises) {
            super(context, R.layout.activity_hand_exercises, exercises);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Öğenin görünümünü al
            View listItemView = convertView;
            if (listItemView == null) {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                listItemView = inflater.inflate(R.layout.activity_hand_exercises, parent, false);
            }

            // Egzersiz bilgilerini al
            ExerciseInfo currentExercise = getItem(position);

            // Görünümdeki bileşenlere egzersiz bilgilerini yerleştir
            ImageView imageViewExercise20 = listItemView.findViewById(R.id.yirmiexercise);

            TextView textViewExerciseTitle20 = listItemView.findViewById(R.id.yirmiexercisead);

            TextView textViewExerciseDescription20 = listItemView.findViewById(R.id.yirmiexercisetext);

            ImageView imageViewExercise21 = listItemView.findViewById(R.id.yirmibirexercise);

            TextView textViewExerciseTitle21 = listItemView.findViewById(R.id.yirmibirexercisead);

            TextView textViewExerciseDescription21 = listItemView.findViewById(R.id.yirmibirexercisetext);

            ImageView imageViewExercise22 = listItemView.findViewById(R.id.yirmiikiexercise);

            TextView textViewExerciseTitle22 = listItemView.findViewById(R.id.yirmiikiexercisead);

            TextView textViewExerciseDescription22 = listItemView.findViewById(R.id.yirmiikiexercisetext);
            return listItemView;
        }
    }
}