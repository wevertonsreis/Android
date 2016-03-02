package br.com.caelum.cadastro.comum.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import br.com.caelum.cadastro.aluno.dao.AlunoDAO;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE = "CadastroCaelum";
    private static final int VERSAO = 1;

    /**
     *
     * @param context
     */
    public DBHelper(Context context) {
        super(context, DATABASE, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        StringBuilder builderQuery = new StringBuilder();
        builderQuery.append("CREATE TABLE " + AlunoDAO.TABELA_ALUNOS + " ( ");
        builderQuery.append("id INTEGER PRIMARY KEY, ");
        builderQuery.append("nome TEXT NOT NULL, ");
        builderQuery.append("telefone TEXT, ");
        builderQuery.append("endereco TEXT, ");
        builderQuery.append("site TEXT, ");
        builderQuery.append("nota REAL, ");
        builderQuery.append("caminhoFoto TEXT ); ");
        db.execSQL(builderQuery.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS " + AlunoDAO.TABELA_ALUNOS +";";
        db.execSQL(sql);
        onCreate(db);
    }
}
