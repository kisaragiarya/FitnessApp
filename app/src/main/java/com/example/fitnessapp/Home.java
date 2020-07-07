package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {
    Button tangan, kaki, bawah, tubuh, alarm, logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tangan = findViewById(R.id.latihanTangan);
        kaki = findViewById(R.id.latihanKaki);
        bawah = findViewById(R.id.latihanBawah);
        tubuh = findViewById(R.id.latihanSeluruh);
        alarm = findViewById(R.id.alarm);
        logout = findViewById(R.id.button3);


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchActivity5();
            }
        });

        kaki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchActivity();
            }
        });

        tangan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchActivity1();
            }
        });

        bawah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchActivity3();
            }
        });

        tubuh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchActivity4();
            }
        });


        alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            launchActivity2();
            }
        });
    }
    private void launchActivity() {

        Intent intent = new Intent(this, kakikakikaki.class);
        startActivity(intent);
    }
    private void launchActivity1() {

        Intent intent = new Intent(this, tangantangan.class);
        startActivity(intent);
    }
    private void launchActivity2() {

        Intent intent = new Intent(this, Alarm.class);
        startActivity(intent);
    }
    private void launchActivity3() {

        Intent intent = new Intent(this, bawahbawah.class);
        startActivity(intent);
    }
    private void launchActivity4() {

        Intent intent = new Intent(this, tubuhtubuh.class);
        startActivity(intent);
    }

    private void launchActivity5() {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
