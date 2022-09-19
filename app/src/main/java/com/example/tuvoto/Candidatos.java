package com.example.tuvoto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class Candidatos extends AppCompatActivity {

    //Declaration of variables
    private RadioButton RBcandidato1,RBcandidato2,RBcandidato3;
    private Button Bvotar;
    //Declaration of variables

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidatos);

        //Assign the Button's value to a variable
        RBcandidato1=findViewById(R.id.RBcandidato1);
        RBcandidato2=findViewById(R.id.RBcandidato2);
        RBcandidato3=findViewById(R.id.RBcandidato3);
        Bvotar=findViewById(R.id.Bvotar);
        //Assign the Button's value to a variable

        //Give a instruction to a Button
        Bvotar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (RBcandidato1.isChecked()==true){
                    Control.vc1 = +1;
                }
                if (RBcandidato2.isChecked()==true){
                    Control.vc2 = +1;
                }
                if (RBcandidato3.isChecked()==true){
                    Control.vc3 = +1;
                }
                Intent intent = new Intent(getApplicationContext(), Resultado.class);
                startActivity(intent);
            }
        });
        //Give a instruction to a Button

    }
}