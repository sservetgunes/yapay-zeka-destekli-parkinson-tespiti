package com.example.bitirme;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
public class accelerometer extends Activity implements SensorEventListener {
    private TextView xText, yText, zText, dataTextView;
    private Button saveDataButton, showDataButton;
    private SensorManager sensorManager;
    private Sensor accelerometer;
    private File file;
    private long lastSaveTimeStamp = 0;
    private final long INTERVAL = 30000; // 30 saniyede bir veri kaydet
    // TensorFlow Lite modeli
    private ModelLoader modelLoader;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Create sensor manager
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        // Accelerometer sensor
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        // Assign TextViews
        xText = findViewById(R.id.xText);
        yText = findViewById(R.id.yText);
        zText = findViewById(R.id.zText);
        dataTextView = findViewById(R.id.dataTextView);
        saveDataButton = findViewById(R.id.saveDataButton);
        showDataButton = findViewById(R.id.showDataButton);
        // Dosya yolu oluştur
        File externalDir = getExternalFilesDir(null);
        file = new File(externalDir, "ivme_verileri.txt");
        // TensorFlow Lite modelini yükle
        String modelPath = "model.tflite";
        this.modelLoader = new ModelLoader(modelPath);
        // Save data button onClick listener
        saveDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Verileri kaydet
                saveDataToFile();
            }
        });
        // Show data button onClick listener
        showDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Kaydedilen verileri göster
                showSavedData();
                predictParkinson();
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        // Register accelerometer sensor listener
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    protected void onPause() {
        super.onPause();
        // Unregister accelerometer sensor listener
        sensorManager.unregisterListener(this);
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
    @Override
    public void onSensorChanged(SensorEvent event) {
        // Get accelerometer values
        float xValue = event.values[0];
        float yValue = event.values[1];
        float zValue = event.values[2];
        // Update TextViews
        xText.setText("X: " + xValue);
        yText.setText("Y: " + yValue);
        zText.setText("Z: " + zValue);
    }
    private void saveDataToFile() {
        // Veriyi dosyaya kaydet
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);
        int millis = cal.get(Calendar.MILLISECOND);
        // Calculate frequency
        long currentTimeStamp = System.currentTimeMillis();
        double frequency = 0.0;
        if (lastSaveTimeStamp != 0) {
            long elapsedTime = currentTimeStamp - lastSaveTimeStamp;
            if (elapsedTime > 0) {
                frequency = 1000.0 / elapsedTime;
            }
        }
        // Veriyi dosyaya yaz
        try {
            FileOutputStream fos = new FileOutputStream(file, true);
            String data = "Time: " + year + "/" + month + "/" + day + " " + hour + ":" + minute + ":" + second + "." + millis +
                    ", X: " + xText.getText().toString().split(": ")[1] +
                    ", Y: " + yText.getText().toString().split(": ")[1] +
                    ", Z: " + zText.getText().toString().split(": ")[1] +
                    ", Frequency: " + frequency + " Hz\n";
            fos.write(data.getBytes());
            fos.close();
            lastSaveTimeStamp = currentTimeStamp; // Update last save time stamp
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showSavedData() {
        // Kaydedilen verileri dosyadan oku ve TextView'e ekle
        try {
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader reader = new BufferedReader(isr);

            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            dataTextView.setText(stringBuilder.toString());
            fis.close();
            isr.close();
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void predictParkinson() {
        // Frekansı al
        String lastLine = dataTextView.getText().toString().trim();
        double frequency = Double.parseDouble(lastLine.substring(lastLine.lastIndexOf("Frequency: ") + 11, lastLine.lastIndexOf(" Hz")));
        // TensorFlow Lite input şeklini belirle
        float[][] input = new float[1][1];
        input[0] = new float[]{(float) frequency};
        // TensorFlow Lite modelini çalıştır
        float[][] output = new float[1][1];
        modelLoader.runModel(input);
        // Tahmin sonucunu al
        float prediction = output[0][0];
        // Tahmin sonucuna göre mesaj oluştur
        String message;
        if (prediction < 0.5) {
            message = "Parkinson hastası olma olasılığı düşük.";
        } else {
            message = "Parkinson hastası olma olasılığı yüksek.";
        }
        dataTextView.setText(message);
    }
    }
