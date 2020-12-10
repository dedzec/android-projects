package com.lucas.app.sistemadecompras;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class ComprasActivity extends AppCompatActivity {
    CheckBox chkarroz;
    CheckBox chkleite;
    CheckBox chkcarne;
    CheckBox chkfeijao;
    Button bttotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compras);

        chkarroz = (CheckBox) findViewById(R.id.chkarroz);
        chkleite = (CheckBox) findViewById(R.id.chkleite);
        chkcarne = (CheckBox) findViewById(R.id.chkcarne);
        chkfeijao = (CheckBox) findViewById(R.id.chkfeijao);
        bttotal = (Button) findViewById(R.id.bttotal);

        bttotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double total = 0;
                if (chkarroz.isChecked()) {
                    total = total + 2.69;
                }
                if (chkleite.isChecked()) {
                    total = total + 5.00;
                }
                if (chkcarne.isChecked()) {
                    total = total + 9.70;
                }
                if (chkfeijao.isChecked()) {
                    total = total + 2.80;
                }

                AlertDialog.Builder dialogo = new AlertDialog.Builder(ComprasActivity.this);
                dialogo.setMessage("Total: R$ " + total);
                dialogo.setNeutralButton("Ok", null);
                dialogo.show();
            }
        });
    }
}
