package com.lucas.app.periodoletivo;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PeriodoActivity extends AppCompatActivity {
    EditText idfreguencia, idaula,id1,id2,id3,id4;
    Button btcalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_periodo);

        id1 = (EditText) findViewById(R.id.id1);
        id2 = (EditText) findViewById(R.id.id2);
        id3 = (EditText) findViewById(R.id.id3);
        id4 = (EditText) findViewById(R.id.id4);
        idfreguencia = (EditText) findViewById(R.id.idfreguencia);
        idaula = (EditText) findViewById(R.id.idaulas);
        btcalcular = (Button) findViewById(R.id.btcalcular);

        btcalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double nota1 = Double.parseDouble(id1.getText().toString());
                double nota2 = Double.parseDouble(id2.getText().toString());
                double nota3 = Double.parseDouble(id3.getText().toString());
                double nota4 = Double.parseDouble(id4.getText().toString());
                double presenca = Double.parseDouble(idfreguencia.getText().toString());
                double aulas = Double.parseDouble(idaula.getText().toString());
                String mensagem="";
                double media=0,freguencia=0;

                media = (nota1 + nota2 + ((nota3*2) + (nota4*2)))/6;
                freguencia = (presenca/aulas)*100;
                if(media>=7){
                    mensagem = "Aprovado";
                }
                if(media<7 && media>=2.5) {
                    mensagem = "Exame Final";
                }
                if(media<2.5) {
                    mensagem= "Reprovado por nota";
                }
                if(freguencia<75) {
                    mensagem = "Reprovado por falta";
                }
                if(media<2.5 && freguencia<75) {
                    mensagem = "Reprovado por nota e por falta";
                }

                AlertDialog.Builder dialogo = new AlertDialog.Builder(PeriodoActivity.this);
                dialogo.setNeutralButton("OK" , null);
                dialogo.setMessage("Media: " + media + "\n" + mensagem);
                dialogo.show();
            }
        });
    }
}
