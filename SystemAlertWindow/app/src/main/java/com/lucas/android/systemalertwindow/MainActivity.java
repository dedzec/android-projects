package com.lucas.android.systemalertwindow;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Settings.canDrawOverlays(this)) {

            //Iniciar o serviço imediatamente - o usuário já concedeu permissão anteriormente
            launchMainService();
        }
        else {

            //Verifique se o usuário concedeu permissão e solicite-as, se não
            checkDrawOverlayPermission();
        }
    }

    private void launchMainService() {
        Intent svc = new Intent(this, MainService.class);
        startService(svc);
        finish();
    }

    public final static int REQUEST_CODE = 10101;

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void checkDrawOverlayPermission() {

        //Verifica se o aplicativo já tem permissão para desenhar sobreposições
        if (!Settings.canDrawOverlays(this)) {

            //Caso contrário, crie uma intenção para iniciar a solicitação de permissão
            Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" + getPackageName()));

            //Intent de inicialização, com o código de solicitação fornecido
            startActivityForResult(intent, REQUEST_CODE);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) {

        // Verifique se um código de solicitação é recebido que corresponda ao que fornecemos para a solicitação de desenho de sobreposição
        if (requestCode == REQUEST_CODE) {

            //Verifique novamente se o usuário concedeu e não acabou de ignorar a solicitação
            if (Settings.canDrawOverlays(this)) {

                //Lançar o serviço
                launchMainService();
            }
            else {

                Toast.makeText(this, "Desculpa. Não é possível desenhar sobreposições sem permissão...", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
