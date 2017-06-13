package br.com.comprex.comprex.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import br.com.comprex.comprex.R;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mostrarTelaLogin();
            }
        }, 3000);
    }

    /**
     * Redireciona o usuario para a tela de login e finaliza a tela de apresentacao
     */
    private void mostrarTelaLogin() {
        Intent irParaTelaLogin = new Intent(SplashScreenActivity.this, LoginActivity.class);
        startActivity(irParaTelaLogin);
        finish();
    }

}
