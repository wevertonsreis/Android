package br.com.caelum.cadastro.aluno.activity.listener;

import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import br.com.caelum.cadastro.aluno.activity.FormularioActivity;
import br.com.caelum.cadastro.aluno.activity.ListaAlunosActivity;
import br.com.caelum.cadastro.aluno.model.Aluno;
import br.com.caelum.cadastro.comum.Extras;

public class ListaOnItemClickListener implements AdapterView.OnItemClickListener {

    private ListaAlunosActivity listaAlunosActivity;

    public ListaOnItemClickListener(ListaAlunosActivity listaAlunosActivity) {
        this.listaAlunosActivity = listaAlunosActivity;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        listaAlunosActivity.setAlunoSelecionado((Aluno) parent.getItemAtPosition(position));
        Intent edicao = new Intent(listaAlunosActivity, FormularioActivity.class);
        edicao.putExtra(Extras.ALUNO_SELECIONADO.name(), listaAlunosActivity.getAlunoSelecionado());
        listaAlunosActivity.startActivity(edicao);
    }

}
