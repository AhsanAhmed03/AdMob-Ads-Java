package com.example.google.admob.java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item("Item 1"));
        itemList.add(new Item("Item 2"));
        itemList.add(new Item("Item 3"));
        itemList.add(new Item("Item 4"));
        itemList.add(new Item("Item 5"));
        itemList.add(new Item("Item 6"));
        itemList.add(new Item("Item 7"));
        itemList.add(new Item("Item 8"));

        RecyclerAdapter adapter = new RecyclerAdapter(itemList, RecyclerViewActivity.this);
        recyclerView.setAdapter(adapter);
    }
}