package com.lucas.app.segundos;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SegundosActivity extends AppCompatActivity {
    EditText edhora, edminuto;
    Button btcalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundos);

        edhora = (EditText) findViewById(R.id.edhora);
        edminuto = (EditText) findViewById(R.id.edminuto);
        btcalcular = (Button) findViewById(R.id.btcalcular);

        btcalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int hora = Integer.parseInt(edhora.getText().toString());
                int min = Integer.parseInt(edminuto.getText().toString());
                int seg = 0;

                seg = (hora * 3600) + (min * 60);

                AlertDialog.Builder dialogo = new AlertDialog.Builder(SegundosActivity.this);
                dialogo.setNeutralButton("Ok", null);
                dialogo.setMessage("Segundos: " + seg);
                dialogo.show();
            }
        });
    }
}
