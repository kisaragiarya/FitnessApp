package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class kakikakikaki extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView lv;
    private ArrayList<Workout> wodList;
    private  ArrayList<String> titleList;
    private Adapter adapterr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kakikakikaki);
        wodList = DataHelper.loadWorkout( this);
        lv = findViewById(R.id.lv);
        titleList = new ArrayList<>();
        for (int i=0;  i<wodList.size(); i++){
            String str = wodList.get(i).getTitle();
            titleList.add(str);
        }
        adapterr = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, titleList);
        lv.setAdapter((ListAdapter) adapterr);

        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, Detail.class);
        String title = wodList.get(position).getTitle();
        String wod = wodList.get(position).getWod();

        intent.putExtra("EXTRA_TITLE", title);
        intent.putExtra("EXTRA_WOD", wod);

        startActivity(intent);
    }
}
