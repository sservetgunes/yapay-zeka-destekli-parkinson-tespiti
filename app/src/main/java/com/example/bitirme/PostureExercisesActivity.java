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

public class PostureExercisesActivity extends AppCompatActivity {

    // Yüz egzersizlerinin bilgilerini içeren dizi
    private ExerciseInfo[] postureExercises = {
};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posture_exercises);

        // ListView'i bul
        ListView listViewPostureExercises = findViewById(R.id.listViewPostureExercises);

        // ArrayAdapter ile ListView'e egzersizleri bağla
        ExerciseAdapter adapter = new ExerciseAdapter(this, postureExercises);
        listViewPostureExercises.setAdapter(adapter);

        // ListView'de bir öğeye tıklandığında o egzersizi göster
        listViewPostureExercises.setOnItemClickListener((parent, view, position, id) -> {
            ExerciseInfo selectedExercise = postureExercises[position];
            Toast.makeText(PostureExercisesActivity.this, selectedExercise.getTitle(), Toast.LENGTH_SHORT).show();
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

        ExerciseAdapter(PostureExercisesActivity context, ExerciseInfo[] exercises) {
            super(context, R.layout.activity_posture_exercises, exercises);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Öğenin görünümünü al
            View listItemView = convertView;
            if (listItemView == null) {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                listItemView = inflater.inflate(R.layout.activity_posture_exercises, parent, false);
            }

            // Egzersiz bilgilerini al
            ExerciseInfo currentExercise = getItem(position);

            // Görünümdeki bileşenlere egzersiz bilgilerini yerleştir
            ImageView imageViewExercise30 = listItemView.findViewById(R.id.otuzexercise);

            TextView textViewExerciseTitle30 = listItemView.findViewById(R.id.otuzexercisead);

            TextView textViewExerciseDescription30 = listItemView.findViewById(R.id.otuzexercisetext);

            ImageView imageViewExercise31 = listItemView.findViewById(R.id.otuzbirexercise);

            TextView textViewExerciseTitle31 = listItemView.findViewById(R.id.otuzbirexercisead);

            TextView textViewExerciseDescription31 = listItemView.findViewById(R.id.otuzbirexercisetext);

            ImageView imageViewExercise32 = listItemView.findViewById(R.id.otuzikiexercise);

            TextView textViewExerciseTitle32 = listItemView.findViewById(R.id.otuzikiexercisead);

            TextView textViewExerciseDescription32 = listItemView.findViewById(R.id.otuzikiexercisetext);

            ImageView imageViewExercise33 = listItemView.findViewById(R.id.otuzucexercise);

            TextView textViewExerciseTitle33 = listItemView.findViewById(R.id.otuzucexercisead);

            TextView textViewExerciseDescription33 = listItemView.findViewById(R.id.otuzucexercisetext);

            ImageView imageViewExercise34 = listItemView.findViewById(R.id.otuzdortexercise);

            TextView textViewExerciseTitle34 = listItemView.findViewById(R.id.otuzdortexercisead);

            TextView textViewExerciseDescription34 = listItemView.findViewById(R.id.otuzdortexercisetext);

            ImageView imageViewExercise35 = listItemView.findViewById(R.id.otuzbesexercise);

            TextView textViewExerciseTitle35 = listItemView.findViewById(R.id.otuzbesexercisead);

            TextView textViewExerciseDescription35 = listItemView.findViewById(R.id.otuzbesexercisetext);

            ImageView imageViewExercise36 = listItemView.findViewById(R.id.otuzaltiexercise);

            TextView textViewExerciseTitle36 = listItemView.findViewById(R.id.otuzaltiexercisead);

            TextView textViewExerciseDescription36 = listItemView.findViewById(R.id.otuzaltiexercisetext);

            ImageView imageViewExercise37 = listItemView.findViewById(R.id.otuzyediexercise);

            TextView textViewExerciseTitle37 = listItemView.findViewById(R.id.otuzyediexercisead);

            TextView textViewExerciseDescription37 = listItemView.findViewById(R.id.otuzyediexercisetext);



            return listItemView;
        }
    }
}