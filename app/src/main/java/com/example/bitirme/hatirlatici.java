package com.example.bitirme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.app.TimePickerDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Calendar;

public class hatirlatici extends AppCompatActivity {

    private EditText ilacAdiEditText;
    private Button saatSecButton, hatirlaticiEkleButton, geriDonButton; // Geri dön butonu eklendi
    private LinearLayout ilaclarLayout;
    private int selectedHour, selectedMinute;
    private SharedPreferences sharedPreferences;
    private ArrayList<String> ilaclarListesi = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hatirlatici);

        ilacAdiEditText = findViewById(R.id.ilacAdiEditText);
        saatSecButton = findViewById(R.id.saatSecButton);
        hatirlaticiEkleButton = findViewById(R.id.hatirlaticiEkleButton);
        geriDonButton = findViewById(R.id.geriDonButton); // Geri dön butonu tanımlandı
        ilaclarLayout = findViewById(R.id.ilaclarLayout);
        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        saatSecButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Saat seçimini başlat
                final Calendar c = Calendar.getInstance();
                selectedHour = c.get(Calendar.HOUR_OF_DAY);
                selectedMinute = c.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(hatirlatici.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                selectedHour = hourOfDay;
                                selectedMinute = minute;
                            }
                        }, selectedHour, selectedMinute, true);
                timePickerDialog.show();
            }
        });

        hatirlaticiEkleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ilacAdi = ilacAdiEditText.getText().toString();
                if (ilacAdi.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Lütfen ilaç adını girin.", Toast.LENGTH_SHORT).show();
                    return;
                }

                // AlarmManager ile hatırlatıcıyı ayarla
                setAlarm(selectedHour, selectedMinute, ilacAdi);

                // Ilac girdisini ve "sil" düğmesini oluştur
                addMedicineEntry(ilacAdi, selectedHour, selectedMinute);

                // İşlem başarılı mesajı göster
                Toast.makeText(getApplicationContext(), "Hatırlatıcı başarıyla eklendi.", Toast.LENGTH_SHORT).show();

                // İlaç adı alanını temizle
                ilacAdiEditText.setText("");
            }
        });

        // Geri dön butonu için OnClickListener eklendi
        geriDonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Aktiviteyi kapat
            }
        });
    }
    private void setAlarm(int hour, int minute, String ilacAdi) {
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent alarmIntent = new Intent(getApplicationContext(), AlarmReceiver.class);
        alarmIntent.putExtra("ilacAdi", ilacAdi);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_MUTABLE);
        Calendar alarmTime = Calendar.getInstance();
        alarmTime.set(Calendar.HOUR_OF_DAY, hour);
        alarmTime.set(Calendar.MINUTE, minute);
        alarmTime.set(Calendar.SECOND, 0);

        if (alarmTime.before(Calendar.getInstance())) {
            alarmTime.add(Calendar.DATE, 1); // Eğer belirlenen saat geçmişse, alarmı bir sonraki güne ertele
        }

        // Alarm kurma işlemi
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, alarmTime.getTimeInMillis(), pendingIntent);

        // Bildirim gösterme işlemi
        showNotification(alarmTime, ilacAdi);
    }

    @SuppressLint("MissingPermission")
    private void showNotification(Calendar alarmTime, String ilacAdi) {
        // Bildirim için PendingIntent oluştur
        Intent intent = new Intent(getApplicationContext(), hatirlatici.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

        // Bildirim mesajını oluştur
        String notificationMessage = "Hatırlatıcı: " + ilacAdi + "\nSaati: " + String.format("%02d:%02d", alarmTime.get(Calendar.HOUR_OF_DAY), alarmTime.get(Calendar.MINUTE));
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "default")
                .setSmallIcon(R.drawable.ic_notification_foreground)
                .setContentTitle("İlaç Hatırlatıcı")
                .setContentText(notificationMessage)
                .setContentIntent(pendingIntent)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true);

        // Bildirimi göster
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(1, builder.build());
    }

    private void addMedicineEntry(final String ilacAdi, int hour, int minute) {
        // Ilac metnini oluştur
        String ilacMetni = "İlaç Adı: " + ilacAdi + "\nHatırlatıcı Saati: " + String.format("%02d:%02d", hour, minute);

        // TextView olarak ekle
        TextView textView = new TextView(this);
        textView.setText(ilacMetni);
        ilaclarLayout.addView(textView);

        // "Sil" düğmesini oluştur
        Button deleteButton = new Button(this);
        deleteButton.setText("Sil");
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // İlaç girdisini kaldır
                ilaclarLayout.removeView(textView);
                ilaclarLayout.removeView((Button) v); // Sil düğmesini kaldır
            }
        });
        ilaclarLayout.addView(deleteButton);
    }
}