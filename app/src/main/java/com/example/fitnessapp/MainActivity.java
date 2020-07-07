package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText user, pwd ;
    Button btnLoginAdmin;
    private ArrayList<Workout> wodList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLoginAdmin = findViewById(R.id.button);
        user = findViewById(R.id.textView3);
        pwd = findViewById(R.id.textView6);

        btnLoginAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String UserName = "ADMIN";
                String Pwd = "ADMIN";

                String userInsert = user.getText().toString().trim() ;
                String pwdInsert = pwd.getText().toString().trim();

                if(userInsert.isEmpty() || pwdInsert.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Username & Pasword Must Be Inserted", Toast.LENGTH_SHORT).show();

                }
                else if (!userInsert.toUpperCase().equals(UserName) || !pwdInsert.toUpperCase().equals(Pwd) )
                {

                    Toast.makeText(MainActivity.this, "Usernmae / Pasword Wrong, Pls Try Again", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Login Successfull , Welcome Admin", Toast.LENGTH_SHORT).show();
                    intentToDashboard();

                }
            }
        });


    }


    public void intentToDashboard()
    {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    public void intentToDashboardAdmin(View view)
    {
        String UserName = "ADMIN";
        String Pwd = "ADMIN";

        String userInsert = user.getText().toString().trim() ;
        String pwdInsert = pwd.getText().toString().trim();

        if(userInsert.isEmpty() || pwdInsert.isEmpty())
        {
            Toast.makeText(MainActivity.this, "Username & Pasword Must Be Inserted", Toast.LENGTH_SHORT).show();

        }
        else if (!userInsert.toUpperCase().equals(UserName) || !pwdInsert.toUpperCase().equals(Pwd) )
        {

            Toast.makeText(MainActivity.this, "Usernmae / Pasword Wrong, Pls Try Again", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(MainActivity.this, "Login Successfull , Welcome Admin", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, Home.class);

            startActivity(intent);

        }



    }
}
