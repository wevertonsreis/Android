package br.com.comprex.comprex.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

import br.com.comprex.comprex.R;
import br.com.comprex.comprex.adapter.ProdutoListaAdapter;
import br.com.comprex.comprex.dao.ProdutoListaDAO;
import br.com.comprex.comprex.modelo.Lista;
import br.com.comprex.comprex.modelo.ProdutoLista;

public class ListaProdutoListaActivity extends AppCompatActivity {

    private DecimalFormat format = new DecimalFormat("#,##0.00");

    private FloatingActionButton fab;
    private ListView listViewProdutoLista;
    private ImageView imagemInformativa;
    private TextView textViewTotal;
    private Lista lista;
    private List<ProdutoLista> listaDeProdutoLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_produto_lista);

        imagemInformativa = (ImageView) findViewById(R.id.lista_produto_imagem_informativa);
        textViewTotal = (TextView) findViewById(R.id.lista_produto_total);

        Toolbar toolbar = (Toolbar) findViewById(R.id.lista_produto_lista_toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        lista = (Lista) getIntent().getSerializableExtra("lista");

        setTitle(lista.getNome());

        fab = (FloatingActionButton) findViewById(R.id.lista_produto_lista_fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentIrParaFormulario = new Intent(ListaProdutoListaActivity.this, ListaProdutoMercadoActivity.class);
                intentIrParaFormulario.putExtra("lista", lista);
                startActivityForResult(intentIrParaFormulario, 1);

            }
        });

        listViewProdutoLista = (ListView) findViewById(R.id.lista_produto_lista_lista);

        carregarLista();
        atualizarVisibilidadeImagemInformativa();
        atualizarTotal();
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

    private void atualizarTotal() {
        if (listaDeProdutoLista != null && !listaDeProdutoLista.isEmpty()) {

            Double total = 0.00;
            for (ProdutoLista produto: listaDeProdutoLista) {
                total += produto.getValor();
            }

            textViewTotal.setText("Total: R$ " + format.format(total));

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_formulario_produto_lista, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if (data != null) {
                lista = (Lista) data.getSerializableExtra("lista");
            }
        }

        carregarLista();
        atualizarVisibilidadeImagemInformativa();
        atualizarTotal();

        super.onActivityResult(requestCode, resultCode, data);
    }

    /**
     *
     */
    private void carregarLista() {
        ProdutoListaDAO produtoListaDAO = new ProdutoListaDAO(this);

        listaDeProdutoLista = produtoListaDAO.buscarPorLista(lista);

        ProdutoListaAdapter produtoListaAdapter = new ProdutoListaAdapter(listaDeProdutoLista, this);

        listViewProdutoLista.setAdapter(produtoListaAdapter);
    }

    /**
     *
     */
    private void atualizarVisibilidadeImagemInformativa() {
        if (!listaDeProdutoLista.isEmpty()) {
            imagemInformativa.setVisibility(View.INVISIBLE);
        }
    }

}
