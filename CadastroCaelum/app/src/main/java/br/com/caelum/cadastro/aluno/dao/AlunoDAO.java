package br.com.caelum.cadastro.aluno.dao;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.cadastro.comum.helper.DBHelper;
import br.com.caelum.cadastro.aluno.model.Aluno;

/**
 * Created by Weverton on 21/01/2016.
 */
public class AlunoDAO {

    public static final String TABELA_ALUNOS = "Alunos";

    private final DBHelper dbHelper;

    public AlunoDAO(DBHelper dbHelper) {
        this.dbHelper = dbHelper;
    }

    /**
     *
     * @param aluno
     */
    public void insere(Aluno aluno) {
        ContentValues cv = toContentValues(aluno);
        dbHelper.getWritableDatabase().insert(TABELA_ALUNOS, null, cv);
    }

    public List<Aluno> getLista() {
        StringBuilder qb = new StringBuilder("SELECT * FROM "+ TABELA_ALUNOS +";");

        Cursor cursor = dbHelper.getReadableDatabase().rawQuery(qb.toString(), null);

        List<Aluno> alunos = new ArrayList<Aluno>();
        while (cursor.moveToNext()){
            Aluno aluno = new Aluno();
            aluno.setId(cursor.getLong(cursor.getColumnIndex("id")));
            aluno.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            aluno.setTelefone(cursor.getString(cursor.getColumnIndex("telefone")));
            aluno.setEndereco(cursor.getString(cursor.getColumnIndex("endereco")));
            aluno.setSite(cursor.getString(cursor.getColumnIndex("site")));
            aluno.setNota(cursor.getDouble(cursor.getColumnIndex("nota")));
            aluno.setCaminhoFoto(cursor.getString(cursor.getColumnIndex("caminhoFoto")));

            alunos.add(aluno);

        }

        return alunos;
    }

    public void close() {
        dbHelper.close();
    }

    /**
     *
     * @param alunoSelecionado Aluno a ser deletado
     */
    public void deletar(Aluno alunoSelecionado) {
        String[] parametros = {alunoSelecionado.getId().toString()};
        dbHelper.getWritableDatabase().delete(TABELA_ALUNOS, "id=?", parametros);
    }

    /**
     *
     * @param alunoAlteracao Aluno a ser atualizado
     */
    public void atualiza(Aluno alunoAlteracao) {
        ContentValues cv = toContentValues(alunoAlteracao);
        String[] parametros = {alunoAlteracao.getId().toString()};
        dbHelper.getWritableDatabase().update(TABELA_ALUNOS, cv, "id=?", parametros);
    }

    /**
     * Verifica se o telefone é do aluno
     *
     * @param mensagem
     * @return
     */
    public boolean isAluno(String telefone) {
        String []args = {telefone};
        Cursor rowQuery = dbHelper.getReadableDatabase().rawQuery("SELECT telefone FROM " + TABELA_ALUNOS + " WHERE telefone = ?", args);
        int total = rowQuery.getCount();
        return total > 0;
    }

    /**
     *
     * @param aluno
     * @return
     */
    private ContentValues toContentValues(Aluno aluno) {
        ContentValues cv = new ContentValues();
        cv.put("nome", aluno.getNome());
        cv.put("telefone", aluno.getTelefone());
        cv.put("endereco", aluno.getEndereco());
        cv.put("site", aluno.getSite());
        cv.put("nota", aluno.getNota());
        cv.put("caminhoFoto", aluno.getCaminhoFoto());
        return cv;
    }

}
