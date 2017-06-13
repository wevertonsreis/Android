package br.com.comprex.comprex.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.comprex.comprex.modelo.Lista;
import br.com.comprex.comprex.modelo.Mercado;
import br.com.comprex.comprex.modelo.Produto;
import br.com.comprex.comprex.modelo.ProdutoLista;
import br.com.comprex.comprex.modelo.ProdutoMercado;

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
        values.put("Produto_Mercado_id", produtoLista.getProdutoMercado().getId());
        values.put("quantidade", produtoLista.getQuantidade());

        writableDatabase.insert("Produtos_Listas", null, values);
    }

    /**
     *
     * @param lista
     * @return
     */
    public List<ProdutoLista> buscarPorLista(Lista lista) {
        StringBuilder builder = new StringBuilder();
        builder.append("SELECT ");
        builder.append("    pl.id         as pl_id, ");
        builder.append("    pl.quantidade as pl_quantidade, ");
        builder.append("    pm.id         as pm_id, ");
        builder.append("    pm.preco      as pm_preco, ");
        builder.append("    p.id          as p_id, ");
        builder.append("    p.nome        as p_nome, ");
        builder.append("    m.id          as m_id, ");
        builder.append("    m.nome        as m_nome, ");
        builder.append("    l.id          as l_id, ");
        builder.append("    l.nome        as l_nome, ");
        builder.append("    l.situacao    as l_situacao, ");
        builder.append("    ml.id         as ml_id, ");
        builder.append("    ml.nome       as ml_nome ");
        builder.append("FROM Produtos_Listas pl ");
        builder.append("    INNER JOIN Produtos_Mercados pm on pm.id = pl.Produto_Mercado_id ");
        builder.append("    INNER JOIN Produtos p on p.id = pm.Produto_id ");
        builder.append("    INNER JOIN Mercados m on m.id = pm.Mercado_id ");
        builder.append("    INNER JOIN Listas l on l.id = pl.Lista_id ");
        builder.append("    INNER JOIN Mercados ml on ml.id = l.Mercado_id ");
        builder.append("WHERE l.id = ? ");

        String[] args = {
                lista.getId().toString()
        };

        SQLiteDatabase database = daoHelper.getReadableDatabase();

        Cursor cursor = database.rawQuery(builder.toString(), args);

        List<ProdutoLista> listaDeProdutoLista = new ArrayList<>();

        while (cursor.moveToNext()) {
            ProdutoLista produtoLista = new ProdutoLista();
            produtoLista.setId(cursor.getLong(cursor.getColumnIndex("pl_id")));
            produtoLista.setQuantidade(cursor.getInt(cursor.getColumnIndex("pl_quantidade")));

            ProdutoMercado produtoMercado = new ProdutoMercado();
            produtoMercado.setId(cursor.getLong(cursor.getColumnIndex("pm_id")));
            produtoMercado.setPreco(cursor.getDouble(cursor.getColumnIndex("pm_preco")));

            Produto produto = new Produto();
            produto.setId(cursor.getLong(cursor.getColumnIndex("p_id")));
            produto.setNome(cursor.getString(cursor.getColumnIndex("p_nome")));

            Mercado mercado = new Mercado();
            mercado.setId(cursor.getLong(cursor.getColumnIndex("m_id")));
            mercado.setNome(cursor.getString(cursor.getColumnIndex("m_nome")));

            produtoMercado.setProduto(produto);
            produtoMercado.setMercado(mercado);

            produtoLista.setLista(lista);
            produtoLista.setProdutoMercado(produtoMercado);

            listaDeProdutoLista.add(produtoLista);
        }

        return listaDeProdutoLista;

    }
}
