package com.example.listview;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listview.Adapter.FruitAdapter;
import com.example.listview.ModelClassAdapter.Fruitgetset;

import java.util.ArrayList;
import java.util.List;

public class fruits_list extends AppCompatActivity {
    private RecyclerView recyclerView;
    private FruitAdapter fruitAdapter;
    private List<Fruitgetset> fruitList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fruits_list);

        recyclerView = findViewById(R.id.fruitsListView);
        fruitList = new ArrayList<>();

        fruitList.add(new Fruitgetset("Apple", "A sweet, crunchy fruit rich in fiber and vitamin C.", R.drawable.apple));
        fruitList.add(new Fruitgetset("Banana", "A soft, energy-rich fruit high in potassium.", R.drawable.banana));
        fruitList.add(new Fruitgetset("Orange", "A juicy citrus fruit packed with vitamin C.", R.drawable.orange));
        fruitList.add(new Fruitgetset("Cherry", "A small, red fruit with a sweet and tart flavor.", R.drawable.cherry));
        fruitList.add(new Fruitgetset("Pomegranate", "A nutrient-rich fruit with juicy red seeds.", R.drawable.pomegranate));
        fruitList.add(new Fruitgetset("Strawberry", "A red, heart-shaped fruit loaded with antioxidants.", R.drawable.strawberry));
        fruitList.add(new Fruitgetset("Pineapple", "A tropical fruit with a tangy and sweet taste.", R.drawable.pineapple));
        fruitList.add(new Fruitgetset("Pear", "A juicy fruit with a soft, buttery texture.", R.drawable.pear));
        fruitList.add(new Fruitgetset("Guava", "A green fruit with pink flesh, rich in vitamin C.", R.drawable.guava));
        fruitList.add(new Fruitgetset("Mango", "A tropical delight known as the king of fruits.", R.drawable.mango));
        fruitList.add(new Fruitgetset("Grapes", "Small, sweet berries used in making wine.", R.drawable.grapes));
        fruitList.add(new Fruitgetset("Dragon fruit", "An exotic fruit with a unique look and taste.", R.drawable.dragonfruit));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        fruitAdapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(fruitAdapter);
    }
}
