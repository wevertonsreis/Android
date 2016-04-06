package br.com.caelum.cadastro.aluno.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import br.com.caelum.cadastro.aluno.model.Prova;
import br.com.caelum.cadastrocaelum.R;

public class DetalhesProvaFragment extends Fragment {

    private Prova prova;

    private View vLayout;
    private TextView tvMateria;
    private TextView tvData;
    private ListView lvTopicos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        vLayout = inflater.inflate(R.layout.provas_detalhe, container, false);

        if (getArguments() != null)
            prova = (Prova) getArguments().getSerializable("prova");

        if (prova != null) {
            buscarComponentes();
            carregarComponentes();
        }

        return vLayout;
    }

    private void buscarComponentes() {
        tvMateria = (TextView) vLayout.findViewById(R.id.detalhe_prova_materia);
        tvData = (TextView) vLayout.findViewById(R.id.detalhe_prova_data);
        lvTopicos = (ListView) vLayout.findViewById(R.id.detalhes_prova_topicos);
    }

    private void carregarComponentes() {
        tvMateria.setText(prova.getMateria());
        tvData.setText(prova.getData());
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, prova.getTopicos());
        lvTopicos.setAdapter(adapter);
    }

}
