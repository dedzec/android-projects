package com.lucas.android.todolist;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText textoTarefa;
    private Button botaoAdcionar;
    private ListView listaTarefa;
    private SQLiteDatabase bancoDados;

    private ArrayAdapter<String> itensAdaptador;
    private ArrayList<String> itens;
    private ArrayList<Integer> ids;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            // Recuperar componentes
            textoTarefa = (EditText) findViewById(R.id.idtexto);
            botaoAdcionar = (Button) findViewById(R.id.idbtnadicionar);

            // Lista
            listaTarefa = (ListView) findViewById(R.id.idlistview);

            // Banco de dados
            bancoDados = openOrCreateDatabase("apptarefas", MODE_PRIVATE, null);

            // Tabela Tarefa
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS tarefa (id INTEGER PRIMARY KEY AUTOINCREMENT, tarefa VARCHAR)");

            botaoAdcionar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String textoDigitado = textoTarefa.getText().toString();
                    salvarTarefa(textoDigitado);

                }
            });

            /*listaTarefa.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    removerTarefa( ids.get( position ) );
                }
            });*/

            listaTarefa.setLongClickable(true);
            listaTarefa.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                    // Log.i("ITENS: ", position + " / " + ids.get(position));
                    removerTarefa(ids.get(position));
                    return true;
                }
            });

            // Recupera as tarefa
            recuperarTarefas();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void salvarTarefa(String texto) {

        try {

            if (texto.equals("")) {

                Toast.makeText(MainActivity.this, "Digite uma tarefa", Toast.LENGTH_SHORT).show();

            } else {

                bancoDados.execSQL("INSERT INTO tarefa (tarefa) VALUES ('" + texto + "')");
                Toast.makeText(MainActivity.this, "Tarefa salva com sucesso", Toast.LENGTH_SHORT).show();
                recuperarTarefas();
                textoTarefa.setText("");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void recuperarTarefas() {

        try {

            // Recuperar as tarefa
            Cursor cursor = bancoDados.rawQuery("SELECT * FROM tarefa ORDER BY id DESC", null);

            // Recuperar os IDs das colunas
            int indiceColunaId = cursor.getColumnIndex("id");
            int indiceColunaTarefa = cursor.getColumnIndex("tarefa");

            // Criar adaptador
            itens = new ArrayList<String>();
            ids = new ArrayList<Integer>();
            itensAdaptador = new ArrayAdapter<String>(getApplicationContext(),
                    android.R.layout.simple_list_item_2,
                    android.R.id.text2,
                    itens);
            listaTarefa.setAdapter( itensAdaptador );

            // Listar as terefas
            cursor.moveToFirst();
            while (cursor != null) {

                Log.i("Resultado - ", "ID Tarefa: " + cursor.getString(indiceColunaId) + " Tarefa: " + cursor.getString(indiceColunaTarefa) );
                itens.add(cursor.getString(indiceColunaTarefa));
                ids.add(Integer.parseInt(cursor.getString(indiceColunaId)));

                cursor.moveToNext();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void removerTarefa(Integer id) {

        try {

            bancoDados.execSQL("DELETE FROM tarefa WHERE id=" + id);
            recuperarTarefas();
            Toast.makeText(MainActivity.this, "Tarefa removida com sucesso", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
