package br.com.caelum.cadastro.aluno.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import br.com.caelum.cadastro.aluno.fragment.DetalhesProvaFragment;
import br.com.caelum.cadastro.aluno.fragment.ListaProvasFragment;
import br.com.caelum.cadastro.aluno.model.Prova;
import br.com.caelum.cadastrocaelum.R;

public class ProvasActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.provas);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if(isTablet()) {
            System.out.println("E UM TABLETE");
            transaction.replace(R.id.provas_lista, new ListaProvasFragment());
            transaction.replace(R.id.provas_detalhe, new DetalhesProvaFragment());
        }else {
            System.out.println("NAO E UM TABLETE");
            transaction.replace(R.id.provas_view, new ListaProvasFragment());
        }

        transaction.commit();
    }

    private boolean isTablet() {
        return getResources().getBoolean(R.bool.isTablet);
    }

    public void selecionaProva(Prova prova) {
        Bundle argumentos = new Bundle();
        argumentos.putSerializable("prova", prova);

        DetalhesProvaFragment detalhesProvaFragment = new DetalhesProvaFragment();
        detalhesProvaFragment.setArguments(argumentos);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if(isTablet()) {
            transaction.replace(R.id.provas_detalhe, detalhesProvaFragment);
        } else {
            transaction.replace(R.id.provas_view, detalhesProvaFragment);
            transaction.addToBackStack(null);
        }

        transaction.commit();

    }

}
