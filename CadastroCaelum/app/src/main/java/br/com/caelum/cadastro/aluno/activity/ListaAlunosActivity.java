package br.com.caelum.cadastro.aluno.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import br.com.caelum.cadastro.aluno.activity.listener.ListaOnItemClickListener;
import br.com.caelum.cadastro.aluno.activity.listener.ListaOnItemLongClickListener;
import br.com.caelum.cadastro.aluno.adapter.AlunoAdapter;
import br.com.caelum.cadastro.aluno.converter.AlunoConverter;
import br.com.caelum.cadastro.aluno.dao.AlunoDAO;
import br.com.caelum.cadastro.comum.Extras;
import br.com.caelum.cadastro.comum.helper.DBHelper;
import br.com.caelum.cadastro.aluno.model.Aluno;
import br.com.caelum.cadastrocaelum.R;

public class ListaAlunosActivity extends AppCompatActivity {

    private ListView lista;
    private Aluno alunoSelecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listagem_alunos);

        lista = (ListView) findViewById(R.id.lista);

        registerForContextMenu(lista);

        lista.setOnItemClickListener(new ListaOnItemClickListener(this));
        lista.setOnItemLongClickListener(new ListaOnItemLongClickListener(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_novo:
                Intent irParaOFormulario = new Intent(this, FormularioActivity.class);
                startActivity(irParaOFormulario);
                return false;
            case R.id.menu_enviar_alunos:
                DBHelper dbHelper = new DBHelper(this);
                AlunoDAO alunoDAO = new AlunoDAO(dbHelper);
                List<Aluno> listaDeAlunos = alunoDAO.getLista();
                alunoDAO.close();
                String json = new AlunoConverter().toJSON(listaDeAlunos);

                Toast.makeText(this, json, Toast.LENGTH_LONG).show();
                return false;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregaLista();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        final MenuItem ligar = menu.add("Ligar");
        ligar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intentLigar = new Intent(Intent.ACTION_CALL);
                intentLigar.setData(Uri.parse("tel:" + alunoSelecionado.getTelefone()));
                ligar.setIntent(intentLigar);
                return false;
            }
        });

        final MenuItem enviarSMS = menu.add("Enviar SMS");
        enviarSMS.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intentEnviarSMS = new Intent(Intent.ACTION_VIEW);
                intentEnviarSMS.setData(Uri.parse("sms:"+alunoSelecionado.getNota()));
                intentEnviarSMS.putExtra("sms_body", "Menssagem");
                enviarSMS.setIntent(intentEnviarSMS);
                return false;
            }
        });

        final MenuItem acharNoMapa = menu.add("Achar no Mapa");
        acharNoMapa.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intentAcharNoMapa = new Intent(Intent.ACTION_VIEW);
                intentAcharNoMapa.setData(Uri.parse("geo:0,0?z=14&q=" + alunoSelecionado.getEndereco()));
                acharNoMapa.setIntent(intentAcharNoMapa);
                return false;
            }
        });

        final MenuItem navegarNoSite = menu.add("Navegar no Site");
        navegarNoSite.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intentVerSite = new Intent(ListaAlunosActivity.this, VerSite.class);
                intentVerSite.putExtra(Extras.URL_SITE.toString(), alunoSelecionado.getSite());
                navegarNoSite.setIntent(intentVerSite);
                return false;
            }
        });

        final MenuItem deletar = menu.add("Deletar");
        deletar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                DBHelper dbHelper = new DBHelper(ListaAlunosActivity.this);
                AlunoDAO alunoDAO = new AlunoDAO(dbHelper);
                alunoDAO.deletar(alunoSelecionado);
                alunoDAO.close();
                carregaLista();
                Toast.makeText(ListaAlunosActivity.this, "Aluno deletado com sucesso", Toast.LENGTH_SHORT).show();
                return false;
            }

        });

        final MenuItem enviarEmal = menu.add("Enviar E-mail");
        enviarEmal.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intentEnviarEmail = new Intent(Intent.ACTION_SEND);
                intentEnviarEmail.setType("message/rfc822");
                intentEnviarEmail.putExtra(Intent.EXTRA_EMAIL, "weverton.sant.reis@gmail.com");
                intentEnviarEmail.putExtra(Intent.EXTRA_SUBJECT, "Isso é o assunto");
                intentEnviarEmail.putExtra(Intent.EXTRA_TEXT, "Isso é o conteudo do email");
                enviarEmal.setIntent(intentEnviarEmail);
                startActivity(Intent.createChooser(intentEnviarEmail, "Selecione sua aplicação de e-mail"));
                return false;
            }
        });

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    /**
     *
     */
    private void carregaLista() {
        DBHelper dbHelper = new DBHelper(this);
        AlunoDAO alunoDAO = new AlunoDAO(dbHelper);
        List<Aluno> alunos = alunoDAO.getLista();

        AlunoAdapter alunoAdapter = new AlunoAdapter(alunos, this);

        lista.setAdapter(alunoAdapter);
    }

    public Aluno getAlunoSelecionado() {
        return alunoSelecionado;
    }

    public void setAlunoSelecionado(Aluno alunoSelecionado) {
        this.alunoSelecionado = alunoSelecionado;
    }

}
