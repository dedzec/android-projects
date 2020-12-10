package com.lucas.app.calculadora;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CalculadoraActivity extends AppCompatActivity {
    EditText ednumero1;
    EditText ednumero2;
    Button btsomar;
    Button btsubtrair;
    Button btmultiplicar;
    Button btdividir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        ednumero1 = (EditText) findViewById(R.id.ednumero1);
        ednumero2 = (EditText) findViewById(R.id.ednumero2);
        btsomar = (Button) findViewById( R.id.btsomar);
        btsubtrair = (Button) findViewById(R.id.btsubtrair);
        btmultiplicar = (Button) findViewById(R.id.btmultiplicar);
        btdividir = (Button) findViewById(R.id.btdividir);

        btsomar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float numero1 = Float.parseFloat(ednumero1.getText().toString());
                float numero2 = Float.parseFloat(ednumero2.getText().toString());
                float soma = numero1 + numero2;
                AlertDialog.Builder dialogo = new AlertDialog.Builder(CalculadoraActivity.this);
                dialogo.setMessage("A soma é : " + soma);
                dialogo.setNeutralButton("OK", null);
                dialogo.show();

            }
        });

        btsubtrair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float numero1 = Float.parseFloat(ednumero1.getText().toString());
                float numero2 = Float.parseFloat(ednumero2.getText().toString());
                float subtrair = numero1 - numero2;
                AlertDialog.Builder dialogo = new AlertDialog.Builder(CalculadoraActivity.this);
                dialogo.setMessage("A subtração é : " + subtrair);
                dialogo.setNeutralButton("OK", null);
                dialogo.show();

            }
        });

        btmultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float numero1 = Float.parseFloat(ednumero1.getText().toString());
                float numero2 = Float.parseFloat(ednumero2.getText().toString());
                float multiplicar = numero1 * numero2;
                AlertDialog.Builder dialogo = new AlertDialog.Builder(CalculadoraActivity.this);
                dialogo.setMessage("A multiplicação é : " + multiplicar);
                dialogo.setNeutralButton("OK", null);
                dialogo.show();

            }
        });

        btdividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float numero1 = Float.parseFloat(ednumero1.getText().toString());
                float numero2 = Float.parseFloat(ednumero2.getText().toString());
                float dividir = numero1 / numero2;
                AlertDialog.Builder dialogo = new AlertDialog.Builder(CalculadoraActivity.this);
                dialogo.setMessage("A divisão é : " + dividir);
                dialogo.setNeutralButton("OK", null);
                dialogo.show();

            }
        });
    }
}
