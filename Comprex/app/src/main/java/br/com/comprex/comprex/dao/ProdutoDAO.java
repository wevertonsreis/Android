package br.com.comprex.comprex.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.comprex.comprex.modelo.Produto;

public class ProdutoDAO {

    private DAOHelper daoHelper;

    public ProdutoDAO(Context context) {
        daoHelper = new DAOHelper(context);
    }

    public List<Produto> buscarTodos() {
        String sql = "SELECT * FROM Produtos p";

        SQLiteDatabase database = daoHelper.getReadableDatabase();

        Cursor cursor = database.rawQuery(sql, null);

        List<Produto> listaDeProdutos = new ArrayList<>();

        while (cursor.moveToNext()) {
            Produto produto = new Produto();
            produto.setId(cursor.getLong(cursor.getColumnIndex("id")));
            produto.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            listaDeProdutos.add(produto);
        }

        cursor.close();

        return listaDeProdutos;
    }
}
