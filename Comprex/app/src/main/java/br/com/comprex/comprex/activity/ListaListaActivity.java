package br.com.comprex.comprex.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.List;

import br.com.comprex.comprex.R;
import br.com.comprex.comprex.adapter.ListaAdapter;
import br.com.comprex.comprex.dao.ListaDAO;
import br.com.comprex.comprex.modelo.Lista;
import br.com.comprex.comprex.modelo.Mercado;

public class ListaListaActivity extends AppCompatActivity {

    private FloatingActionButton fab;
    private ListView listaDeLista;
    private ImageView imagemInformativa;
    private Mercado mercado;
    private List<Lista> listas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_lista);

        imagemInformativa = (ImageView) findViewById(R.id.lista_imagem_informativa);

        mercado = (Mercado) getIntent().getSerializableExtra("mercado");

        setTitle(mercado.getNome());

        Toolbar toolbar = (Toolbar) findViewById(R.id.lista_toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.lista_fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FormularioListaActivity formularioListaActivity = new FormularioListaActivity();

                Intent intentIrParaFormulario = new Intent(ListaListaActivity.this, FormularioListaActivity.class);
                intentIrParaFormulario.putExtra("mercado", mercado);
                startActivity(intentIrParaFormulario);

            }
        });

        listaDeLista = (ListView) findViewById(R.id.lista_listas);

        listaDeLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Lista lista = (Lista) parent.getItemAtPosition(position);

                Intent intentIrParaListaProduto = new Intent(ListaListaActivity.this, ListaProdutoListaActivity.class);
                intentIrParaListaProduto.putExtra("lista", lista);

                startActivity(intentIrParaListaProduto);
            }
        });

        carregarLista();
        atualizarVisibilidadeImagemInformativa();
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregarLista();
        atualizarVisibilidadeImagemInformativa();
    }

    /**
     *
     */
    private void carregarLista() {
        ListaDAO listaDAO = new ListaDAO(this);

        listas = listaDAO.buscarPorMercado(mercado);

        ListaAdapter listaAdapter = new ListaAdapter(listas, this);

        listaDeLista.setAdapter(listaAdapter);
    }

    /**
     *
     */
    private void atualizarVisibilidadeImagemInformativa() {
        if (!listas.isEmpty()) {
            imagemInformativa.setVisibility(View.INVISIBLE);
        }
    }

}
