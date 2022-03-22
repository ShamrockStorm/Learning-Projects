package com.example.damfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    EditText tvUsername, tvEMail, tvPassword1, tvPassword2;
    Button bSignIn;
    StudentsDataBaseHelper myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        myDb = new StudentsDataBaseHelper(this);

        tvUsername = findViewById(R.id.username);
        tvEMail = findViewById(R.id.eMail);
        tvPassword1 = findViewById(R.id.password1);
        tvPassword2 = findViewById(R.id.password2);
        bSignIn = findViewById(R.id.signUp);

        bSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String pass1 = tvPassword1.getText().toString().trim();
                String pass2 = tvPassword2.getText().toString().trim();
                String eMail = tvEMail.getText().toString().trim();
                String username = tvUsername.getText().toString().trim();
                if(pass1.equals(pass2)){
                    if(!(eMail.equals("") || username.equals(""))){
                        boolean dataInserted = myDb.insertData(username,eMail,pass1);
                        if(dataInserted == true){
                            Toast.makeText(getBaseContext(), "Acount succesfully created!",
                                    Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(getBaseContext(), "Acount creation failed",
                                    Toast.LENGTH_SHORT).show();
                        }
                        finish();
                    }
                }
            }
        });
    }
}