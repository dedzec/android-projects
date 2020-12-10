package com.lucas.app.contador;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ContadorActivity extends AppCompatActivity {
    TextView tvconte;
    Button btconte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contador);

        tvconte = (TextView) findViewById(R.id.tvconte);
        btconte = (Button) findViewById(R.id.btconte);

        btconte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cont = Integer.parseInt(tvconte.getText().toString());
                cont = cont + 1;

                tvconte.setText("" + cont);
            }
        });
    }
}
