package br.com.comprex.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import br.com.compras.compras.R;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mostrarTelaPrincipal();
            }
        }, 3000);

    }

    private void mostrarTelaPrincipal() {
        Intent irParaListaDeLista = new Intent(SplashScreenActivity.this, ListaListaActivity.class);
        startActivity(irParaListaDeLista);
        finish();
    }
}
