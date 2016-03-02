package br.com.caelum.cadastro.aluno.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;

import br.com.caelum.cadastro.comum.Extras;
import br.com.caelum.cadastro.aluno.activity.listener.BotaoSalvarOnClickListener;
import br.com.caelum.cadastro.aluno.model.Aluno;
import br.com.caelum.cadastro.aluno.helper.FormularioHelper;
import br.com.caelum.cadastrocaelum.R;

public class FormularioActivity extends AppCompatActivity {

    private static final int TIRA_FOTO = 123;

    private FormularioHelper formularioHelper;
    private Aluno aluno;
    private String caminhoDoArquivo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulario);
        formularioHelper = new FormularioHelper(this);

        aluno = (Aluno) getIntent().getSerializableExtra(Extras.ALUNO_SELECIONADO.name());

        Button botao = (Button) findViewById(R.id.formulario_botao_inserir);


        if (aluno != null) {
            formularioHelper.colocarAlunoNoFormulario(aluno);
            botao.setText("Alterar");
        } else {
            aluno = new Aluno();
        }

        botao.setOnClickListener(new BotaoSalvarOnClickListener(this));

        ImageView foto = formularioHelper.getFoto();
        foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caminhoDoArquivo = getExternalFilesDir(null) + "/" + System.currentTimeMillis() + ".png";
                File arquivo = new File(caminhoDoArquivo);

                Intent intentCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                intentCamera.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(arquivo));
                startActivityForResult(intentCamera, TIRA_FOTO);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == TIRA_FOTO) {
            if (resultCode == Activity.RESULT_OK) {
                formularioHelper.carregaImagem(caminhoDoArquivo);
            } else {
                caminhoDoArquivo = null;
            }
        }

    }

    public FormularioHelper getFormularioHelper() {
        return formularioHelper;
    }

    public Aluno getAluno() {
        return aluno;
    }
}
