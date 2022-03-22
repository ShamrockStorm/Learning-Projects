package com.example.damfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

public class CompareProfilesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare_profiles);
        GridView gv = (GridView) findViewById(R.id.gridview);
        gv.setAdapter(new com.example.damfinalproject.TextAdapter(this));
    }
}