package com.lucas.app.calcularsalario;

import android.app.Dialog;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.view.View;

public class SalarioActivity extends AppCompatActivity {
    EditText idsalario;
    RadioGroup rgopcoes;
    Button btcalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salario);

        rgopcoes = (RadioGroup) findViewById(R.id.rgopcoes);
        idsalario = (EditText) findViewById(R.id.idsalario);
        btcalcular = (Button) findViewById(R.id.btcalcular);

        btcalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double salario = Double.parseDouble(idsalario.getText().toString());
                int op = rgopcoes.getCheckedRadioButtonId();

                if (op == R.id.rb40) {salario = salario * 1.4;}
                else if (op == R.id.rb45) {salario = salario * 1.45;}
                else {salario = salario * 1.5;}

                AlertDialog.Builder dialogo = new AlertDialog.Builder(SalarioActivity.this);
                dialogo.setNeutralButton("ok", null);
                dialogo.setMessage("Novo salário: " + salario);
                dialogo.show();
            }
        });
    }
}
