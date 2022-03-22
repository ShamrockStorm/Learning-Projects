package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity3 extends AppCompatActivity {

    Button login;
    EditText user, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);
        login = (Button) findViewById(R.id.button);
        user = (EditText) findViewById(R.id.editText);
        password = (EditText) findViewById(R.id.editText2);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (user.getText().toString().equals("admin") &&
                        password.getText().toString().equals("admin")) {
                    Toast.makeText(getBaseContext(), "Login Successful !",
                            Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(SecondActivity3.this, ThirdActivity.class);
                    startActivity(i);
                } else
                    Toast.makeText(getBaseContext(), "Login Failed !",
                            Toast.LENGTH_SHORT).show();
            }
        });
    }
}