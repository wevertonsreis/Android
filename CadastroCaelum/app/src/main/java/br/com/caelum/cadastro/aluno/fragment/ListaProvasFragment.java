package br.com.caelum.cadastro.aluno.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

import br.com.caelum.cadastro.aluno.activity.ProvasActivity;
import br.com.caelum.cadastro.aluno.model.Prova;
import br.com.caelum.cadastrocaelum.R;

public class ListaProvasFragment extends Fragment {

    private ListView listViewProvas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.provas_lista, container, false);

        listViewProvas = (ListView) layout.findViewById(R.id.lista_provas);

        Prova prova1 = new Prova("20/03/2012", "Matematica");
        prova1.setTopicos(Arrays.asList("Algebra linear", "Integral", "Diferencial"));

        Prova prova2 = new Prova("25/03/2012", "Portugues");
        prova2.setTopicos(Arrays.asList("Complemento nominal", "Oracoes Subordinadas"));

        List<Prova> provas = Arrays.asList(prova1, prova2);

        ArrayAdapter<Prova> adapter = new ArrayAdapter<Prova>(getContext(), android.R.layout.simple_list_item_1, provas);

        listViewProvas.setAdapter(adapter);

        listViewProvas.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Prova prova = (Prova) parent.getItemAtPosition(position);

                Toast.makeText(getContext(),"Prova = " + prova, Toast.LENGTH_SHORT).show();

                ProvasActivity calendarioProvas = (ProvasActivity) getActivity();
                calendarioProvas.selecionaProva(prova);
            }
        });

        return layout;
    }
}
