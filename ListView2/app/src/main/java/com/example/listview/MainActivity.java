package com.example.listview;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.listview.Adapter.Call_Adapter;
import com.example.listview.ModelClassAdapter.callSetGet;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize ListView
        ListView listView = findViewById(R.id.listView);

        // Create an ArrayList of callSetGet objects
        ArrayList<callSetGet> callList = new ArrayList<>();
        callList.add(new callSetGet("boss ", "8208769710", "12 Calls"));
        callList.add(new callSetGet("Piyush S", "9673805390", "7 Calls"));
        callList.add(new callSetGet("Pratham P", "4564545645", "15 Calls"));
        callList.add(new callSetGet("Devika N", "7899456461", "5 Calls"));
        callList.add(new callSetGet("Harshal S", "457869564", "9 Calls"));
        callList.add(new callSetGet("Pankaj Y", "7856975947", "20 Calls"));
        callList.add(new callSetGet("rajesh ", "7856975947", "6 Calls"));
        callList.add(new callSetGet("Ankita s", "7856975947", "20 Calls"));
        callList.add(new callSetGet("vandana s", "7856975947", "21 Calls"));

        // Initialize adapter and set it to ListView
        Call_Adapter adapter = new Call_Adapter(this, callList);
        listView.setAdapter(adapter);
    }
}
