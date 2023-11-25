package com.hello;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView showCount;
    private int count = 0;
    private long fibN = 0; // Mengubah inisialisasi Fibonacci
    private long fibNMinus1 = 1;
    private EditText edit_max_fibonacci;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fibonancci);

        showCount = findViewById(R.id.show_count);
        edit_max_fibonacci = findViewById(R.id.edit_max_fibonacci);

        updateCountDisplay();
    }

    private void updateCountDisplay() {
        showCount.setText(String.valueOf(fibN));

        if (count % 4 == 0) {
            showCount.setTextColor(getResources().getColor(R.color.colorPrimary));
        } else if (count % 4 == 1) {
            showCount.setTextColor(getResources().getColor(R.color.colorAccent));
        } else if (count % 4 == 2) {
            showCount.setTextColor(getResources().getColor(R.color.colorPrimary));
        } else {
            showCount.setTextColor(getResources().getColor(R.color.colorAccent));
        }
    }

    public void showToast(View view) {
        Toast.makeText(this, "Bilangan Fibonacci",
                Toast.LENGTH_SHORT).show();
    }

    public void countUp(View view) {
        int maxFibonacci = Integer.parseInt(edit_max_fibonacci.getText().toString());

        if (count >= maxFibonacci) {
            Toast.makeText(this, "Maksimum Fibonacci tercapai", Toast.LENGTH_SHORT).show();
            return;
        }

        long fibCurrent;
        if (count == 0) {
            fibCurrent = 0; // Fibonacci pertama adalah 0
        } else if (count == 1) {
            fibCurrent = 1; // Fibonacci kedua adalah 1
        } else {
            fibCurrent = fibN + fibNMinus1;
        }

        fibNMinus1 = fibN;
        fibN = fibCurrent;
        updateCountDisplay();

        count++;
    }

    public void back1(View view) {
        count = 0;
        fibN = 0;
        fibNMinus1 = 1;
        updateCountDisplay();
    }
}
