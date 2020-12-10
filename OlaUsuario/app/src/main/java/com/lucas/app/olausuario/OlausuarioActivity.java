package com.lucas.app.olausuario;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class OlausuarioActivity extends AppCompatActivity {
    EditText edtext;
    Button bttext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_olausuario);

        edtext = (EditText) findViewById(R.id.edtext);
        bttext = (Button) findViewById(R.id.bttext);

        bttext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = edtext.getText().toString();

                AlertDialog.Builder dialogo = new AlertDialog.Builder(OlausuarioActivity.this);
                dialogo.setNeutralButton("ok", null);
                dialogo.setMessage("Olá " + nome);
                dialogo.show();
            }
        });
    }
}
