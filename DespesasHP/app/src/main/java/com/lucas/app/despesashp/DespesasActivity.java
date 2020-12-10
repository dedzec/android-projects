package com.lucas.app.despesashp;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DespesasActivity extends AppCompatActivity {
    EditText iddias,idquarto,idtf,idtv;
    Button btcalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_despesas);

        iddias = (EditText) findViewById(R.id.iddias);
        idquarto = (EditText) findViewById(R.id.idquarto);
        idtf = (EditText) findViewById(R.id.idtf);
        idtv = (EditText) findViewById(R.id.idtv);
        btcalcular = (Button) findViewById(R.id.btcalcular);

        btcalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double dias = Double.parseDouble(iddias.getText().toString());
                String quarto = idquarto.getText().toString();
                String tf = idtf.getText().toString();
                String tv = idtv.getText().toString();
                String tipoquarto = "";
                double total=0,desconto=0,telefone=0;
                double televisao=0,diarias=0,valorpago=0;

                if (tf.equals("s") || tf.equals("S")) {
                    telefone = 1.75;
                }
                if (tv.equals("s") || tv.equals("S")) {
                    televisao = 3.5;
                }
                total += telefone + televisao;
                if (quarto.equals("p") || quarto.equals("P")) {
                    tipoquarto = "PARTICULAR";
                    diarias = dias * 125;
                    total += diarias;
                    if (diarias>1000){
                        desconto = diarias * 0.15;
                        valorpago -= desconto;
                    }
                }
                if (quarto.equals("c") || quarto.equals("C")) {
                    tipoquarto = "CONJUNTO";
                    diarias = dias * 95;
                    total += diarias;
                    if (diarias>500){
                        desconto = diarias * 0.10;
                        valorpago -= desconto;
                    }
                }
                if (quarto.equals("e") || quarto.equals("E")) {
                    tipoquarto = "ENFERMEIRA";
                    diarias = dias * 75;
                    total += diarias;
                    if (diarias<500){
                        desconto = diarias * 0.05;
                        valorpago -= desconto;
                    }
                }
                valorpago += total;

                AlertDialog.Builder dialogo = new AlertDialog.Builder(DespesasActivity.this);
                dialogo.setNeutralButton("Ok", null);
                dialogo.setMessage("Diárias: " + dias + "\nTipo quarto: " + tipoquarto +
                        "\nDiárias: R$ " + diarias + "\nTelefone: R$ " + telefone + "\nTelevisão: R$ " + televisao +
                        "\nTotal: R$ " + total + "\nDesconto: R$ " + desconto + "\nValor Pago: R$ " + valorpago);
                dialogo.show();
            }
        });
    }
}
