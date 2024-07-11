package com.example.bitirme;
import org.tensorflow.lite.Interpreter;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
public class ModelLoader {
    private Interpreter interpreter;
    public ModelLoader(String modelPath) {
        try {
            interpreter = new Interpreter(loadModelFile(modelPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private MappedByteBuffer loadModelFile(String modelPath) throws IOException {
        FileInputStream inputStream = new FileInputStream(modelPath);
        FileChannel fileChannel = inputStream.getChannel();
        long startOffset = 0;
        long declaredLength = fileChannel.size();
        return fileChannel.map(FileChannel.MapMode.READ_ONLY, startOffset, declaredLength);
    }
    public void runModel(float[][] input) {
        if (interpreter != null) {
            int inputSize = input.length;
            float[] outputArray = new float[inputSize];
            for (int i = 0; i < inputSize; i++) {
                float[] currentInput = input[i];
                float[] currentOutput = new float[1]; // Tek bir çıktı değeri olduğunu varsayıyoruz
                interpreter.run(new float[][]{currentInput}, currentOutput);
                float output = currentOutput[0]; // Tek bir çıktı olduğunu varsayıyoruz
                System.out.println("Model output for input " + i + ": " + output);
            }
        } else {
            System.out.println("Interpreter is null. Model is not loaded or initialized properly.");
        }
    }
}
