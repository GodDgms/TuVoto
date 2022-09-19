package com.example.tuvoto;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContentInfo;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity {

    //Declaration of variables
    private EditText ETcedula;
    private Button Bentrar, Bresultado;
    private boolean NO = false;
    //Declaration of variables

    //Lista de cedulas del salon
    public static String[] cedulasregistradas = {"8-944-327", "3-740-1394", "20-53-4282", "8-943-1867", "8-937-503", "8-952-2444", "8-943-12", "8-986-549", "8-957-1827", "8-940-1311", "8-863-1620", "8-964-691",
            "8-954-1126", "8-1039-1537", "8-925-1168", "8-940-1505", "8-938-925", "3-743-2493", "E-8-169755", "8-971-1811", "8-940-408", "8-937-1640", "8-939-1578", "8-942-1406",
            "6-722-724", "8-941-1215", "8-962-1218", "8-941-924", "8-980-2414", "3-742-2055", "8-942-1192", "8-904-1189", "8-959-857", "8-964-1554", "8-1066-1018", "8-1055-701",
            "8-970-242", "3-752-1461", "3-745-950"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assign the Button's value to a variable
        Bresultado=findViewById(R.id.Bresultado);
        Bentrar=findViewById(R.id.Bentrar);
        ETcedula=findViewById(R.id.ETcedula);
        //Assign the Button's value to a variable

        //Se llena el arreglo con false
        //Indicando que nadie ha votado
        if(Control.Iniciando){
            Control.Iniciando = false;
            for (int i=0; i<=39;i++){
                Control.Votar[i] = false;
            }
            Control.vc1 = 0;
            Control.vc2 = 0;
            Control.vc3 = 0;
        }

        //Give a instruction to a Button
        Bentrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Recorre el arreglo
                for (int i=0; i<39;i++) {
                    //Verifica que la cedula ingresada exista en el arreglo
                    if (ETcedula.getText().toString().equals(cedulasregistradas[i])) {
                        NO=true;
                        //Verifica que no ha votado y lo envia a la siguiente pantalla
                        if(Control.Votar[i] == false) {
                            Control.Votar[i]= true;
                            Intent intent = new Intent(getApplicationContext(), Candidatos.class);
                            startActivity(intent);

                        //Indica que ya ha votado
                        } else{
                            Toast.makeText(MainActivity.this,"USTED HA VOTADO", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    }
                }
                //Detecta que la cedula no esta registrada
                if (NO==false){
                    Toast.makeText(MainActivity.this,"CéDULA NO REGISTRADA", Toast.LENGTH_SHORT).show();
                }
            }

        });
        //Give a instruction to a Button

        //Give a instruction to a Button
        Bresultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Resultado.class);
                startActivity(intent);
            }
        });
        //Give a instruction to a Button

    }

}