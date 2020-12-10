package com.lucas.app.trocatelas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TrocatelasActivity extends AppCompatActivity {
    Button bttela1,bttela2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        carregatelaprincipal();

    }

    public void carregatelaprincipal(){
        setContentView(R.layout.activity_trocatelas);

        bttela2 = (Button) findViewById(R.id.bttela2);
        bttela2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                carregatela2();
            }
        });
    }

    public void carregatela2(){
        setContentView(R.layout.tela2);

        bttela1 = (Button) findViewById(R.id.bttela1);
        bttela1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                carregatelaprincipal();
            }
        });
    }

}
