package br.com.comprex.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import br.com.compras.compras.R;
import br.com.comprex.adapter.ProdutoAdapter;
import br.com.comprex.dao.CategoriaDAO;
import br.com.comprex.dao.ProdutoDAO;
import br.com.comprex.dao.ProdutoListaDAO;
import br.com.comprex.modelo.Lista;
import br.com.comprex.modelo.Produto;
import br.com.comprex.modelo.ProdutoLista;

/**
 * Classe responsavel por controlar as acoes da tela de lista de produtos
 */
public class ListaProdutoActivity extends AppCompatActivity {

    private ListView listViewProdutos;

    private Lista lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_produto);

        Toolbar toolbar = (Toolbar) findViewById(R.id.lista_produtos_toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();

        actionBar.setDisplayHomeAsUpEnabled(true);

        carregarLista();

        final Intent intent = getIntent();

        lista = (Lista) intent.getSerializableExtra("lista");

        listViewProdutos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ProdutoLista produtoLista = new ProdutoLista();

                Produto produto = (Produto) parent.getItemAtPosition(position);

                produtoLista.setProduto(produto);
                produtoLista.setLista(lista);

                ProdutoListaDAO produtoListaDAO = new ProdutoListaDAO(ListaProdutoActivity.this);
                produtoListaDAO.inserir(produtoLista);

                setResult(1, intent);
                finish();

            }
        });

    }

    /**
     *
     */
    private void carregarLista() {
        CategoriaDAO categoriaDAO = new CategoriaDAO(this);

        ProdutoDAO produtoDAO = new ProdutoDAO(this);

        List<Produto> listaDeProdutos = produtoDAO.buscarTodos();

        listViewProdutos = (ListView) findViewById(R.id.lista_produtos);

        ProdutoAdapter produtoAdapter = new ProdutoAdapter(listaDeProdutos, this);

       // ArrayAdapter<Produto> adapter = new ArrayAdapter<Produto>(this, android.R.layout.simple_list_item_1, listaDeProdutos);

        listViewProdutos.setAdapter(produtoAdapter);
    }

}
