package br.com.comprex.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.compras.compras.R;
import br.com.comprex.modelo.Lista;

public class ListaAdapter extends BaseAdapter {

    private final List<Lista> listas;
    private final Activity activity;

    public ListaAdapter(List<Lista> listas, Activity activity) {
        this.listas = listas;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return listas.size();
    }

    @Override
    public Object getItem(int position) {
        return listas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listas.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = activity.getLayoutInflater().inflate(R.layout.activity_item_lista, parent, false);

        Lista lista = listas.get(position);

        TextView nome = (TextView) view.findViewById(R.id.item_lista_nome_lista);
        TextView situacao = (TextView) view.findViewById(R.id.item_lista_situacao_lista);

        nome.setText(lista.getNome());
        situacao.setText(lista.getSituacao());

        return view;
    }
}
