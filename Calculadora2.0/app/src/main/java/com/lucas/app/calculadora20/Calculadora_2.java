package com.lucas.app.calculadora20;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Calculadora_2 extends AppCompatActivity {
    Button bt0,bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9;
    Button btsomar,btsubtrair,btmultiplicar,btdividir;
    Button btlimpar,btraiz,btpercentual,btdeletar,btresultado,btvirgula;
    TextView tvcaixa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_2);

        bt0 = (Button) findViewById(R.id.bt0);
        bt1 = (Button) findViewById(R.id.bt1);
        bt2 = (Button) findViewById(R.id.bt2);
        bt3 = (Button) findViewById(R.id.bt3);
        bt4 = (Button) findViewById(R.id.bt4);
        bt5 = (Button) findViewById(R.id.bt5);
        bt6 = (Button) findViewById(R.id.bt6);
        bt7 = (Button) findViewById(R.id.bt7);
        bt8 = (Button) findViewById(R.id.bt8);
        bt9 = (Button) findViewById(R.id.bt9);
        btsomar = (Button) findViewById( R.id.btsomar);
        btsubtrair = (Button) findViewById(R.id.btsubtrair);
        btmultiplicar = (Button) findViewById(R.id.btmultiplicar);
        btdividir = (Button) findViewById(R.id.btdividir);
        btvirgula = (Button) findViewById(R.id.btvirgula);
        btresultado = (Button) findViewById(R.id.btresultado);
        btlimpar = (Button) findViewById(R.id.btlimpar);
        btraiz = (Button) findViewById(R.id.btraiz);
        btpercentual = (Button) findViewById(R.id.btpercentual);
        btdeletar = (Button) findViewById(R.id.btdeletar);
        tvcaixa = (TextView) findViewById(R.id.tvcaixa);

        bt0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView numero = (TextView) tvcaixa.getText();
                int valor = '0';
                String texto = numero+""+valor;
                tvcaixa.setText(texto);
            }
        });

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView numero = (TextView) tvcaixa.getText();
                int valor = '1';
                String texto = numero+""+valor;
                tvcaixa.setText(texto);
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView numero = (TextView) tvcaixa.getText();
                int valor = '2';
                String texto = numero+""+valor;
                tvcaixa.setText(texto);
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView numero = (TextView) tvcaixa.getText();
                int valor = '3';
                String texto = numero+""+valor;
                tvcaixa.setText(texto);
            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView numero = (TextView) tvcaixa.getText();
                int valor = '4';
                String texto = numero+""+valor;
                tvcaixa.setText(texto);
            }
        });

        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView numero = (TextView) tvcaixa.getText();
                int valor = '5';
                String texto = numero+""+valor;
                tvcaixa.setText(texto);
            }
        });

        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView numero = (TextView) tvcaixa.getText();
                int valor = '6';
                String texto = numero+""+valor;
                tvcaixa.setText(texto);
            }
        });

        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView numero = (TextView) tvcaixa.getText();
                int valor = '7';
                String texto = numero+""+valor;
                tvcaixa.setText(texto);
            }
        });

        bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView numero = (TextView) tvcaixa.getText();
                int valor = '8';
                String texto = numero+""+valor;
                tvcaixa.setText(texto);
            }
        });

        bt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView numero = (TextView) tvcaixa.getText();
                int valor = '9';
                String texto = numero+""+valor;
                tvcaixa.setText(texto);
            }
        });

        btsomar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView numero = (TextView) tvcaixa.getText();
                int valor = '+';
                String texto = numero+""+valor;
                tvcaixa.setText(texto);
            }
        });

        btsubtrair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView numero = (TextView) tvcaixa.getText();
                int valor = '-';
                String texto = numero+""+valor;
                tvcaixa.setText(texto);
            }
        });

        btmultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView numero = (TextView) tvcaixa.getText();
                int valor = 'x';
                String texto = numero+""+valor;
                tvcaixa.setText(texto);
            }
        });

        btdividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView numero = (TextView) tvcaixa.getText();
                int valor = '/';
                String texto = numero+""+valor;
                tvcaixa.setText(texto);
            }
        });

        btvirgula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView numero = (TextView) tvcaixa.getText();
                int valor = ',';
                String texto = numero+""+valor;
                tvcaixa.setText(texto);
            }
        });

        btresultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView numero = (TextView) tvcaixa.getText();
                String texto = ""+numero;
                tvcaixa.setText(texto);
            }
        });
    }
}
