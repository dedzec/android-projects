package com.lucas.android.exemploactivitybar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SegundaTela extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_tela);

        TextView texto = (TextView) findViewById(R.id.TextoSegundaTela);

        Intent objetoIntentNovo = getIntent();
        String nome = objetoIntentNovo.getStringExtra("texto");

        texto.setText(nome);
    }

}
