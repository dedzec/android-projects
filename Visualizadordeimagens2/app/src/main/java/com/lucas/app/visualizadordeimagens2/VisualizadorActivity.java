package com.lucas.app.visualizadordeimagens2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class VisualizadorActivity extends AppCompatActivity {
    ImageView imgfoto;
    TextView txtinformacao;
    Button btfoto;
    int cont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizador);

        imgfoto = (ImageView) findViewById(R.id.imgfoto);
        txtinformacao = (TextView) findViewById(R.id.txtinformacao);
        btfoto = (Button) findViewById(R.id.btfoto);

        btfoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cont++;
                if (cont >= 5) {cont=1;}
                if (cont == 1){
                    imgfoto.setImageResource(R.drawable.foto1);
                    txtinformacao.setText("Foto 1");
                }
                if (cont == 2){
                    imgfoto.setImageResource(R.drawable.foto2);
                    txtinformacao.setText("Foto 2");
                }
                if (cont == 3){
                    imgfoto.setImageResource(R.drawable.foto3);
                    txtinformacao.setText("Foto 3");
                }
                if (cont == 4){
                    imgfoto.setImageResource(R.drawable.foto4);
                    txtinformacao.setText("Foto 4");
                }
            }
        });
    }
}
