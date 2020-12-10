package com.lucas.app.notas;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NotasActivity extends AppCompatActivity {
    EditText id1,id2,id3,id4;
    Button btcalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas);

        id1 = (EditText) findViewById(R.id.id1);
        id2 = (EditText) findViewById(R.id.id2);
        id3 = (EditText) findViewById(R.id.id3);
        id4 = (EditText) findViewById(R.id.id4);
        btcalcular = (Button) findViewById(R.id.btcalcular);

        btcalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double nota1 = Double.parseDouble(id1.getText().toString());
                double nota2 = Double.parseDouble(id2.getText().toString());
                double nota3 = Double.parseDouble(id3.getText().toString());
                double nota4 = Double.parseDouble(id4.getText().toString());
                String mensagem="";
                double media=0;

                media = (nota1 + nota2 + nota3 + nota4)/4;
                if(media>=7){
                    mensagem = "Aprovado";
                }
                else {
                    mensagem = "Reprovado";
                }

                AlertDialog.Builder dialogo = new AlertDialog.Builder(NotasActivity.this);
                dialogo.setNeutralButton("OK" , null);
                dialogo.setMessage("Media: " + media + "\n" + mensagem);
                dialogo.show();
            }
        });
    }
}
