package com.example.tuvoto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {

    //Declaration of variables
    private TextView TVcandidato1, TVcandidato2, TVcandidato3, TVganador;
    private Button Bprincipal;
    //Declaration of variables

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        //Assign the Button's value to a variable
        TVcandidato1=findViewById(R.id.TVcandidato1);
        TVcandidato2=findViewById(R.id.TVcandidato2);
        TVcandidato3=findViewById(R.id.TVcandidato3);
        TVganador=findViewById(R.id.TVganador);
        Bprincipal=findViewById(R.id.Bprincipal);
        //Assign the Button's value to a variable

        TVcandidato1.setText("Martin Candanedo tiene: " + Control.vc1);
        TVcandidato2.setText("Omar Aizpurua tiene: " + Control.vc2);
        TVcandidato3.setText("Vivian Valenzuela tiene: " + Control.vc3);
        if (Control.vc1 > 0 || Control.vc2 > 0 || Control.vc3 > 0) {
            if (Control.vc1 > Control.vc2 && Control.vc1 > Control.vc3) {
                TVganador.setText("El ganador es Martin Candanedo");
            } else if (Control.vc2 > Control.vc1 && Control.vc2 > Control.vc3) {
                TVganador.setText("El ganador es Omar Aizpurua");
            } else if (Control.vc3 > Control.vc1 && Control.vc3 > Control.vc2) {
                TVganador.setText("El ganador es Vivian Valenzuela");
            } else if (Control.vc3 == Control.vc1) {
                TVganador.setText("Los ganadores son Vivian Valenzuela y Martin Candanedo");
            } else if (Control.vc1 == Control.vc2) {
                TVganador.setText("Los ganadores son Martin Candanedo y Omar Aizpurua");
            } else if (Control.vc2 == Control.vc3) {
                TVganador.setText("Los ganadores son Omar Aizpurua y Vivian Valenzuela");
            //NO SIRVE EL HRMP
            } else {
                TVganador.setText("Triple empate");
            }
        }
        else {
            TVganador.setText("Aun no hay suficientes votos");
        }

        //Give a instruction to a Button
        Bprincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

            }
        });
        //Give a instruction to a Button

    }
}