package com.lucas.app.tapioca;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class tapioca extends AppCompatActivity {
    EditText idlocal;
    CheckBox idrefrigerante,idcafe,idsuco,identrega;
    Button idfinalizar,idpagar;
    TextView tvfinalizar,tvtotal,tvfinalizar2,idmassa,idtipomassa,tvlocal;
    RadioGroup idgrupo;
    Spinner selecionar_sabor1,selecionar_sabor2;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        carregatelainicial();
    }

    public void carregatelainicial(){
        setContentView(R.layout.activity_tapioca);

        idtipomassa = (TextView) findViewById(R.id.idtipomassa);
        idmassa = (TextView) findViewById(R.id.idmassa);
        idrefrigerante = (CheckBox) findViewById(R.id.idrefrigerante);
        idcafe = (CheckBox) findViewById(R.id.idcafe);
        idsuco = (CheckBox) findViewById(R.id.idsuco);
        identrega = (CheckBox) findViewById(R.id.identrega);
        idlocal = (EditText) findViewById(R.id.idlocal);
        idlocal.setVisibility(View.INVISIBLE);

        selecionar_sabor1 = (Spinner) findViewById(R.id.selecionar_sabor1);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.Selecionar_sabor1, R.layout.support_simple_spinner_dropdown_item);
        selecionar_sabor1.setAdapter(adapter);

        selecionar_sabor2 = (Spinner) findViewById(R.id.selecionar_sabor2);
        ArrayAdapter adapter1 = ArrayAdapter.createFromResource(this, R.array.Selecionar_sabor2, R.layout.support_simple_spinner_dropdown_item);
        selecionar_sabor2.setAdapter(adapter1);

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.getMax();
        seekBar.getProgress();
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                progress = progresValue;
                if (progress == 0){
                    idmassa.setText("Tipo de massa: Fina");
                    Toast.makeText(getApplicationContext(), "Changing seekbar's progress", Toast.LENGTH_SHORT).show();


                }
                if (progress == 1){
                    idmassa.setText("Tipo de massa: Normal");
                    Toast.makeText(getApplicationContext(), "Changing seekbar's progress", Toast.LENGTH_SHORT).show();

                }
                if (progress == 2){
                    idmassa.setText("Tipo de massa: Grossa");
                    Toast.makeText(getApplicationContext(), "Changing seekbar's progress", Toast.LENGTH_SHORT).show();

                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(), "Started tracking seekbar", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (progress == 0){
                    idmassa.setText("Tipo de massa: Fina");
                    Toast.makeText(getApplicationContext(), "Stopped tracking seekbar", Toast.LENGTH_SHORT).show();

                }
                if (progress == 1){
                    idmassa.setText("Tipo de massa: Normal");
                    Toast.makeText(getApplicationContext(), "Stopped tracking seekbar", Toast.LENGTH_SHORT).show();

                }
                if (progress == 2){
                    idmassa.setText("Tipo de massa: Grossa");
                    Toast.makeText(getApplicationContext(), "Stopped tracking seekbar", Toast.LENGTH_SHORT).show();

                }
            }
        });
        identrega.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (identrega.isChecked()){
                    idlocal.setVisibility(View.VISIBLE);
                }
                else {
                    idlocal.setVisibility(View.INVISIBLE);
                }
            }
        });

        idfinalizar = (Button) findViewById(R.id.idfinalizar);
        idfinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String refrigerante = idrefrigerante.getText().toString();
                String cafe = idcafe.getText().toString();
                String suco = idsuco.getText().toString();
                String local = idlocal.getText().toString();
                String item = selecionar_sabor1.getSelectedItem().toString();
                int posicao = selecionar_sabor1.getSelectedItemPosition();
                String item2 = selecionar_sabor2.getSelectedItem().toString();
                int posicao2 = selecionar_sabor2.getSelectedItemPosition();
                double valor1 = 0;
                double valor2 = 0;
                if (posicao == 0) {
                    valor1 = 5;
                }
                if (posicao == 1) {
                    valor1 = 3;
                }
                if (posicao == 2) {
                    valor1 = 4;
                }
                if (posicao == 3) {
                    valor1 = 3;
                }
                if (posicao == 4) {
                    valor1 = 5;
                }
                if (posicao == 5) {
                    valor1 = 6;
                }
                if (posicao2 == 0) {
                    valor2 = 5;
                }
                if (posicao2 == 1) {
                    valor2 = 3;
                }
                if (posicao2 == 2) {
                    valor2 = 4;
                }
                if (posicao2 == 3) {
                    valor2 = 3;
                }
                if (posicao2 == 4) {
                    valor2 = 5;
                }
                if (posicao2 == 5) {
                    valor2 = 6;
                }

                double valor;
                valor = valor1 + valor2;

                if (idrefrigerante.isChecked()) {

                    valor = valor + 4.00;
                }
                if (idcafe.isChecked()) {

                    valor = valor + 2.00;
                }
                if (idsuco.isChecked()) {

                    valor = valor + 5.00;
                }


                carregatelapagamento(valor, item, item2, local);
            }
        });
    }

    public void carregatelapagamento(double valor,  String item,String item2, String local){
        setContentView(R.layout.activity_pagamento);

        tvfinalizar = (TextView) findViewById(R.id.tvfinalizar);
        tvfinalizar2 = (TextView) findViewById(R.id.tvfinalizar2);
        tvlocal = (TextView) findViewById(R.id.tvlocal);
        tvtotal = (TextView) findViewById(R.id.tvtotal);
        idpagar = (Button) findViewById(R.id.idpagar);
        idgrupo = (RadioGroup) findViewById(R.id.idgrupo);
        idtipomassa = (TextView) findViewById(R.id.idtipomassa);
        tvfinalizar.setText("" + item);
        tvfinalizar2.setText("" + item2);
        tvtotal.setText("" + valor);
        tvlocal.setText("" + local);

        idpagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String texto1=tvfinalizar.getText().toString();
                String texto3 = tvfinalizar2.getText().toString();
                String texto2 =tvtotal.getText().toString();
                String texto4 =tvlocal.getText().toString();

                int grupo = idgrupo.getCheckedRadioButtonId();
                String texto = "";
                if (grupo == R.id.idmastercard){
                    texto = "Compra Efetuada com sucesso!! Mastercard";
                }
                if (grupo == R.id.idvisa){
                    texto = "Compra Efetuada com sucesso!! Visa";
                }
                AlertDialog.Builder dialogo = new AlertDialog.Builder(tapioca.this);
                dialogo.setMessage("Pedido : " + texto1 + "||" + texto3  + "||" + "\nTotal : " + texto2 + "\n" + texto4 + "\n" + texto);
                dialogo.setNeutralButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        carregatelainicial();
                    }
                });
                dialogo.show();

            }
        });
    }
}
