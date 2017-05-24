package br.com.comprex.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import br.com.compras.compras.R;
import br.com.comprex.adapter.ListaAdapter;
import br.com.comprex.dao.ListaDAO;
import br.com.comprex.modelo.Lista;

public class ListaListaActivity extends AppCompatActivity {

    private FloatingActionButton fab;
    private ListView listaDeLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_lista);

        Toolbar toolbar = (Toolbar) findViewById(R.id.lista_toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.lista_fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FormularioListaActivity formularioListaActivity = new FormularioListaActivity();

                Intent intentIrParaFormulario = new Intent(ListaListaActivity.this, FormularioListaActivity.class);
                startActivity(intentIrParaFormulario);

            }
        });

        listaDeLista = (ListView) findViewById(R.id.lista_listas);

        listaDeLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Lista lista = (Lista) parent.getItemAtPosition(position);

                Intent intentIrParaListaProduto = new Intent(ListaListaActivity.this, FormularioListaProdutoActivity.class);
                intentIrParaListaProduto.putExtra("lista", lista);

                startActivity(intentIrParaListaProduto);
            }
        });

        carregarLista();

    }

    @Override
    protected void onResume() {
        super.onResume();

        carregarLista();
    }

    private void carregarLista() {
        ListaDAO listaDAO = new ListaDAO(this);

        List<Lista> listas = listaDAO.buscarTodas();

        ListaAdapter listaAdapter = new ListaAdapter(listas, this);

        listaDeLista.setAdapter(listaAdapter);
    }
}
