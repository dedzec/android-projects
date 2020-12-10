package com.lucas.android.simplestouch;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    private Button btn1;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1=(Button) findViewById(R.id.btn1);
        btn1.setOnTouchListener(this);
        tv1=(TextView) findViewById(R.id.textView);

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {


        int x = (int)event.getX();
        int y = (int)event.getY();


        switch (event.getAction()) {

            case (MotionEvent.ACTION_DOWN):
                tv1.setText("Pulsación DOWN, \nCordenadas: X:"+ x + ", Y:" + y);
                cambiarIconoDrawable(true);
                break;

            case (MotionEvent.ACTION_MOVE):
                tv1.setText("Pulsación MOVE, \nCordenadas: X:" + x + ", Y:" + y);
                break;
            case (MotionEvent.ACTION_UP):
                tv1.setText("Pulsación UP, \nCordenadas: X:" + x + ", Y:" + y);
                cambiarIconoDrawable(false);
                break;
            case (MotionEvent.ACTION_CANCEL):
                tv1.setText("Pulsación CANCEL, \nCordenadas: X:" + x + ", Y:" + y);
                Log.d("motion", "Este evento se dá cuando el gesto actual ha sido abortado y no recibamos ningun evento mas de el");
                break;
            case (MotionEvent.ACTION_OUTSIDE):
                tv1.setText("Pulsación OUTSIDE, \nCordenadas: X:" + x + ", Y:" + y);
                Log.d("motion", "evento ocurre fuera de los límites de la interfaz de usuario.");
                break;
            default:

                break;


        }


        return super.onTouchEvent(event);

    }




    public void cambiarIconoDrawable(boolean pulsado){
        if(pulsado){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                btn1.setBackground(ContextCompat.getDrawable(this, R.drawable.icono_verde));
            } else if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.JELLY_BEAN ){
                btn1.setBackground(getResources().getDrawable(R.drawable.icono_verde));
            }else {}

        }else {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                btn1.setBackground(ContextCompat.getDrawable(this, R.drawable.icono_gris));
            } else if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.JELLY_BEAN ){
                btn1.setBackground(getResources().getDrawable(R.drawable.icono_gris));
            }else {}
        }

    }
}
