package br.com.comprex.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import br.com.compras.compras.R;
import br.com.comprex.adapter.ProdutoListaAdapter;
import br.com.comprex.dao.ListaDAO;
import br.com.comprex.dao.ProdutoListaDAO;
import br.com.comprex.modelo.Lista;
import br.com.comprex.modelo.ProdutoLista;

public class FormularioListaProdutoActivity extends AppCompatActivity {

    private FloatingActionButton fab;

    private Lista lista;

    private List<ProdutoLista> listaDeProdutoLista;

    private ListView listViewProdutoLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_lista_produto);

        Toolbar toolbar = (Toolbar) findViewById(R.id.formulario_lista_produto_toolbar);
        setSupportActionBar(toolbar);

        final ActionBar actionBar = getSupportActionBar();

        actionBar.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();

        lista = (Lista) intent.getSerializableExtra("lista");

        //TODO DEPOIS ARRUMAR ISSO
        if (lista != null)
            setTitle(lista.getNome());

        fab = (FloatingActionButton) findViewById(R.id.formulario_lista_produto_fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FormularioListaActivity formularioListaActivity = new FormularioListaActivity();

                Intent intentIrParaFormulario = new Intent(FormularioListaProdutoActivity.this, ListaProdutoActivity.class);
                intentIrParaFormulario.putExtra("lista", lista);
                startActivityForResult(intentIrParaFormulario, 1);

            }
        });

        listViewProdutoLista = (ListView) findViewById(R.id.formulario_lista_produto_lista);


        carregarLista();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            lista = (Lista) data.getSerializableExtra("lista");
        }

        carregarLista();

        super.onActivityResult(requestCode, resultCode, data);
    }

    /**
     *
     */
    private void carregarLista() {
        ProdutoListaDAO produtoListaDAO = new ProdutoListaDAO(this);

        List<ProdutoLista> listaDeProdutoLista = produtoListaDAO.buscarPorLista(lista);

        ProdutoListaAdapter produtoListaAdapter = new ProdutoListaAdapter(listaDeProdutoLista, this);

        listViewProdutoLista.setAdapter(produtoListaAdapter);
    }

}
