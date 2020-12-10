package com.lucas.android.signos;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private ListView listaSignos;
    private String[] signos = {
            "Áries", "Touro", "Gêmeos", "Câncer", "Leão",
            "Virgem", "Escorpião", "Sagitário", "Capricórnio",
            "Aquários", "Peixes"
    };
    private String[] perfis = {
            "Arianos dão animados, independente, individualistas, dinâmicos, corajosos e Aventureiros",
            "Taurinos são positivos, pasientes, determinados, noturnos, leais e românticos",
            "Geminianos são positivos, mutáveis, racionais e bastente voláteis",
            "...", "...", "...", "...", "...", "...", "...", "...", "..."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaSignos = (ListView) findViewById(R.id.listViewId);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                signos
        );

        listaSignos.setAdapter(adapter);

        listaSignos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                int codigoPosicao = position;
                Toast.makeText(getApplicationContext(), perfis[codigoPosicao], Toast.LENGTH_SHORT).show();
            }
        });
    }
}
