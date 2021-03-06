package br.com.comprex.comprex.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import br.com.comprex.comprex.R;

/**
 * Controla as acoes do layout activity_splash_screen
 */
public class SplashScreenActivity extends AppCompatActivity {

    /**
     * A tempo que a tela ficara visivel ao usuario e milesegundos
     */
    private static final int TEMPO_APRESENTACAO = 3000;

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
        }, TEMPO_APRESENTACAO);

    }

    /**
     * Redireciona o usuario para a tela de login e finaliza a tela de apresentacao
     */
    private void mostrarTelaLogin() {
        Intent intentTelaLogin = new Intent(SplashScreenActivity.this, LoginActivity.class);
        startActivity(intentTelaLogin);
        finish();
    }

}
