package br.com.comprex.comprex.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import br.com.comprex.comprex.R;
import br.com.comprex.comprex.adapter.ProdutoAdapter;
import br.com.comprex.comprex.dao.ProdutoDAO;
import br.com.comprex.comprex.dialog.QuantidadeProdutoDialogFragment;
import br.com.comprex.comprex.modelo.Lista;
import br.com.comprex.comprex.modelo.Produto;

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

                Produto produto = (Produto) parent.getItemAtPosition(position);

                DialogFragment dialogFragment = new QuantidadeProdutoDialogFragment();

                Bundle args = new Bundle();
                args.putSerializable("produto", produto);
                args.putSerializable("lista", lista);

                dialogFragment.setArguments(args);

                dialogFragment.show(getSupportFragmentManager(), "quantidade");
            }
        });

    }

    /**
     *
     */
    private void carregarLista() {
        ProdutoDAO produtoDAO = new ProdutoDAO(this);

        List<Produto> listaDeProdutos = produtoDAO.buscarTodos();

        listViewProdutos = (ListView) findViewById(R.id.lista_produtos);

        ProdutoAdapter produtoAdapter = new ProdutoAdapter(listaDeProdutos, this);

        listViewProdutos.setAdapter(produtoAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case  android.R.id.home:
                setResult(1, getIntent());
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
