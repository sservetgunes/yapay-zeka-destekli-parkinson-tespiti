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

public class EyeExercisesActivity extends AppCompatActivity {

    // Yüz egzersizlerinin bilgilerini içeren dizi
    private ExerciseInfo[] eyeExercises = {
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eye_exercises);

        // ListView'i bul
        ListView listViewEyeExercises = findViewById(R.id.listViewEyeExercises);

        // ArrayAdapter ile ListView'e egzersizleri bağla
        ExerciseAdapter adapter = new ExerciseAdapter(this, eyeExercises);
        listViewEyeExercises.setAdapter(adapter);

        // ListView'de bir öğeye tıklandığında o egzersizi göster
        listViewEyeExercises.setOnItemClickListener((parent, view, position, id) -> {
            ExerciseInfo selectedExercise = eyeExercises[position];
            Toast.makeText(EyeExercisesActivity.this, selectedExercise.getTitle(), Toast.LENGTH_SHORT).show();
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

        ExerciseAdapter(EyeExercisesActivity context, ExerciseInfo[] exercises) {
            super(context, R.layout.activity_eye_exercises, exercises);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Öğenin görünümünü al
            View listItemView = convertView;
            if (listItemView == null) {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                listItemView = inflater.inflate(R.layout.activity_eye_exercises, parent, false);
            }

            // Egzersiz bilgilerini al
            ExerciseInfo currentExercise = getItem(position);

            // Görünümdeki bileşenlere egzersiz bilgilerini yerleştir
            ImageView imageViewExercise9 = listItemView.findViewById(R.id.dokuzexercise);

            TextView textViewExerciseTitle9 = listItemView.findViewById(R.id.dokuzexercisead);

            TextView textViewExerciseDescription9 = listItemView.findViewById(R.id.dokuzexercisetext);

            ImageView imageViewExercise10 = listItemView.findViewById(R.id.onexercise);

            TextView textViewExerciseTitle10 = listItemView.findViewById(R.id.onexercisead);

            TextView textViewExerciseDescription10 = listItemView.findViewById(R.id.onexercisetext);
            return listItemView;
        }
    }
}