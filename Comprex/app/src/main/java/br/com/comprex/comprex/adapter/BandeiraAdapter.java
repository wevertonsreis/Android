package br.com.comprex.comprex.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.comprex.comprex.R;
import br.com.comprex.comprex.modelo.Bandeira;

public class BandeiraAdapter extends BaseAdapter {

    private Bandeira[] bandeiras = Bandeira.values();

    private Activity activity;

    public BandeiraAdapter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return bandeiras.length;
    }

    @Override
    public Object getItem(int position) {
        return bandeiras[position];
    }

    @Override
    public long getItemId(int position) {
        return bandeiras[position].getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = activity.getLayoutInflater().inflate(R.layout.item_bandeira, parent, false);

        Bandeira bandeira = bandeiras[position];

        TextView nome = (TextView) view.findViewById(R.id.item_bandeira_nome);
        ImageView imagem = (ImageView) view.findViewById(R.id.item_bandeira_imagem);

        nome.setText(bandeira.getDescricao());

        if (bandeira.getId().equals(1L)) {
            imagem.setImageResource(R.drawable.bandeira_visa);
        } else {
            imagem.setImageResource(R.drawable.bandeira_mastercard);
        }

        return view;
    }
}
