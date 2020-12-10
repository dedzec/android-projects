package com.lucas.android.autenticacaousuario;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();

        //Login do Usuário
        firebaseAuth.signInWithEmailAndPassword("llucas.lm@hotmail.com", "lucas123")
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if ( task.isSuccessful() ) {//sucesso ao cadastrar
                            Log.i("signIn", "Sucesso ao fazer login usuário!!!");
                        } else {//erro ao cadastrar usuario
                            Log.i("signIn", "Erro ao fazer login usuário");
                        }

                    }
                });

        //Logout do Usuário
        //firebaseAuth.signOut();

        //verificar usuario logado
        if ( firebaseAuth.getCurrentUser() != null) {
            Log.i("verificarUsuario", "Usuário está Logado");
        } else {
            Log.i("verificarUsuario", "Usuário não está Logado");
        }

        //Cadastro
        /*firebaseAuth.createUserWithEmailAndPassword("llucas.lm@hotmail.com", "lucas123")
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if ( task.isSuccessful() ) {//sucesso ao cadastrar
                            Log.i("createUser", "Sucesso ao cadastrar usuário!!!");
                        } else {//erro ao cadastrar usuario
                            Log.i("createUser", "Erro ao cadastrar usuário");
                        }

                    }
                });*/
    }
}
