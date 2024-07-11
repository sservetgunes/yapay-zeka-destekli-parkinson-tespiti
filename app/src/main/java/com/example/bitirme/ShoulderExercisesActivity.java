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
public class ShoulderExercisesActivity extends AppCompatActivity {
    // Yüz egzersizlerinin bilgilerini içeren dizi
    private ExerciseInfo[] shoulderExercises = {
 };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoulder_exercises);
        // ListView'i bul
        ListView listViewShoulderExercises = findViewById(R.id.listViewShoulderExercises);
        // ArrayAdapter ile ListView'e egzersizleri bağla
        ExerciseAdapter adapter = new ExerciseAdapter(this, shoulderExercises);
        listViewShoulderExercises.setAdapter(adapter);
        // ListView'de bir öğeye tıklandığında o egzersizi göster
        listViewShoulderExercises.setOnItemClickListener((parent, view, position, id) -> {
            ExerciseInfo selectedExercise = shoulderExercises[position];
            Toast.makeText(ShoulderExercisesActivity.this, selectedExercise.getTitle(), Toast.LENGTH_SHORT).show();
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
        ExerciseAdapter(ShoulderExercisesActivity context, ExerciseInfo[] exercises) {
            super(context, R.layout.activity_shoulder_exercises, exercises);
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Öğenin görünümünü al
            View listItemView = convertView;
            if (listItemView == null) {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                listItemView = inflater.inflate(R.layout.activity_shoulder_exercises, parent, false);
            }
            // Egzersiz bilgilerini al
            ExerciseInfo currentExercise = getItem(position);
            // Görünümdeki bileşenlere egzersiz bilgilerini yerleştir
            ImageView imageViewExercise14 = listItemView.findViewById(R.id.ondortexercise);
            TextView textViewExerciseTitle14 = listItemView.findViewById(R.id.ondortexercisead);
            TextView textViewExerciseDescription14 = listItemView.findViewById(R.id.onbirexercisetext);
            ImageView imageViewExercise15 = listItemView.findViewById(R.id.onbesexercise);
            TextView textViewExerciseTitle15 = listItemView.findViewById(R.id.onbesexercisead);
            TextView textViewExerciseDescription15 = listItemView.findViewById(R.id.onbesexercisetext);
            return listItemView;
        }
    }
}