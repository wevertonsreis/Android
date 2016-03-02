package br.com.caelum.cadastro.aluno.activity.listener;

import android.util.Log;
import android.view.View;

import br.com.caelum.cadastro.aluno.activity.FormularioActivity;
import br.com.caelum.cadastro.aluno.dao.AlunoDAO;
import br.com.caelum.cadastro.comum.helper.DBHelper;
import br.com.caelum.cadastro.aluno.model.Aluno;

public class BotaoSalvarOnClickListener implements View.OnClickListener {

    private FormularioActivity formularioActivity;

    public BotaoSalvarOnClickListener(FormularioActivity formularioActivity) {
        this.formularioActivity = formularioActivity;
    }

    @Override
    public void onClick(View v) {
        Log.i("EVENTO CLICK", "CLICANDO");
        Aluno aluno = formularioActivity.getFormularioHelper().pegaAlunoDoFormulaorio();
        DBHelper dbHelper = new DBHelper(formularioActivity);
        AlunoDAO dao = new AlunoDAO(dbHelper);

        aluno.setId(formularioActivity.getAluno().getId());
        if (aluno.getId() != null) {
            dao.atualiza(aluno);
        } else {
            dao.insere(aluno);
        }
        dao.close();
        formularioActivity.finish();
    }

}
