package br.com.agenda.agenda;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListaAlunosActivity extends AppCompatActivity {

    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        String[] alunos = {"Daniel", "Ronaldo", "Jeferson", "Felipe"};

        ListView listaAlunos = (ListView) findViewById(R.id.lista_alunos);

        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, alunos);

        listaAlunos.setAdapter(adapter);

        fab = (FloatingActionButton) findViewById(R.id.formulario_fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FormularioActivity formulario = new FormularioActivity();

                Intent itentIrParaFormulario = new Intent(ListaAlunosActivity.this, FormularioActivity.class);
                startActivity(itentIrParaFormulario);
            }
        });

    }

}
