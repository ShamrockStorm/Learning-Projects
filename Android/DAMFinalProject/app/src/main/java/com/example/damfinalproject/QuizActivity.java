package com.example.damfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
    RadioGroup AnswerGroup;
    RadioButton rbA, rbB, rbC, rbD;
    //Button raspA,raspB,raspC,raspD;
    Button bSubmit;
    TextView tvScor,tvIntrebare;
    private QuizQuestions vectIntrebari=new QuizQuestions();
    private String rasp;
    private int scor=0;
    private int index = 0;
    private int nrIntrebari=vectIntrebari.vectIntreb.length;
    static int nrOfQuestions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        AnswerGroup = findViewById(R.id.rgAnswers);
        rbA=findViewById(R.id.rbAnswerA);
        rbB=findViewById(R.id.rbAnswerB);
        rbC=findViewById(R.id.rbAnswerC);
        rbD=findViewById(R.id.rbAnswerD);
        bSubmit = findViewById(R.id.bSubmit);
        tvIntrebare=findViewById(R.id.tvIntrebareIst);
        tvScor=findViewById(R.id.tvScorIst);
        actIntrebare(0);
        bSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RadioButton Checked = findViewById(AnswerGroup.getCheckedRadioButtonId());

                if(Checked != null) {
                    if (Checked.getText() == rasp) {
                        scor++;
                        tvScor.setText("Scor: " + scor);
                    }
                    index++;
                    if (index < nrIntrebari) actIntrebare(index);
                    else {
                        Toast.makeText(getBaseContext(), "Scorul tau final este : " + scor,
                                Toast.LENGTH_SHORT).show();
                        Intent intent =new Intent(getApplicationContext(),QuizEmailActivity.class);
                        intent.putExtra("scor", scor);
                        startActivity(intent);
                    }
                    Checked.setChecked(false);
                }
            }
        });
    }
    private void actIntrebare(int i){
        tvIntrebare.setText(vectIntrebari.getIntrebare(i));
        rbA.setText(vectIntrebari.getRaspA(i));
        rbB.setText(vectIntrebari.getRaspB(i));
        rbC.setText(vectIntrebari.getRaspC(i));
        rbD.setText(vectIntrebari.getRaspD(i));
        rasp=vectIntrebari.getRaspCorect(i);
    }
}