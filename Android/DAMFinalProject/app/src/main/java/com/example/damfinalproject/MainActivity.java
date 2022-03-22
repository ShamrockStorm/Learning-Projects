package com.example.damfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText etUserName, etPassword;
    Button bSignUp, bLogIn;
    StudentsDataBaseHelper myDb;
    int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUserName = findViewById(R.id.username);
        etPassword = findViewById(R.id.password);
        bSignUp = findViewById(R.id.signUp);
        bLogIn = findViewById(R.id.login);
        counter = 0;
        myDb = new StudentsDataBaseHelper(this);

        logIn();
        signUp();
    }

   public void logIn(){
       bLogIn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String eMail = etUserName.getText().toString().trim();
               String pass = etPassword.getText().toString().trim();
               String corectPass = myDb.getPasswordForEmail(eMail);
               if(counter == 3){
                   Toast.makeText(getBaseContext(), "Parola gresita de 3 ori. Va rugam sa iesiti din aplicatie.",
                           Toast.LENGTH_SHORT).show();
               }
               else {
                   if (pass.equals(corectPass)) {
                       Intent intent = new Intent(getApplicationContext(), MainMenuActivity.class);
                       startActivity(intent);
                   } else {
                       counter++;
                       Toast.makeText(getBaseContext(), "eMail-ul sau parola sunt gresite. Verificati-le si incercati din nou",
                               Toast.LENGTH_SHORT).show();
                   }
               }
           }
       });
   }

   public void signUp(){
        bSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(intent);
            }
        });
    }

}