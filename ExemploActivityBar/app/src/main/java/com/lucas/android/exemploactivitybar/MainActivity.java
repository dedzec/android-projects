package com.lucas.android.exemploactivitybar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botaozinho = (Button) findViewById(R.id.botaozinho);
        botaozinho.setText("Label Botao");

    }

    public void clicouBotao(View botao){

        Intent objetoIntent = new Intent(MainActivity.this, SegundaTela.class);
        objetoIntent.putExtra("texto","Android Studio!!");
        startActivity(objetoIntent);
    }
}
