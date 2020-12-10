package com.lucas.app.listadecontatos;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListaActivity extends AppCompatActivity {
    ListView listacontatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        listacontatos = (ListView) findViewById(R.id.lista);

        listacontatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String nome = ((TextView) view).getText().toString();

                Toast.makeText(ListaActivity.this,nome,Toast.LENGTH_SHORT).show();

                /*AlertDialog.Builder dialogo = new AlertDialog.Builder(ListaActivity.this);
                dialogo.setNeutralButton("Ok", null);
                dialogo.setMessage(nome);
                dialogo.show();*/
            }
        });
    }
}
