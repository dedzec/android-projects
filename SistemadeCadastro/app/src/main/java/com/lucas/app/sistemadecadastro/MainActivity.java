package com.lucas.app.sistemadecadastro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button bt_cadastrar_usuario, bt_usuarios_cadastrados, btcadastrar, btcancelar;
    EditText ednome, edtelefone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        carregartelaprincipal();
    }

    public void carregartelaprincipal(){
        setContentView(R.layout.activity_main);

        bt_cadastrar_usuario = (Button) findViewById(R.id.bt_cadastrar_usuario);
        bt_cadastrar_usuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                carregartelacadastro();
            }
        });

        bt_usuarios_cadastrados = (Button) findViewById(R.id.bt_usuarios_cadastrados);
        bt_usuarios_cadastrados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                carregartelalistar();
            }
        });

    }

    public  void carregartelacadastro(){
        setContentView(R.layout.cadastro_usuario);

        btcadastrar = (Button) findViewById(R.id.btcadastrar);
        btcancelar = (Button) findViewById(R.id.btcancelar);
        ednome = (EditText) findViewById(R.id.ednome);
        edtelefone = (EditText) findViewById(R.id.edtelefone);

        btcadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btcancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                carregartelaprincipal();
            }
        });
    }

    public void carregartelalistar(){
        setContentView(R.layout.listar_usuarios);
    }
}
