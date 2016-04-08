package br.com.caelum.cadastro.aluno.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import br.com.caelum.cadastro.aluno.fragment.MapFragment;
import br.com.caelum.cadastrocaelum.R;

public class MostrarAlunosProximosActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_layout);

        MapFragment mapFragment = new MapFragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.mapa, mapFragment);
        transaction.commit();

    }
}
