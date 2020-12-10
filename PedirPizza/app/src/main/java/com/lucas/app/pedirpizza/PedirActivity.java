package com.lucas.app.pedirpizza;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class PedirActivity extends AppCompatActivity {
    EditText edpizza;
    CheckBox chkborda, chkqueijo, chkrefri;
    Button btfinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedir);

        edpizza = (EditText) findViewById(R.id.edpizza);
        chkborda = (CheckBox) findViewById(R.id.chkborda);
        chkqueijo = (CheckBox) findViewById(R.id.chkqueijo);
        chkrefri = (CheckBox) findViewById(R.id.chkrefri);
        btfinalizar = (Button) findViewById(R.id.btfinalizar);

        btfinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pizza = edpizza.getText().toString();
                String borda = chkborda.getText().toString();
                String queijo = chkqueijo.getText().toString();
                String refri = chkrefri.getText().toString();
                String compra = pizza;
                if (chkborda.isChecked()) {
                    compra += ", " + borda;
                }
                if (chkqueijo.isChecked()) {
                    compra += ", " + queijo;
                }
                if (chkrefri.isChecked()) {
                    compra += ", " + refri;
                }
                AlertDialog.Builder dialogo = new AlertDialog.Builder(PedirActivity.this);
                dialogo.setMessage("Pedigo: " + compra);
                dialogo.setNeutralButton("Ok", null);
                dialogo.show();
            }
        });
    }
}
