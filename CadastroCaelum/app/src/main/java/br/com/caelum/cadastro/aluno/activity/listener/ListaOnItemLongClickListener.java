package br.com.caelum.cadastro.aluno.activity.listener;

import android.view.View;
import android.widget.AdapterView;

import br.com.caelum.cadastro.aluno.activity.ListaAlunosActivity;
import br.com.caelum.cadastro.aluno.model.Aluno;

public class ListaOnItemLongClickListener implements AdapterView.OnItemLongClickListener {

    private ListaAlunosActivity listaAlunosActivity;

    public ListaOnItemLongClickListener(ListaAlunosActivity listaAlunosActivity) {
        this.listaAlunosActivity = listaAlunosActivity;
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        listaAlunosActivity.setAlunoSelecionado((Aluno) parent.getItemAtPosition(position));
        return false;
    }

}
