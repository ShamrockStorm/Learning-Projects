package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity2 extends AppCompatActivity {

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
            int i =1;
            boolean k = false;
            @Override
            public void onClick(View v) {
                if(i<=3) {
                    if (user.getText().toString().equals("admin") &&
                            password.getText().toString().equals("admin")) {
                        Toast.makeText(getBaseContext(), "Login Successful !",
                                Toast.LENGTH_SHORT).show();
                        k = true;
                    } else
                        Toast.makeText(getBaseContext(), "Login Failed !",
                                Toast.LENGTH_SHORT).show();
                    i++;
                }
                else if(k == false){
                    Toast.makeText(getBaseContext(), "Login failed 3 times, try again later!",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }
}