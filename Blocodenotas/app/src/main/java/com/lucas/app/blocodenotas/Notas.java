package com.lucas.app.blocodenotas;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import java.util.ArrayList;
import java.util.Calendar;

public class Notas extends AppCompatActivity {
    EditText idtext;
    Spinner splocal;
    SeekBar idhora;
    Button btsalvar, btlistar, btvoltar;
    ListView lista;
    Button btnDatePicker, btnTimePicker;
    TextView txtDate, txtTime;
    private int mYear, mMonth, mDay, mHour, mMinute;

    private ArrayList<String> texto = new ArrayList<String>();
    ArrayAdapter<String> adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tela1();
    }

    public void tela1(){
        setContentView(R.layout.activity_notas);

        final Spinner splocal = (Spinner) findViewById(R.id.splocal);
        ArrayAdapter adapter=
                ArrayAdapter.createFromResource(this, R.array.splocal, R.layout.support_simple_spinner_dropdown_item);
        splocal.setAdapter(adapter);
        idtext = (EditText) findViewById(R.id.idtext);
        btnDatePicker=(Button)findViewById(R.id.btn_date);
        btnTimePicker=(Button)findViewById(R.id.btn_time);
        txtDate = (TextView) findViewById(R.id.in_date);
        txtTime = (TextView) findViewById(R.id.in_time);
        btsalvar = (Button) findViewById(R.id.btsalvar);
        btlistar = (Button) findViewById(R.id.btlistar);

        btnDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get Current Date
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(Notas.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });
        btnTimePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get Current Time
                final Calendar c = Calendar.getInstance();
                mHour = c.get(Calendar.HOUR_OF_DAY);
                mMinute = c.get(Calendar.MINUTE);

                // Launch Time Picker Dialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(Notas.this,
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {

                                txtTime.setText(hourOfDay + ":" + minute);
                            }
                        }, mHour, mMinute, false);
                timePickerDialog.show();
            }
        });

        btsalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = idtext.getText().toString();
                String data = txtDate.getText().toString();
                String hora = txtTime.getText().toString();
                String item  =  splocal.getSelectedItem().toString();
                int posicao=  splocal.getSelectedItemPosition();
                String msn = "" +text;
                msn += "\n" + item;
                msn += "\n" + data;
                msn += " as " + hora;
                if (text.length()>0) {
                    texto.add(msn);
                    AlertDialog.Builder dialogo = new AlertDialog.Builder(Notas.this);
                    dialogo.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            tela1();
                        }
                    });
                    dialogo.setMessage("Mensagem add");
                    dialogo.show();
                }
                else {
                    AlertDialog.Builder dialogo = new AlertDialog.Builder(Notas.this);
                    dialogo.setNeutralButton("Ok", null);
                    dialogo.setMessage("Mensagem não add");
                    dialogo.show();
                }

            }
        });

        btlistar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tela2();
            }
        });
    }

    public void tela2(){
        setContentView(R.layout.activity_lista);
        lista = (ListView) findViewById(R.id.lista);
        btvoltar = (Button) findViewById(R.id.btvoltar);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,texto);
        lista.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        btvoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tela1();
            }
        });

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder dialogo = new AlertDialog.Builder(Notas.this);
                dialogo.setNeutralButton("Ok", null);
                dialogo.setMessage(((TextView)view).getText().toString());
                dialogo.show();
            }
        });
    }
}
