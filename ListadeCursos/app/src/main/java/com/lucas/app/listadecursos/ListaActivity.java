package com.lucas.app.listadecursos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        List<Curso> cursos = todosOsCursos();
        ListView listadeCursos = (ListView) findViewById(R.id.lista);

        ArrayAdapter<Curso> adapter = new ArrayAdapter<Curso>(this,android.R.layout.simple_list_item_1, cursos);

        listadeCursos.setAdapter(adapter);
    }

    public List<Curso> todosOsCursos() {
        return new ArrayList<>(Arrays.asList(
                new Curso("Java", "básico de Java", EstadoAtual.FINALIZADO),
                new Curso("HTML e CSS", "HTML 5 e suas novidades", EstadoAtual.FAZENDO),
                new Curso("Android", "Boas práticas", EstadoAtual.FINALIZADO)
        ));
    }

    public class Curso {

        private String nome;
        private String descricao;
        private EstadoAtual estado;

        public Curso(String nome, String descricao, EstadoAtual esdado) {
            this.nome = nome;
            this.descricao = descricao;
            this.estado = esdado;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getDescricao() {
            return descricao;
        }

        public void setDescricao (String descricao) {
            this.descricao = descricao;
        }

        public EstadoAtual getEstado() {
            return estado;
        }

        public void setEstado(EstadoAtual estado) {
            this.estado = estado;
        }

        public String toString() {
            return "Curso: " + nome + "\nDescrição: " + descricao + "\nEstado: " + estado;
        }
    }

    public enum EstadoAtual {
        FAZENDO{
            @Override
            public String toString() {
                return "Fazendo";
            }
        }, FINALIZADO{
            public String toString() {
                return "Finalizado";
            }
        }
    }
}
