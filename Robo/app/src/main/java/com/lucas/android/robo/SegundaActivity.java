package com.lucas.android.robo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {
    Button botao;
    TextView conte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acao);

        botao = (Button) findViewById(R.id.btconte);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent objetoIntentNovo = getIntent();
                String cont = objetoIntentNovo.getStringExtra("cont");
                int num = Integer.parseInt(cont);

                for (int i=0;i<num;i++){
                    botao.callOnClick();
                }
            }
        }, 3000);
    }

    public void Contar(View botao){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                conte = (TextView) findViewById(R.id.tvconte);
                int cont = Integer.parseInt(conte.getText().toString());
                cont = cont + 1;
                conte.setText("" + cont);
            }
        }, 1000);
    }
}
