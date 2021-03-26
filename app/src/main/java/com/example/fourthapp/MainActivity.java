package com.example.fourthapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.String.*;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText editText;
    ProgressBar progressBar;
    Button sendButton;
    Button minusButton;
    Button plusButton;
    TextView textViewProgress;

    private int progress = 0;

    private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        textViewProgress = findViewById(R.id.textViewProgress);
        progressBar = findViewById(R.id.progressBar);
        editText = findViewById(R.id.editTextMessage);
        sendButton = findViewById(R.id.sendButton);
        minusButton = findViewById(R.id.minusButton);
        plusButton = findViewById(R.id.plusButton);

        Log.d(TAG, "onCreate was called");

        updateProgressBar();

        sendButton.setOnClickListener(view -> login(textView));
        minusButton.setOnClickListener(view -> decrement(progressBar));
        plusButton.setOnClickListener(view -> increment(progressBar));
    }

    public void login(View view){
        Context context = getApplicationContext();
        String text = "Sending message...";

        int duration = Toast.LENGTH_SHORT;
        Toast.makeText(context, text, duration).show();

        Editable message = editText.getText();
        textView.setText(message);
    }

    public void increment(View view){
        try{
            if(progress <= 90){
                progress += 10;
                updateProgressBar();
            }
        } catch (Exception e){
            Log.w("incr", e.getMessage());
        }
    }

    public void decrement(View view){
        try {
            if (progress >= 10) {
                progress -= 10;
                updateProgressBar();
            }
        } catch (Exception e){
            Log.w("decr", e.getMessage());
        }
    }

    @SuppressLint("DefaultLocale")
    private void updateProgressBar(){
        progressBar.setProgress(progress);
        textViewProgress.setText(format("%d%s", progress, "%"));
    }
}