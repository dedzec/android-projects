package com.lucas.app.maiorvalor;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MaiorActivity extends AppCompatActivity {
    EditText id1,id2;
    Button btcalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maior);

        id1 = (EditText) findViewById(R.id.id1);
        id2 = (EditText) findViewById(R.id.id2);
        btcalcular = (Button) findViewById(R.id.btcalcular);

        btcalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double valor1 = Double.parseDouble(id1.getText().toString());
                double valor2 = Double.parseDouble(id2.getText().toString());
                double maior=0;

                if(valor2<valor1){
                    maior = valor1;
                }
                else {
                    maior = valor2;
                }

                AlertDialog.Builder dialogo = new AlertDialog.Builder(MaiorActivity.this);
                dialogo.setNeutralButton("OK" , null);
                dialogo.setMessage("Maior valor: " + maior);
                dialogo.show();

            }
        });
    }
}
