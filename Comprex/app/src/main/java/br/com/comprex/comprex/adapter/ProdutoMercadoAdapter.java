package br.com.comprex.comprex.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;

import br.com.comprex.comprex.R;
import br.com.comprex.comprex.modelo.Produto;
import br.com.comprex.comprex.modelo.ProdutoMercado;

public class ProdutoMercadoAdapter extends BaseAdapter {

    private DecimalFormat format = new DecimalFormat("#,##0.00");

    private final List<ProdutoMercado> listaDeProdutoMercado;
    private final Activity activity;

    public ProdutoMercadoAdapter(List<ProdutoMercado> listaDeProdutoMercado, Activity activity) {
        this.listaDeProdutoMercado = listaDeProdutoMercado;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return listaDeProdutoMercado.size();
    }

    @Override
    public Object getItem(int position) {
        return listaDeProdutoMercado.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listaDeProdutoMercado.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = activity.getLayoutInflater().inflate(R.layout.item_produto_mercado, parent, false);

        ProdutoMercado produtoMercado = listaDeProdutoMercado.get(position);

        TextView nome = (TextView) view.findViewById(R.id.item_produto_mercado_nome);
        TextView descricao = (TextView) view.findViewById(R.id.item_produto_mercado_descricao);
        ImageView imagem = (ImageView) view.findViewById(R.id.item_produto_mercado_imagem);

        Produto produto = produtoMercado.getProduto();

        nome.setText(produto.getNome());
        descricao.setText("R$ " + format.format(produtoMercado.getPreco()));

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
        }else if(produto.getNome().equalsIgnoreCase("Brigadeiro Tradicional (20gr)")) {
            imagem.setImageResource(R.drawable.produto_brigadeiro);
        }else if(produto.getNome().equalsIgnoreCase("Linha gourmet (Paçoca, prestígio) (20gr)")) {
            imagem.setImageResource(R.drawable.produto_passoca);
        }else if(produto.getNome().equalsIgnoreCase("Morango (40 gr)")) {
            imagem.setImageResource(R.drawable.produto_morando_chocolate);
        }else if(produto.getNome().equalsIgnoreCase("Doce de abóbora (40 gr)")) {
            imagem.setImageResource(R.drawable.produto_doceabobora);
        }else if(produto.getNome().equalsIgnoreCase("Arroz")) {
            imagem.setImageResource(R.drawable.produto_arroz);
        }else if(produto.getNome().equalsIgnoreCase("Bolacha")) {
            imagem.setImageResource(R.drawable.produto_bolacha);
        }else if(produto.getNome().equalsIgnoreCase("Bolacha Recheada")) {
            imagem.setImageResource(R.drawable.produto_bolacha_recheada);
        }else if(produto.getNome().equalsIgnoreCase("Cereal")) {
            imagem.setImageResource(R.drawable.produto_cereal);
        }else if(produto.getNome().equalsIgnoreCase("Cerveja")) {
            imagem.setImageResource(R.drawable.produto_cerveja);
        }else if(produto.getNome().equalsIgnoreCase("Chocolate")) {
            imagem.setImageResource(R.drawable.produto_chocolate);
        }else if(produto.getNome().equalsIgnoreCase("Danone")) {
            imagem.setImageResource(R.drawable.produto_danone);
        }else if(produto.getNome().equalsIgnoreCase("Dolly")) {
            imagem.setImageResource(R.drawable.produto_dolly);
        }

        return view;

    }

}
