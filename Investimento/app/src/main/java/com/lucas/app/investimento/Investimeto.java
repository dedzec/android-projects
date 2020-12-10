package com.lucas.app.investimento;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Investimeto extends AppCompatActivity {
    EditText ednome, edvalor, edA, edB;
    Button btiniciar, btaplicar, btfinalizar, btcontinuar, btnovasimulacao;
    TextView tvusuario, tvvalor, tvano, tvA, tvB, tvresusuario, tvrendimento, tvfinal, tvinicial;
    ProgressBar progressBarA, progressBarB;
    List<Investimento> invest = adicionarinvestimento();
    private double res = 0;
    private int indici = 0;
    SharedPreferences sharedpreferences;
    public static final String mypreference = "mypref";
    public static final String Name = "nameKey";
    public static final String Inicial = "inicialKey";
    public static final String Valor = "valorKey";
    public static final String Indici = "indiciKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ednome = (EditText) findViewById(R.id.ednome);
        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);
        if (sharedpreferences.contains(Name)) {
            String i = sharedpreferences.getString(Indici, "");
            indici = Integer.parseInt(i);
            telaMain();
        }
        else {
            telaInicial();
        }
    }

    public void telaMain(){
        setContentView(R.layout.activity_main);
        btcontinuar = (Button) findViewById(R.id.btcontinuar);
        btnovasimulacao = (Button) findViewById(R.id.btnovasimulacao);

        btcontinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n = sharedpreferences.getString(Name, "");
                double v = Double.parseDouble(sharedpreferences.getString(Valor, ""));
                res = Double.parseDouble(sharedpreferences.getString(Inicial, ""));
                telaSimulacao(n, v);
            }
        });
        btnovasimulacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                telaInicial();
            }
        });
    }

    public void telaInicial(){
        setContentView(R.layout.activity_investimeto);

        ednome = (EditText) findViewById(R.id.ednome);
        edvalor = (EditText) findViewById(R.id.edvalor);
        btiniciar = (Button) findViewById(R.id.btiniciar);

        btiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = ednome.getText().toString();
                String inicial = edvalor.getText().toString();
                indici = 0;
                double valor = 0;

                if (inicial.length() > 0) {
                    valor = Double.parseDouble(inicial);
                }

                if (nome.length() > 0 && valor >= 1000){
                    res = valor;
                    String r = "" + res;
                    String vlr = "" + valor;
                    String i = "" + indici;
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putString(Name, nome);
                    editor.putString(Inicial, r);
                    editor.putString(Valor, vlr);
                    editor.putString(Indici, i);
                    editor.commit();
                    telaSimulacao(nome, valor);
                }
                else {
                    AlertDialog.Builder dialogo = new AlertDialog.Builder(Investimeto.this);
                    dialogo.setNeutralButton("Ok", null);
                    dialogo.setMessage("Digite algum nome e algum valor acima de 1000!!");
                    dialogo.show();
                }
            }
        });
    }

    public void telaSimulacao(final String nome, double valor){
        setContentView(R.layout.activity_simulacao);

        tvano = (TextView) findViewById(R.id.tvano);
        tvusuario = (TextView) findViewById(R.id.tvusuario);
        tvvalor = (TextView) findViewById(R.id.tvvalor);
        tvA = (TextView) findViewById(R.id.tvA);
        tvB = (TextView) findViewById(R.id.tvB);
        progressBarA = (ProgressBar) findViewById(R.id.progressBarA);
        progressBarB = (ProgressBar) findViewById(R.id.progressBarB);
        edA = (EditText) findViewById(R.id.edA);
        edB = (EditText) findViewById(R.id.edB);
        btaplicar = (Button) findViewById(R.id.btaplicar);

        tvano.setText("Investimento ano " + invest.get(indici).getAno());
        tvusuario.setText("Usuário: " + nome);
        tvvalor.setText("" + Double.valueOf(String.format(Locale.US, "%.2f", valor)));
        tvA.setText("" + invest.get(indici).getA() + "%");
        tvB.setText("" + invest.get(indici).getB() + "%");

        progressBarA.setMax(100);
        progressBarB.setMax(100);
        progressBarA.setProgress(invest.get(indici).getA());
        progressBarB.setProgress(invest.get(indici).getB());

        btaplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String name = nome;
                double vl = Double.parseDouble(tvvalor.getText().toString());
                final double vl1 = vl;
                String eda = edA.getText().toString();
                String edb = edB.getText().toString();
                double edaa = 0;
                double edbb = 0;
                if (eda.length() > 0 && edb.length() > 0){
                    edaa = Double.parseDouble(edA.getText().toString());
                    edbb = Double.parseDouble(edB.getText().toString());
                    if ((edaa + edbb > 100) || (edaa + edbb) < 100) {
                        AlertDialog.Builder dialogo = new AlertDialog.Builder(Investimeto.this);
                        dialogo.setMessage("A porsentagem na aplicação tem que ser 100%");
                        dialogo.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                telaSimulacao(name, vl1);
                            }
                        });
                        dialogo.show();
                    }
                    else {
                        double numero1 = numeroAleatorio(-7, 10);
                        double numero2 = numeroAleatorio(-7, 10);
                        double vlr = ((vl) * (edaa/100) * (numero1/10)) + ((vl) * (edbb/100) * (numero2/10));
                        final double total = vl + vlr;
                        AlertDialog.Builder dialogo = new AlertDialog.Builder(Investimeto.this);
                        dialogo.setMessage("Valor de Investimeto no Ano " + invest.get(indici).getAno()
                                + "\nR$ " + Double.valueOf(String.format(Locale.US, "%.2f", vlr))
                                + "\nTotal: R$ " + Double.valueOf(String.format(Locale.US, "%.2f", total)));
                        dialogo.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                indici+= 1;
                                if (indici <= 9) {
                                    String tot = ""+total;
                                    String in = "" + indici;
                                    SharedPreferences.Editor editor = sharedpreferences.edit();
                                    editor.putString(Name, name);
                                    editor.putString(Valor, tot);
                                    editor.putString(Indici, in);
                                    editor.commit();
                                    telaSimulacao(name, total);
                                }
                                else {
                                    telafinal(name, total);
                                }
                            }
                        });
                        dialogo.show();
                    }
                }
                else {
                    AlertDialog.Builder dialogo = new AlertDialog.Builder(Investimeto.this);
                    dialogo.setMessage("A porsentagem na aplicação tem que ser 100%");
                    dialogo.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            telaSimulacao(name, vl1);
                        }
                    });
                    dialogo.show();
                }
            }
        });
    }

    public void telafinal(final String nome, double valor){
        setContentView(R.layout.activity_encerrar);

        tvresusuario = (TextView) findViewById(R.id.tvresusuario);
        tvrendimento = (TextView) findViewById(R.id.tvrendimento);
        tvinicial = (TextView) findViewById(R.id.tvinicial);
        tvfinal = (TextView) findViewById(R.id.tvfinal);
        btfinalizar = (Button) findViewById(R.id.btfinalizar);

        tvresusuario.setText("Usuário " + nome);

        if (valor > res) {
            tvrendimento.setText("Seu rendimento foi muito bom!!");
            tvinicial.setText("Valor inicial: R$ "+ Double.valueOf(String.format(Locale.US, "%.2f", res)));
            tvfinal.setText("Valor final: R$ " + Double.valueOf(String.format(Locale.US, "%.2f", valor)));
        }
        else {
            tvrendimento.setText("Seu rendimento não foi muito bom!!");
            tvinicial.setText("Valor inicial: R$ "+ Double.valueOf(String.format(Locale.US, "%.2f", res)));
            tvfinal.setText("Valor final: R$ " + Double.valueOf(String.format(Locale.US, "%.2f", valor)));
        }
        btfinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.remove(Name);
                editor.remove(Inicial);
                editor.remove(Valor);
                editor.remove(Indici);
                editor.commit();
                telaInicial();
            }
        });
    }

    public class Investimento{
        private int ano;
        private int a;
        private int b;

        public Investimento(int ano, int a, int b) {
            this.ano = ano;
            this.a = a;
            this.b = b;
        }

        public int getAno() {
            return ano;
        }

        public void setAno(int ano) {
            this.ano = ano;
        }

        public int getA() {
            return a;
        }

        public void setA (int a) {
            this.a = a;
        }

        public int getB() {
            return b;
        }

        public void setB (int b) {
            this.b = b;
        }

        public String toString() {
            return "Ano: " + ano + "\nA: " + a + "\nB: " + b;
        }
    }

    public List<Investimento> adicionarinvestimento(){
        return new ArrayList<>(Arrays.asList(
                new Investimento(1,15,85),
                new Investimento(2,83,17),
                new Investimento(3,9,91),
                new Investimento(4,86,14),
                new Investimento(5,13,87),
                new Investimento(6,89,11),
                new Investimento(7,22,78),
                new Investimento(8,20,80),
                new Investimento(9,5,95),
                new Investimento(10,92,8),
                new Investimento(11,00,00)
        ));
    }

    public int numeroAleatorio(int min, int max){
        int randomNum = min + (int)(Math.random() * (max - min));
        return randomNum;
    }

}
