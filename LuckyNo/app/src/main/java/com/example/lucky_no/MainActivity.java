package com.example.lucky_no;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText textView2;
    Button button1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        textView2 = findViewById(R.id.textView2);
        button1 = findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleSubmitButton();
            }
        });
    }

    private void handleSubmitButton() {
        String nameInput = textView2.getText().toString().trim();
        if (nameInput.isEmpty()) {
            textView2.setError("Please enter your name");
            return;
        }

        int luckyNumber = new Random().nextInt(100) + 1; // Generate a random lucky number (1-100)
        String phoneNumber = "9876543210"; // Replace with actual phone number logic if needed

        Intent intent = new Intent(MainActivity.this, secound_page.class);
        intent.putExtra("NAME_INPUT", nameInput);
        intent.putExtra("LUCKY_NUMBER", luckyNumber);
        intent.putExtra("NUMBER_INPUT", phoneNumber);
        startActivity(intent);
    }
}