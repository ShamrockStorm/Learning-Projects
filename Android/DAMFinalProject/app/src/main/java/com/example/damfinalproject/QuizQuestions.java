package com.example.damfinalproject;

public class QuizQuestions {
    public String vectIntreb[]={
            "De la ce vine prescurtarea P.O.O.",
            "Numărul de noduri ale unui arbore cu 4 muchii este:",
            "Valorile care pot reprezenta gradele nodurilor unui graf neorientat, cu 6 noduri, sunt:"
    };
    public String vectRasp[][]={
            {"Programare Orientata pe Obiecte","Programare Orientata pe Obiect","Pragram cu Origine Orientata","Programare cu origine Orientata"},
            {"2","3","4","5"},
            {"1,0,0,2,2,2","2,2,3,4,0,3","2,2,5,5,0,1","6,5,4,3,2,1"}
    };
    public String raspCorecte[]={"Programare Orientata pe Obiecte",
            "5",
            "2,2,3,4,0,3"
    };

    public String getIntrebare(int i){
        return vectIntreb[i];
    }
    public String getRaspA(int i){
        return vectRasp[i][0];
    }
    public String getRaspB(int i){
        return vectRasp[i][1];
    }
    public String getRaspC(int i){
        return vectRasp[i][2];
    }
    public String getRaspD(int i){
        return vectRasp[i][3];
    }
    public String getRaspCorect(int i){
        return raspCorecte[i];
    }
}
