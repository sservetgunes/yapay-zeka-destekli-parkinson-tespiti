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

public class ArmExercisesActivity extends AppCompatActivity {
    // Yüz egzersizlerinin bilgilerini içeren dizi
    private ExerciseInfo[] armExercises = {
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arm_exercises);

        // ListView'i bul
        ListView listViewArmExercises = findViewById(R.id.listViewArmExercises);

        // ArrayAdapter ile ListView'e egzersizleri bağla
        ExerciseAdapter adapter = new ExerciseAdapter(this, armExercises);
        listViewArmExercises.setAdapter(adapter);

        // ListView'de bir öğeye tıklandığında o egzersizi göster
        listViewArmExercises.setOnItemClickListener((parent, view, position, id) -> {
            ExerciseInfo selectedExercise = armExercises[position];
            Toast.makeText(ArmExercisesActivity.this, selectedExercise.getTitle(), Toast.LENGTH_SHORT).show();
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

        ExerciseAdapter(ArmExercisesActivity context, ArmExercisesActivity.ExerciseInfo[] exercises) {
            super(context, R.layout.activity_arm_exercises, exercises);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Öğenin görünümünü al
            View listItemView = convertView;
            if (listItemView == null) {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                listItemView = inflater.inflate(R.layout.activity_arm_exercises, parent, false);
            }

            // Egzersiz bilgilerini al
            ArmExercisesActivity.ExerciseInfo currentExercise = getItem(position);

            // Görünümdeki bileşenlere egzersiz bilgilerini yerleştir
            ImageView imageViewExercise16 = listItemView.findViewById(R.id.onaltiexercise);

            TextView textViewExerciseTitle16 = listItemView.findViewById(R.id.onaltiexercisead);

            TextView textViewExerciseDescription16 = listItemView.findViewById(R.id.onaltiexercisetext);

            ImageView imageViewExercise17 = listItemView.findViewById(R.id.onyediexercise);

            TextView textViewExerciseTitle17 = listItemView.findViewById(R.id.onyediexercisead);

            TextView textViewExerciseDescription17 = listItemView.findViewById(R.id.onyediexercisetext);

            ImageView imageViewExercise18 = listItemView.findViewById(R.id.onsekizexercise);

            TextView textViewExerciseTitle18 = listItemView.findViewById(R.id.onsekizexercisead);

            TextView textViewExerciseDescription18 = listItemView.findViewById(R.id.onsekizexercisetext);

            ImageView imageViewExercise19 = listItemView.findViewById(R.id.ondokuzexercise);

            TextView textViewExerciseTitle19 = listItemView.findViewById(R.id.ondokuzexercisead);

            TextView textViewExerciseDescription19 = listItemView.findViewById(R.id.ondokuzexercisetext);
            return listItemView;
        }
    }
}