package com.lucas.app.listadepaises;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListaActivity extends AppCompatActivity {
    ListView listapaises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        listapaises = (ListView) findViewById(R.id.idlista);

        listapaises.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String paises = ((TextView) view).getText().toString();
                String capital = "";

                if (paises.equals("Brasil")) {
                    capital = "Brasilia";
                }
                if (paises.equals("Canada")) {
                    capital = "Ottawa";
                }
                if (paises.equals("Estados Unidos")) {
                    capital = "Washington, D.C.";
                }
                if (paises.equals("Portugal")) {
                    capital = "Lisboa";
                }
                if (paises.equals("Japão")) {
                    capital = "Tokio";
                }

                Toast.makeText(ListaActivity.this,capital,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
