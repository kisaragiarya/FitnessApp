package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class    Detail extends AppCompatActivity {

    private TextView tile, wod;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        tile = findViewById(R.id.title_lv);
        wod = findViewById(R.id.wod_lv);

        Bundle extra = getIntent().getExtras();
        if (extra != null){
            String t = extra.getString("EXTRA_TITLE");
            String w = extra.getString("EXTRA_WOD");

            tile.setText(t);
            wod.setText(w);
        }

    }
}
