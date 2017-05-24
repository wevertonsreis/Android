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
import br.com.comprex.modelo.ProdutoLista;

public class ProdutoListaAdapter extends BaseAdapter {

    private DecimalFormat format = new DecimalFormat("#,##0.00");

    private final List<ProdutoLista> produtosLista;
    private final Activity activity;

    public ProdutoListaAdapter(List<ProdutoLista> produtosLista, Activity activity) {
        this.produtosLista = produtosLista;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return produtosLista.size();
    }

    @Override
    public Object getItem(int position) {
        return produtosLista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return produtosLista.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = activity.getLayoutInflater().inflate(R.layout.activity_item_produto, parent, false);

        ProdutoLista produtoLista = produtosLista.get(position);

        TextView nome = (TextView) view.findViewById(R.id.lista_curso_personalizada_nome);
        TextView descricao = (TextView) view.findViewById(R.id.lista_curso_personalizada_descricao);
        ImageView imagem = (ImageView) view.findViewById(R.id.lista_curso_personalizada_imagem);

        Produto produto = produtoLista.getProduto();

        nome.setText(produto.getNome());
        descricao.setText("R$ " + format.format(produto.getPreco()));

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
