package br.com.caelum.cadastro.aluno.task;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.util.List;

import br.com.caelum.cadastro.aluno.converter.AlunoConverter;
import br.com.caelum.cadastro.aluno.dao.AlunoDAO;
import br.com.caelum.cadastro.aluno.model.Aluno;
import br.com.caelum.cadastro.comum.helper.DBHelper;
import br.com.caelum.cadastro.support.WebClient;

/**
 * Created by Weverton on 01/03/2016.
 */
public class EnviaAlunosTask extends AsyncTask<Object, Object, String> {

    private static final String endereco = "http://www.caelum.com.br/mobile";

    private Context context;
    private ProgressDialog progressDialog;
    /**
     *
     * @param context
     */
    public EnviaAlunosTask(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        progressDialog = ProgressDialog.show(context,"Aguarde...", "Sincronizando alunos", true, true);
    }

    @Override
    protected String doInBackground(Object... params) {
        DBHelper dbHelper = new DBHelper(context);
        AlunoDAO alunoDAO = new AlunoDAO(dbHelper);
        List<Aluno> listaDeAlunos = alunoDAO.getLista();
        alunoDAO.close();
        String json = new AlunoConverter().toJSON(listaDeAlunos);

        WebClient webClient = new WebClient(endereco);
        return webClient.post(json);
    }

    @Override
    protected void onPostExecute(String s) {
        progressDialog.dismiss();
        Toast.makeText(context, s, Toast.LENGTH_LONG).show();
    }
}
