package com.lucas.app.matriz;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText etA11,etA12,etA13,etA14;
    EditText etA21,etA22,etA23,etA24;
    EditText etA31,etA32,etA33,etA34;
    Button btcalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etA11 = (EditText) findViewById(R.id.etA11);
        etA12 = (EditText) findViewById(R.id.etA12);
        etA13 = (EditText) findViewById(R.id.etA13);
        etA14 = (EditText) findViewById(R.id.etA14);
        etA21 = (EditText) findViewById(R.id.etA21);
        etA22 = (EditText) findViewById(R.id.etA22);
        etA23 = (EditText) findViewById(R.id.etA23);
        etA24 = (EditText) findViewById(R.id.etA24);
        etA31 = (EditText) findViewById(R.id.etA31);
        etA32 = (EditText) findViewById(R.id.etA32);
        etA33 = (EditText) findViewById(R.id.etA33);
        etA34 = (EditText) findViewById(R.id.etA34);
        btcalcular = (Button) findViewById( R.id.btcalcular);

        btcalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float a11,a12,a13,a14,a21,a22,a23,a24,a31,a32,a33,a34;
                if (etA11.getText().toString().equals("")){
                    a11 = 0;
                }
                else {
                    a11 = Float.parseFloat(etA11.getText().toString());
                }
                if (etA12.getText().toString().equals("")){
                    a12 = 0;
                }
                else {
                    a12 = Float.parseFloat(etA12.getText().toString());
                }
                if (etA13.getText().toString().equals("")){
                    a13 = 0;
                }
                else {
                    a13 = Float.parseFloat(etA13.getText().toString());
                }
                if (etA14.getText().toString().equals("")){
                    a14 = 0;
                }
                else {
                    a14 = Float.parseFloat(etA14.getText().toString());
                }

                if (etA21.getText().toString().equals("")){
                    a21 = 0;
                }
                else {
                    a21 = Float.parseFloat(etA21.getText().toString());
                }
                if (etA22.getText().toString().equals("")){
                    a22 = 0;
                }
                else {
                    a22 = Float.parseFloat(etA22.getText().toString());
                }
                if (etA23.getText().toString().equals("")){
                    a23 = 0;
                }
                else {
                    a23 = Float.parseFloat(etA23.getText().toString());
                }
                if (etA24.getText().toString().equals("")){
                    a24 = 0;
                }
                else {
                    a24 = Float.parseFloat(etA24.getText().toString());
                }

                if (etA31.getText().toString().equals("")){
                    a31 = 0;
                }
                else {
                    a31 = Float.parseFloat(etA31.getText().toString());
                }
                if (etA32.getText().toString().equals("")){
                    a32 = 0;
                }
                else {
                    a32 = Float.parseFloat(etA32.getText().toString());
                }
                if (etA33.getText().toString().equals("")){
                    a33 = 0;
                }
                else {
                    a33 = Float.parseFloat(etA33.getText().toString());
                }
                if (etA34.getText().toString().equals("")){
                    a34 = 0;
                }
                else {
                    a34 = Float.parseFloat(etA34.getText().toString());
                }

                float d = ((a11*a22*a33) + (a12*a23*a31) + (a13*a21*a32)) - ((a31*a22*a13) + (a32*a23*a11) + (a33*a21*a12));
                float dx = ((a14*a22*a33) + (a12*a23*a34) + (a13*a24*a32)) - ((a34*a22*a13) + (a32*a23*a14) + (a33*a24*a12));
                float dy = ((a11*a24*a33) + (a14*a23*a31) + (a13*a21*a34)) - ((a31*a24*a13) + (a34*a23*a11) + (a33*a21*a14));
                float dz = ((a11*a22*a34) + (a12*a24*a31) + (a14*a21*a32)) - ((a31*a22*a14) + (a32*a24*a11) + (a34*a21*a12));

                float x = dx/d;
                float y = dy/d;
                float z = dz/d;

                AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
                dialogo.setMessage("RESULTADO: " + "\n X: " + x + "\n Y: " + y + "\n Z: " + z);
                dialogo.setNeutralButton("OK", null);
                dialogo.show();
            }
        });
    }
}
