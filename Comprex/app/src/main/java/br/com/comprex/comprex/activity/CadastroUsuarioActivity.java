package br.com.comprex.comprex.activity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import br.com.comprex.comprex.R;
import br.com.comprex.comprex.adapter.BandeiraAdapter;
import br.com.comprex.comprex.helper.CadastroUsuarioHelper;

/**
 * Controla as acoes da activity_cadastro_usuario
 */
public class CadastroUsuarioActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private CadastroUsuarioHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);
        setTitle("Cadastro de Usuário");

        helper = new CadastroUsuarioHelper(this);

        toolbar = (Toolbar) findViewById(R.id.cadastro_usuario_toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        BandeiraAdapter bandeiraAdapter = new BandeiraAdapter(this);

        helper.getCampoBandeiraCartao().setAdapter(bandeiraAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_cadastro_usuario, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.cadastro_usuario_botao_ok:
                Toast.makeText(this, "Usuário cadastrado com sucesso", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
