package com.lucas.android.sqlite;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            SQLiteDatabase bancoDados = openOrCreateDatabase("app", MODE_PRIVATE, null);

            // tabela
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas (nome VARCHAR, idade INT(3))");

            // Inserir dados
            // bancoDados.execSQL("INSERT INTO pessoa (nome, idade) VALUES ('Lucas', 22)");
            // bancoDados.execSQL("INSERT INTO pessoa (nome, idade) VALUES ('Matheus', 19)");

            Cursor cursor = bancoDados.rawQuery("SELECT nome, idade FROM pessoas", null);

            // Recuperar Indices
            int indiceColunaNome = cursor.getColumnIndex("nome");
            int indiceColunaIdade = cursor.getColumnIndex("idade");

            //Voltar cursor para o inicio
            cursor.moveToFirst();

            while (cursor != null) {

                Log.i("RESULTADO - nome: ", cursor.getString(indiceColunaNome));
                Log.i("RESULTADO - idade: ", cursor.getString(indiceColunaIdade));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
