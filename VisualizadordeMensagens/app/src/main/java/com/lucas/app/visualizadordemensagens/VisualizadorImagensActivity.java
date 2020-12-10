package com.lucas.app.visualizadordemensagens;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class VisualizadorImagensActivity extends AppCompatActivity {
    ImageView imgFoto;
    TextView tvinformacao;
    Button btfoto1, btfoto2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizador_imagens);

        imgFoto = (ImageView) findViewById(R.id.imgFoto);
        tvinformacao = (TextView) findViewById(R.id.tvinformacao);
        btfoto1 = (Button) findViewById(R.id.btfoto1);
        btfoto2 = (Button) findViewById(R.id.btfoto2);

        btfoto1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgFoto.setImageResource(R.drawable.foto1);
                tvinformacao.setText("Foto 1");
            }
        });

        btfoto2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgFoto.setImageResource(R.drawable.foto2);
                tvinformacao.setText("Foto 2");
            }
        });
    }
}
