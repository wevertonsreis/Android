package br.com.comprex.comprex.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.comprex.comprex.R;
import br.com.comprex.comprex.modelo.Mercado;

public class MercadoAdapter extends BaseAdapter {

    private List<Mercado> mercados;
    private Activity activity;

    public MercadoAdapter(List<Mercado> mercados, Activity activity) {
        this.mercados = mercados;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return mercados.size();
    }

    @Override
    public Object getItem(int position) {
        return mercados.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mercados.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = activity.getLayoutInflater().inflate(R.layout.item_mercado, parent, false);

        Mercado mercado = mercados.get(position);

        ImageView imagem = (ImageView) view.findViewById(R.id.item_mercado_imagem);

        if (mercado.getNome().equalsIgnoreCase("Hortifruti Fernanda")) {
            imagem.setImageResource(R.drawable.mercado_1);
        } else if(mercado.getNome().equalsIgnoreCase("Lola's Doces Artesanais")) {
            imagem.setImageResource(R.drawable.mercado_2);
        } else if(mercado.getNome().equalsIgnoreCase("Mark Mercado")) {
            imagem.setImageResource(R.drawable.mercado_3);
        } else if(mercado.getNome().equalsIgnoreCase("NoVo HoRiZonte Mercado")) {
            imagem.setImageResource(R.drawable.mercado_4);
        } else if(mercado.getNome().equalsIgnoreCase("Santista Mercado")) {
            imagem.setImageResource(R.drawable.mercado_5);
        }

        return view;
    }
}
