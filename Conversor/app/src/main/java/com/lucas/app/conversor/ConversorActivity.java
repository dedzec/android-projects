package com.lucas.app.conversor;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ConversorActivity extends AppCompatActivity {
    EditText edreal, edcotacao;
    Button btcalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversor);

        edreal = (EditText) findViewById(R.id.edreal);
        edcotacao = (EditText) findViewById(R.id.edcotacao);
        btcalcular = (Button) findViewById(R.id.btcalcular);

        btcalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double real = Double.parseDouble(edreal.getText().toString());
                double conversor = Double.parseDouble(edcotacao.getText().toString());
                double dolar = 0;

                dolar = real / conversor;

                AlertDialog.Builder dialogo = new AlertDialog.Builder(ConversorActivity.this);
                dialogo.setNeutralButton("Ok", null);
                dialogo.setMessage("Valor: $ " + dolar);
                dialogo.show();
            }
        });
    }
}
