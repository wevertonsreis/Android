package br.com.comprex.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;

import br.com.compras.compras.R;
import br.com.comprex.modelo.Produto;

public class ProdutoAdapter extends BaseAdapter {

    private DecimalFormat format = new DecimalFormat("#,##0.00");

    private final List<Produto> produtos;
    private final Activity activity;

    public ProdutoAdapter(List<Produto> produtos, Activity activity) {
        this.produtos = produtos;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return produtos.size();
    }

    @Override
    public Object getItem(int position) {
        return produtos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return produtos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = activity.getLayoutInflater().inflate(R.layout.activity_item_produto, parent, false);

        Produto produto = produtos.get(position);

        //pegando as referências das Views
        TextView nome = (TextView)
                view.findViewById(R.id.lista_curso_personalizada_nome);
        TextView descricao = (TextView)
                view.findViewById(R.id.lista_curso_personalizada_descricao);
        ImageView imagem = (ImageView)
                view.findViewById(R.id.lista_curso_personalizada_imagem);

        //populando as Views
        nome.setText(produto.getNome());


        descricao.setText("R$ " + format.format(produto.getPreco()) );

        if (produto.getNome().equalsIgnoreCase("melancia")) {
            imagem.setImageResource(R.drawable.produto_melancia);
        }else if(produto.getNome().equalsIgnoreCase("morango")) {
            imagem.setImageResource(R.drawable.produto_morango);
        }else if(produto.getNome().equalsIgnoreCase("banana")) {
            imagem.setImageResource(R.drawable.produto_banana);
        }else if(produto.getNome().equalsIgnoreCase("uva")) {
            imagem.setImageResource(R.drawable.produto_uva);
        }else if(produto.getNome().equalsIgnoreCase("abacaxi")) {
            imagem.setImageResource(R.drawable.produto_abacaxi);
        }else if(produto.getNome().equalsIgnoreCase("melão")) {
            imagem.setImageResource(R.drawable.produto_melao);
        }else if(produto.getNome().equalsIgnoreCase("maça")) {
            imagem.setImageResource(R.drawable.produto_maca);
        }

        return view;

    }

}
