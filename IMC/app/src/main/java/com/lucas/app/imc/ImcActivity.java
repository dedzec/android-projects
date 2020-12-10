package com.lucas.app.imc;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ImcActivity extends AppCompatActivity {
    EditText edaltura, edpeso;
    Button btimc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);

        edaltura = (EditText) findViewById(R.id.edaltura);
        edpeso = (EditText) findViewById(R.id.edpeso);
        btimc = (Button) findViewById(R.id.btimc);

        btimc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double altura = Double.parseDouble(edaltura.getText().toString());
                double peso = Double.parseDouble(edpeso.getText().toString());
                double imc = 0;
                String classif = "";

                imc = peso / (altura * altura);

                if (imc < 18.5) {
                    classif = "Baixo Peso";
                }
                if (imc >= 18.5 && imc < 24.9) {
                    classif = "Peso Normal";
                }
                if (imc > 24.9) {
                    classif = "Sobrepesso";
                }
                if (imc > 25 && imc <= 29.9) {
                    classif = "Pré-Obeso";
                }
                if (imc > 29.9 && imc <= 34.9) {
                    classif = "Obeso I";
                }
                if (imc > 34.9 && imc <= 39.9) {
                    classif = "Obeso II";
                }
                if (imc >= 40) {
                    classif = "Obeso III";
                }

                AlertDialog.Builder dialogo = new AlertDialog.Builder(ImcActivity.this);
                dialogo.setNeutralButton("Ok", null);
                dialogo.setMessage("IMC: " + imc + "\n" + classif);
                dialogo.show();
            }
        });
    }
}
