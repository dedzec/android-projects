package com.lucas.android.dadosactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Segundactivity extends AppCompatActivity {

    private TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundactivity);

        texto = (TextView) findViewById(R.id.textoId);

        // Recupera as informações da primaira activity
        Bundle extra = getIntent().getExtras();

        // Garantir que tenha informações no extra
        if ( extra != null ) {
            String textoPassado = extra.getString("nome");
            texto.setText(textoPassado);
        }
    }
}
