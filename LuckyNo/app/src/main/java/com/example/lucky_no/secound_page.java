package com.example.lucky_no;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class secound_page extends AppCompatActivity {

    TextView nameOutput;
    TextView luckNumberOutput;
    TextView numberOutput;
    Button shareButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_secound_page);

        // Initializing views
        nameOutput = findViewById(R.id.textView);
        luckNumberOutput = findViewById(R.id.text5);
//        numberOutput = findViewById(R.id.text);
        shareButton = findViewById(R.id.button2);

        // Receiving data from intent
        String name = getIntent().getStringExtra("NAME_INPUT");
        int luckyNumber = getIntent().getIntExtra("LUCKY_NUMBER", 0);
        String number = getIntent().getStringExtra("NUMBER_INPUT");

        // Setting the received data
        if (name != null && !name.isEmpty()) {
            nameOutput.setText(name);
        } else {
            nameOutput.setText("No Name Provided");
        }

        luckNumberOutput.setText("Lucky No is: " + luckyNumber);


        // Share button functionality
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareLuckyNumber(name, luckyNumber );
            }
        });
    }

    private void shareLuckyNumber(String name, int luckyNumber) {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        String shareMessage = "Congratulation! " + name + "\nYour Lucky Number is: " + luckyNumber ;
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
        startActivity(Intent.createChooser(shareIntent, "Share via"));
    }
}
