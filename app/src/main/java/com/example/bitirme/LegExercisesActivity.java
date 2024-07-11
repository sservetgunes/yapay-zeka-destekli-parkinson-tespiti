package com.example.bitirme;
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

public class LegExercisesActivity extends AppCompatActivity {

    // Yüz egzersizlerinin bilgilerini içeren dizi
    private ExerciseInfo[] legExercises = {
           };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leg_exercises);

        // ListView'i bul
        ListView listViewLegExercises = findViewById(R.id.listViewLegExercises);

        // ArrayAdapter ile ListView'e egzersizleri bağla
        ExerciseAdapter adapter = new ExerciseAdapter(this,legExercises);
        listViewLegExercises.setAdapter(adapter);

        // ListView'de bir öğeye tıklandığında o egzersizi göster
        listViewLegExercises.setOnItemClickListener((parent, view, position, id) -> {
            ExerciseInfo selectedExercise = legExercises[position];
            Toast.makeText(LegExercisesActivity.this, selectedExercise.getTitle(), Toast.LENGTH_SHORT).show();
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

        ExerciseAdapter(LegExercisesActivity context, ExerciseInfo[] exercises) {
            super(context, R.layout.activity_leg_exercises, exercises);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Öğenin görünümünü al
            View listItemView = convertView;
            if (listItemView == null) {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                listItemView = inflater.inflate(R.layout.activity_leg_exercises, parent, false);
            }

            // Egzersiz bilgilerini al
            ExerciseInfo currentExercise = getItem(position);

            // Görünümdeki bileşenlere egzersiz bilgilerini yerleştir
            ImageView imageViewExercise27 = listItemView.findViewById(R.id.yirmiyediexercise);

            TextView textViewExerciseTitle27 = listItemView.findViewById(R.id.yirmiyediexercisead);

            TextView textViewExerciseDescription27 = listItemView.findViewById(R.id.yirmiyediexercisetext);

            ImageView imageViewExercise28 = listItemView.findViewById(R.id.yirmisekizexercise);

            TextView textViewExerciseTitle28 = listItemView.findViewById(R.id.yirmisekizexercisead);

            TextView textViewExerciseDescription28 = listItemView.findViewById(R.id.yirmisekizexercisetext);

            ImageView imageViewExercise29 = listItemView.findViewById(R.id.yirmidokuzexercise);

            TextView textViewExerciseTitle29 = listItemView.findViewById(R.id.yirmidokuzexercisead);

            TextView textViewExerciseDescription29 = listItemView.findViewById(R.id.yirmidokuzexercisetext);
            return listItemView;
        }
    }
}