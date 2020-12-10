package com.lucas.app.conta;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ContaActivity extends AppCompatActivity {
    EditText edConta, edCouvert, edTaxa, edPessoas;
    Button btCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conta);

        edConta = (EditText) findViewById(R.id.edConta);
        edCouvert = (EditText) findViewById(R.id.edCouvert);
        edTaxa = (EditText) findViewById(R.id.edTaxa);
        edPessoas = (EditText) findViewById(R.id.edPessoas);
        btCalcular = (Button) findViewById(R.id.btCalcular);

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double conta = Double.parseDouble(edConta.getText().toString());
                double couvert = Double.parseDouble(edCouvert.getText().toString());
                double taxa = Double.parseDouble(edTaxa.getText().toString());
                double pessoas = Double.parseDouble(edPessoas.getText().toString());
                double total = 0;
                double porpessoa = 0;

                total = (conta+couvert) + (conta+couvert)*(taxa/100);
                porpessoa = total/pessoas;

                AlertDialog.Builder dialogo = new AlertDialog.Builder(ContaActivity.this);
                dialogo.setNeutralButton("Ok", null);
                dialogo.setMessage("Valor da Conta: R$" + total + "\nConta por Pessoa: R$" + porpessoa);
                dialogo.show();
            }
        });
    }
}
