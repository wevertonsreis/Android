package br.com.caelum.cadastro.aluno.helper;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;

import br.com.caelum.cadastro.aluno.activity.FormularioActivity;
import br.com.caelum.cadastro.aluno.model.Aluno;
import br.com.caelum.cadastrocaelum.R;

/**
 * Created by Weverton on 21/01/2016.
 */
public class FormularioHelper {

    private Aluno aluno;
    private ImageView foto;
    private EditText nome;
    private EditText site;
    private EditText endereco;
    private EditText telefone ;
    private SeekBar nota;

    /**
     *
     * @param activity
     */
    public FormularioHelper(FormularioActivity activity) {
        aluno = new Aluno();
        foto = (ImageView) activity.findViewById(R.id.foto);
        nome = (EditText) activity.findViewById(R.id.formulario_nome);
        site = (EditText) activity.findViewById(R.id.formulario_site);
        endereco = (EditText) activity.findViewById(R.id.formulario_endereco);
        telefone = (EditText) activity.findViewById(R.id.formulario_telefone);
        nota = (SeekBar) activity.findViewById(R.id.formulario_nota);
    }

    /**
     *
     * @return
     */
    public Aluno pegaAlunoDoFormulaorio(){
        aluno.setNome(nome.getText().toString());
        aluno.setSite(site.getText().toString());
        aluno.setEndereco(endereco.getText().toString());
        aluno.setTelefone(telefone.getText().toString());
        aluno.setNota(Double.valueOf(nota.getProgress()));
        return aluno;
    }

    /**
     *
     * @param alunoAlteracao
     */
    public void colocarAlunoNoFormulario(Aluno alunoAlteracao) {
        aluno = alunoAlteracao;
        nome.setText(alunoAlteracao.getNome());
        site.setText(alunoAlteracao.getSite());
        endereco.setText(alunoAlteracao.getEndereco());
        telefone.setText(alunoAlteracao.getTelefone());
        nota.setProgress(alunoAlteracao.getNota().intValue());

        if (aluno.getCaminhoFoto() != null) {
            carregaImagem(alunoAlteracao.getCaminhoFoto());
        }
    }

    /**
     *
     * @param caminhoDoArquivo
     */
    public void carregaImagem(String caminhoDoArquivo) {
        aluno.setCaminhoFoto(caminhoDoArquivo);

        Bitmap imagem = BitmapFactory.decodeFile(caminhoDoArquivo);
        Bitmap imagemReduzida = Bitmap.createScaledBitmap(imagem, 100, 100, true);

        foto.setImageBitmap(imagemReduzida);
    }

    public ImageView getFoto() {
        return foto;
    }
}
