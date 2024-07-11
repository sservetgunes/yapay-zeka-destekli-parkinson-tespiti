package com.example.bitirme;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class test extends AppCompatActivity {
    private TextView questionTextView;
    private RadioGroup answersRadioGroup;
    private Button nextButton;
    // Sorular ve cevaplar
    private String[] questions;
    private int questionIndex = 0;
    private int[] answers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        // XML dosyasındaki görünümleri tanımla
        questionTextView = findViewById(R.id.questionTextView);
        answersRadioGroup = findViewById(R.id.answersRadioGroup);
        nextButton = findViewById(R.id.nextButton);
        // Soruları ve cevapları tanımla
        questions = getResources().getStringArray(R.array.questions);
        answers = new int[questions.length];
        // İlk soruyu göster
        showQuestion();
        // "Sonraki" butonuna tıklama işlemi ekle
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Seçilen cevabı al
                int selectedRadioButtonId = answersRadioGroup.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
                String answerText = selectedRadioButton.getText().toString();
                // Cevabı işle
                processAnswer(answerText);
                // Bir sonraki soruyu göster
                questionIndex++;
                if (questionIndex < questions.length) {
                    showQuestion();
                } else {
                    // Tüm sorular cevaplandı, sonucu göster
                    showResult();
                }
            }
        });
    }
    private void showQuestion() {
        // Soruyu göster
        questionTextView.setText(questions[questionIndex]);
        // Önceki seçimi temizle
        answersRadioGroup.clearCheck();
    }
    private void processAnswer(String answerText) {
        // Seçilen cevabı log mesajıyla kontrol et
        Log.d("QuestionActivity", "Seçilen cevap: " + answerText);
        // Seçilen cevaba göre puanı kaydet
        int answerScore;
        switch (answerText) {
            case "a) Evet, çok fazla":
                answerScore = 3; // Doğru puanı buraya tanımlayın
                break;
            case "b) Evet, orta seviyede":
                answerScore = 2;
                break;
            case "c) Evet, az seviyede":
                answerScore = 1;
                break;
            default:
                answerScore = 0;
                break;
        }
        // Cevabı kaydet
        answers[questionIndex] = answerScore;
        // Puanlama sonucunu log mesajıyla kontrol et
        Log.d("QuestionActivity", "Cevap puanı: " + answerScore);
    }
    private void showResult() {
        // Sonuçları hesapla
        int totalScore = 0;
        for (int score : answers) {
            totalScore += score;
        }
        // Sonucu belirle
        String resultMessage;
        if (totalScore >= 15) {
            resultMessage = "Parkinson hastası olabilirsiniz. Lütfen uzman bir doktora danışın.";
        } else {
            resultMessage = "Parkinson hastası olma olasılığınız düşük.";
        }
        // Log mesajı ekle
        Log.d("QuestionActivity", "Sonuç mesajı: " + resultMessage);
        // Sonucu göster
        Intent intent = new Intent(this, testSonucu.class);
        intent.putExtra("RESULT_MESSAGE", resultMessage); // Doğru ekstra veriyi gönderiyoruz
        startActivity(intent);
    }


}