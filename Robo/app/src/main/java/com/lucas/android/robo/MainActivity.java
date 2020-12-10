package com.lucas.android.robo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText contar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Iniciar(View Botao){

        contar = (EditText) findViewById(R.id.etContagem);

        Intent objetoIntent = new Intent(MainActivity.this, SegundaActivity.class);
        objetoIntent.putExtra("cont",contar.getText().toString());
        startActivity(objetoIntent);

    }
}
