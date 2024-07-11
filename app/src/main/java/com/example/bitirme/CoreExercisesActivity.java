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

public class CoreExercisesActivity extends AppCompatActivity {
    // Yüz egzersizlerinin bilgilerini içeren dizi
    private ExerciseInfo[] coreExercises = {
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_core_exercises);

        // ListView'i bul
        ListView listViewCoreExercises = findViewById(R.id.listViewCoreExercises);

        // ArrayAdapter ile ListView'e egzersizleri bağla
        ExerciseAdapter adapter = new ExerciseAdapter(this, coreExercises);
        listViewCoreExercises.setAdapter(adapter);

        // ListView'de bir öğeye tıklandığında o egzersizi göster
        listViewCoreExercises.setOnItemClickListener((parent, view, position, id) -> {
            ExerciseInfo selectedExercise = coreExercises[position];
            Toast.makeText(CoreExercisesActivity.this, selectedExercise.getTitle(), Toast.LENGTH_SHORT).show();
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

        ExerciseAdapter(CoreExercisesActivity context, ExerciseInfo[] exercises) {
            super(context, R.layout.activity_core_exercises, exercises);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Öğenin görünümünü al
            View listItemView = convertView;
            if (listItemView == null) {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                listItemView = inflater.inflate(R.layout.activity_core_exercises, parent, false);
            }

            // Egzersiz bilgilerini al
            CoreExercisesActivity.ExerciseInfo currentExercise = getItem(position);

            // Görünümdeki bileşenlere egzersiz bilgilerini yerleştir
            ImageView imageViewExercise23 = listItemView.findViewById(R.id.yirmiucexercise);

            TextView textViewExerciseTitle23 = listItemView.findViewById(R.id.yirmiucexercisead);

            TextView textViewExerciseDescription23 = listItemView.findViewById(R.id.yirmiucexercisetext);

            ImageView imageViewExercise24 = listItemView.findViewById(R.id.yirmidortexercise);

            TextView textViewExerciseTitle24 = listItemView.findViewById(R.id.yirmidortexercisead);

            TextView textViewExerciseDescription24 = listItemView.findViewById(R.id.yirmidortexercisetext);

            ImageView imageViewExercise25 = listItemView.findViewById(R.id.yirmibesexercise);

            TextView textViewExerciseTitle25 = listItemView.findViewById(R.id.yirmibesexercisead);

            TextView textViewExerciseDescription25 = listItemView.findViewById(R.id.yirmibesexercisetext);

            ImageView imageViewExercise26 = listItemView.findViewById(R.id.yirmialtiexercise);

            TextView textViewExerciseTitle26 = listItemView.findViewById(R.id.yirmialtiexercisead);

            TextView textViewExerciseDescription26 = listItemView.findViewById(R.id.yirmialtiexercisetext);
            return listItemView;
        }
    }
}