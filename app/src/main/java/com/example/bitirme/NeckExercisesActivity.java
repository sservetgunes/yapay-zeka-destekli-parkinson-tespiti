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

public class NeckExercisesActivity extends AppCompatActivity {

    // Yüz egzersizlerinin bilgilerini içeren dizi
    private ExerciseInfo[] neckExercises = {
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neck_exercises);

        // ListView'i bul
        ListView listViewNeckExercises = findViewById(R.id.listViewNeckExercises);

        // ArrayAdapter ile ListView'e egzersizleri bağla
        ExerciseAdapter adapter = new ExerciseAdapter(this, neckExercises);
        listViewNeckExercises.setAdapter(adapter);

        // ListView'de bir öğeye tıklandığında o egzersizi göster
        listViewNeckExercises.setOnItemClickListener((parent, view, position, id) -> {
            ExerciseInfo selectedExercise = neckExercises[position];
            Toast.makeText(NeckExercisesActivity.this, selectedExercise.getTitle(), Toast.LENGTH_SHORT).show();
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

        ExerciseAdapter(NeckExercisesActivity context, ExerciseInfo[] exercises) {
            super(context, R.layout.activity_neck_exercises, exercises);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Öğenin görünümünü al
            View listItemView = convertView;
            if (listItemView == null) {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                listItemView = inflater.inflate(R.layout.activity_neck_exercises, parent, false);
            }

            // Egzersiz bilgilerini al
            ExerciseInfo currentExercise = getItem(position);

            // Görünümdeki bileşenlere egzersiz bilgilerini yerleştir
            ImageView imageViewExercise11 = listItemView.findViewById(R.id.onbirexercise);

            TextView textViewExerciseTitle11 = listItemView.findViewById(R.id.onbirexercisead);

            TextView textViewExerciseDescription11 = listItemView.findViewById(R.id.onbirexercisetext);

            ImageView imageViewExercise12 = listItemView.findViewById(R.id.onikiexercise);

            TextView textViewExerciseTitle12 = listItemView.findViewById(R.id.onikiexercisead);

            TextView textViewExerciseDescription12 = listItemView.findViewById(R.id.onikiexercisetext);

            ImageView imageViewExercise13 = listItemView.findViewById(R.id.onucexercise);

            TextView textViewExerciseTitle13 = listItemView.findViewById(R.id.onucexercisead);

            TextView textViewExerciseDescription13 = listItemView.findViewById(R.id.onucexercisetext);
            return listItemView;
        }
    }
}