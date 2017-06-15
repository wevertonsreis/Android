package br.com.comprex.comprex.activity;

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
import br.com.comprex.comprex.adapter.ProdutoMercadoAdapter;
import br.com.comprex.comprex.dao.ProdutoMercadoDAO;
import br.com.comprex.comprex.dialog.QuantidadeProdutoDialogFragment;
import br.com.comprex.comprex.modelo.Lista;
import br.com.comprex.comprex.modelo.Produto;
import br.com.comprex.comprex.modelo.ProdutoMercado;

public class ListaProdutoMercadoActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView listViewProdutoMercado;
    private Lista lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_produto_mercado);
        setTitle("Produtos do Mercado");

        toolbar = (Toolbar) findViewById(R.id.lista_produtos_toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        lista = (Lista) getIntent().getSerializableExtra("lista");

        carregarLista();

        listViewProdutoMercado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ProdutoMercado produtoMercado = (ProdutoMercado) parent.getItemAtPosition(position);

                DialogFragment dialogFragment = new QuantidadeProdutoDialogFragment();

                Bundle args = new Bundle();
                args.putSerializable("produtoMercado", produtoMercado);
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
        ProdutoMercadoDAO produtoMercadoDAO = new ProdutoMercadoDAO(this);

        List<ProdutoMercado> listaDeProdutoMercado = produtoMercadoDAO.buscarPorMercado(lista.getMercado());

        listViewProdutoMercado = (ListView) findViewById(R.id.lista_produtos);

        ProdutoMercadoAdapter produtoAdapter = new ProdutoMercadoAdapter(listaDeProdutoMercado, this);

        listViewProdutoMercado.setAdapter(produtoAdapter);
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
