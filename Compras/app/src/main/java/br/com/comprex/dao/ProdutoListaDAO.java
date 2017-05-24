package br.com.comprex.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;

import br.com.comprex.modelo.Lista;
import br.com.comprex.modelo.Produto;
import br.com.comprex.modelo.ProdutoLista;

public class ProdutoListaDAO {

    private DAOHelper daoHelper;

    public ProdutoListaDAO(Context context) {
        daoHelper = new DAOHelper(context);
    }

    /**
     *
     * @param produtoLista
     */
    public void inserir(ProdutoLista produtoLista) {
        SQLiteDatabase writableDatabase = daoHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("Lista_id", produtoLista.getLista().getId());
        values.put("Produto_id", produtoLista.getProduto().getId());

        writableDatabase.insert("Listas_Produtos", null, values);
    }

    /**
     *
     * @param lista
     * @return
     */
    public List<ProdutoLista> buscarPorLista(Lista lista) {

        String sql =
                "SELECT * FROM Listas_Produtos lp " +
                "INNER JOIN Produtos p ON p.id = lp.Produto_id " +
                "WHERE lp.Lista_id = ? ";

        String[] argumentos = {
                lista.getId().toString()
        };

        SQLiteDatabase database = daoHelper.getReadableDatabase();

        Cursor cursor = database.rawQuery(sql, argumentos);

        List<ProdutoLista> listas = new ArrayList<>();

        while (cursor.moveToNext()) {
            ProdutoLista produtoLista = new ProdutoLista();
            produtoLista.setId(cursor.getLong(cursor.getColumnIndex("id")));

            Produto produto = new Produto();
            produto.setId(cursor.getLong(cursor.getColumnIndex("Produto_id")));
            produto.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            produto.setPreco(cursor.getDouble(cursor.getColumnIndex("preco")));

            produtoLista.setLista(lista);
            produtoLista.setProduto(produto);

            listas.add(produtoLista);
        }

        return listas;

    }
}
