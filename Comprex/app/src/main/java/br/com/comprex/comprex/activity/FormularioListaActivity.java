package br.com.comprex.comprex.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import br.com.comprex.comprex.R;
import br.com.comprex.comprex.dao.ListaDAO;
import br.com.comprex.comprex.helper.FormularioListaHelper;
import br.com.comprex.comprex.modelo.Lista;
import br.com.comprex.comprex.modelo.Mercado;

public class FormularioListaActivity extends AppCompatActivity {

    private FormularioListaHelper helper;

    private Mercado mercado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_lista);

        mercado = (Mercado) getIntent().getSerializableExtra("mercado");

        Toolbar toolbar = (Toolbar) findViewById(R.id.lista_toolbar);
        setSupportActionBar(toolbar);

        helper = new FormularioListaHelper(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_formulario_lista, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_ok:
                Lista lista = helper.getLista();
                lista.setSituacao("Aberta");
                lista.setMercado(mercado);

                ListaDAO dao = new ListaDAO(this);
                dao.inserir(lista);
                dao.close();

                Toast.makeText(this, "Lista criada com sucesso", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}