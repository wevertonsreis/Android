package br.com.caelum.cadastro.aluno.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import br.com.caelum.cadastrocaelum.R;

public class DetalhesProvaFragment extends Fragment {

    private ListView listaDeTopicos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.provas_detalhe, container, false);
        listaDeTopicos = (ListView) layout.findViewById(R.id.detalhes_prova_topicos);
        return layout;
    }
}
