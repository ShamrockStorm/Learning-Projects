package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button bExample;
    Button bEx1;
    Button bEx2;
    Button bEx3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setButton();
    }
    public void setButton() {
        bExample = (Button) findViewById(R.id.bExample);
        bExample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(i);
            }
        });

        bEx1 = (Button) findViewById(R.id.bEx1);
        bEx1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SecondActivity2.class);
                startActivity(i);
            }
        });

        bEx2 = (Button) findViewById(R.id.bEx2);
        bEx2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SecondActivity3.class);
                startActivity(i);
            }
        });

        bEx3 = (Button) findViewById(R.id.bEx3);
        bEx3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SecondActivity4.class);
                startActivity(i);
            }
        });

    }
}