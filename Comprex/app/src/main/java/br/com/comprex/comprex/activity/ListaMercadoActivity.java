package br.com.comprex.comprex.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import br.com.comprex.comprex.R;
import br.com.comprex.comprex.adapter.MercadoAdapter;
import br.com.comprex.comprex.dao.MercadoDAO;
import br.com.comprex.comprex.modelo.Mercado;

/**
 * Controla as acoes activity_lista_mercado
 */
public class ListaMercadoActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView listViewDeMercado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_mercado);

        carregarViews();

        setSupportActionBar(toolbar);

        carregarLista();

        listViewDeMercado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Mercado mercado = (Mercado) parent.getItemAtPosition(position);

                Intent intentIrParaListaDeLista = new Intent(ListaMercadoActivity.this, ListaListaActivity.class);
                intentIrParaListaDeLista.putExtra("mercado", mercado);

                startActivity(intentIrParaListaDeLista);
            }
        });

    }

    /**
     * Carrega os componentes do layout
     */
    private void carregarViews() {
        toolbar = (Toolbar) findViewById(R.id.lista_mercado_toolbar);
        listViewDeMercado = (ListView) findViewById(R.id.lista_mercado_lista);
    }

    /**
     * Carrega a lista de mercado
     */
    private void carregarLista() {
        MercadoDAO mercadoDAO = new MercadoDAO(this);

        List<Mercado> mercados = mercadoDAO.buscarTodas();

        MercadoAdapter mercadoAdapter = new MercadoAdapter(mercados, this);

        listViewDeMercado.setAdapter(mercadoAdapter);
    }

}
