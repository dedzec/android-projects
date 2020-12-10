package com.lucas.app.playlist;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText ednome, edmusica;
    Button btcadastrar, btconfirmar, btentrar, btvoltar, btvoltar2;
    ListView lista, musica;
    private int num1 = 1;
    private int num2 = 1;
    private List<String> album = new ArrayList<String>();
    private List<String> musicas = new ArrayList<String>();
    ArrayAdapter<String> adapter = null;
    SharedPreferences sharedPreferences;
    public static final String mypreference = "album";
    public static final String Album = "albumKey";
    public static final String Musicas = "musicasKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tela1();
    }

    public void tela1(){
        setContentView(R.layout.activity_main);
        btcadastrar =(Button) findViewById(R.id.btcadastrar);
        lista = (ListView) findViewById(R.id.lista);

        sharedPreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);
        List<String> list = album;
        if (sharedPreferences.contains(Album)) {
            String serialized = sharedPreferences.getString(Album, "");
            list = Arrays.asList(TextUtils.split(serialized, ","));
            album = new ArrayList<String>(list);
        }

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        lista.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        btcadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tela2();
            }
        });

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String n = ((TextView)view).getText().toString();
                tela3(n);
            }
        });
    }

    public void tela2(){
        setContentView(R.layout.activity_cadastar);
        ednome = (EditText) findViewById(R.id.ednome);
        btconfirmar= (Button) findViewById(R.id.btconfirmar);
        btvoltar2 = (Button) findViewById(R.id.btvoltar2);

        btconfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n = ednome.getText().toString();
                num1 = 1;
                if (n.equals("")) {
                    AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
                    dialogo.setMessage("Digite o nome do album");
                    dialogo.setNeutralButton("Ok", null);
                    dialogo.show();
                }
                else {
                    if (album.size() > 0) {
                        String m = album.get(album.size()-1);
                        num1 = Integer.parseInt(m.substring(0, 1));
                        num1++;
                    }
                    String nome = "" + num1 + "." + n;
                    album.add(nome);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(Album, TextUtils.join(",", album));
                    editor.commit();
                    tela1();
                }
            }
        });

        btvoltar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tela1();
            }
        });
    }

    public void tela3(final String nome){
        setContentView(R.layout.activity_musicas);
        musica = (ListView) findViewById(R.id.musica);
        edmusica = (EditText) findViewById(R.id.edmusica);
        btentrar = (Button) findViewById(R.id.btentrar);
        btvoltar = (Button) findViewById(R.id.btvoltar);

        sharedPreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);
        List<String> list = musicas;
        if (sharedPreferences.contains(Musicas)) {
            String serialized = sharedPreferences.getString(Musicas, "");
            list = Arrays.asList(TextUtils.split(serialized, ","));
            musicas = new ArrayList<String>(list);
        }
        final List<String> lista = new ArrayList<String>();
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                String n = nome.substring(0, 1);
                String l = list.get(i);
                if (n.equals(l.substring(0, 1))) {
                    lista.add(list.get(i));
                }
            }
        }

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
        musica.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        btentrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String m = edmusica.getText().toString();
                num2 = 1;
                if (m.equals("")) {
                    AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
                    dialogo.setMessage("Digite o nome da musica");
                    dialogo.setNeutralButton("Ok", null);
                    dialogo.show();
                }
                else {
                    String n = nome.substring(0, 1);
                    if (lista.size() > 0) {
                        String o = lista.get(lista.size()-1);
                        num2 = Integer.parseInt(o.substring(2, 3));
                        num2++;
                    }
                    String name = "" + n + "." + num2 + "." + m;
                    musicas.add(name);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(Musicas, TextUtils.join(",", musicas));
                    editor.commit();
                    tela3(nome);
                }
            }
        });

        btvoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tela1();
            }
        });
    }
}
