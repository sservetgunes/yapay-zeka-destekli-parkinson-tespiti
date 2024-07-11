package com.example.bitirme;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String ilacAdi = intent.getStringExtra("ilacAdi");
        Toast.makeText(context, "İlaç zamanı: " + ilacAdi, Toast.LENGTH_LONG).show();
    }
}
