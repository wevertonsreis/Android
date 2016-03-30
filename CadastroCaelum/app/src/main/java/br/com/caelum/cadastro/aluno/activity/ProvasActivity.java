package br.com.caelum.cadastro.aluno.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import br.com.caelum.cadastro.aluno.fragment.ListaProvasFragment;
import br.com.caelum.cadastrocaelum.R;

/**
 * Created by Weverton on 29/03/2016.
 */
public class ProvasActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.provas);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.provas_view, new ListaProvasFragment());
        transaction.commit();
    }
}
