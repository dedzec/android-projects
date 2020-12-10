package com.lucas.app.visualizadordeimagens;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class VisualizadorActivity extends AppCompatActivity {
    ImageView imgfoto;
    TextView txtinformacao;
    Button btfoto1, btfoto2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizador);

        imgfoto = (ImageView) findViewById(R.id.imgFoto);
        txtinformacao = (TextView) findViewById(R.id.txtinformacao);
        btfoto1 = (Button) findViewById(R.id.btfoto1);
        btfoto2 = (Button) findViewById(R.id.btfoto2);

        btfoto1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgfoto.setImageResource(R.drawable.foto1);
                txtinformacao.setText("Foto 1");
            }
        });

        btfoto2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgfoto.setImageResource(R.drawable.foto2);
                txtinformacao.setText("Foto 2");
            }
        });
    }
}
