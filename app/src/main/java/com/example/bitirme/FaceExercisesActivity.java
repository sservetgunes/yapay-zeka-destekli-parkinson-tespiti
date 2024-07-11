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

public class FaceExercisesActivity extends AppCompatActivity {

    // Yüz egzersizlerinin bilgilerini içeren dizi
    private ExerciseInfo[] faceExercises = {

    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_face_exercises);

        // ListView'i bul
        ListView listViewFaceExercises = findViewById(R.id.listViewFaceExercises);

        // ArrayAdapter ile ListView'e egzersizleri bağla
        ExerciseAdapter adapter = new ExerciseAdapter(this, faceExercises);
        listViewFaceExercises.setAdapter(adapter);

        // ListView'de bir öğeye tıklandığında o egzersizi göster
        listViewFaceExercises.setOnItemClickListener((parent, view, position, id) -> {
            ExerciseInfo selectedExercise = faceExercises[position];
            Toast.makeText(FaceExercisesActivity.this, selectedExercise.getTitle(), Toast.LENGTH_SHORT).show();
            // Burada tıklanan egzersizin detaylarını göstermek için ilgili işlevselliği ekleyebilirsiniz
        });
    }

    // Egzersiz bilgilerini tutan iç içe sınıf
    static class ExerciseInfo {
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

        ExerciseAdapter(FaceExercisesActivity context, ExerciseInfo[] exercises) {
            super(context, R.layout.activity_face_exercises, exercises);
        }


        @Override
        public View getView(int position, View convertView,  ViewGroup parent) {
            // Öğenin görünümünü al
            View listItemView = convertView;
            if (listItemView == null) {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                listItemView = inflater.inflate(R.layout.activity_face_exercises, parent, false);
            }

            // Egzersiz bilgilerini al
            ExerciseInfo currentExercise = getItem(position);

            // Görünümdeki bileşenlere egzersiz bilgilerini yerleştir
            // Görünümdeki bileşenlere egzersiz bilgilerini yerleştir
            ImageView imageViewExercise1 = listItemView.findViewById(R.id.birexercise);

            TextView textViewExerciseTitle1 = listItemView.findViewById(R.id.birexercisead);

            TextView textViewExerciseDescription1 = listItemView.findViewById(R.id.birexercisetext);

            ImageView imageViewExercise2 = listItemView.findViewById(R.id.ikiexercise);

            TextView textViewExerciseTitle2 = listItemView.findViewById(R.id.ikiexercisead);

            TextView textViewExerciseDescription2 = listItemView.findViewById(R.id.ikiexercisetext);

            ImageView imageViewExercise3 = listItemView.findViewById(R.id.ucexercise);

            TextView textViewExerciseTitle3 = listItemView.findViewById(R.id.ucexercisead);

            TextView textViewExerciseDescription3 = listItemView.findViewById(R.id.ucexercisetext);

            ImageView imageViewExercise4 = listItemView.findViewById(R.id.dortexercise);

            TextView textViewExerciseTitle4 = listItemView.findViewById(R.id.dortexercisead);

            TextView textViewExerciseDescription4 = listItemView.findViewById(R.id.dortexercisetext);

            ImageView imageViewExercise5 = listItemView.findViewById(R.id.besexercise);

            TextView textViewExerciseTitle5 = listItemView.findViewById(R.id.besexercisead);

            TextView textViewExerciseDescription5 = listItemView.findViewById(R.id.besexercisetext);

            ImageView imageViewExercise6 = listItemView.findViewById(R.id.altiexercise);

            TextView textViewExerciseTitle6 = listItemView.findViewById(R.id.altiexercisead);

            TextView textViewExerciseDescription6 = listItemView.findViewById(R.id.altiexercisetext);

            ImageView imageViewExercise7 = listItemView.findViewById(R.id.yediexercise);

            TextView textViewExerciseTitle7 = listItemView.findViewById(R.id.yediexercisead);

            TextView textViewExerciseDescription7 = listItemView.findViewById(R.id.yediexercisetext);

            ImageView imageViewExercise8 = listItemView.findViewById(R.id.sekizexercise);

            TextView textViewExerciseTitle8 = listItemView.findViewById(R.id.sekizexercisead);

            TextView textViewExerciseDescription8 = listItemView.findViewById(R.id.sekizexercisetext);




            return listItemView;
        }
    }}