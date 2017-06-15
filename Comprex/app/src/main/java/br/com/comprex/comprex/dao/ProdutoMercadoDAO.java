package br.com.comprex.comprex.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.comprex.comprex.modelo.Lista;
import br.com.comprex.comprex.modelo.Mercado;
import br.com.comprex.comprex.modelo.Produto;
import br.com.comprex.comprex.modelo.ProdutoMercado;

public class ProdutoMercadoDAO {

    private DAOHelper daoHelper;

    public ProdutoMercadoDAO(Context context) {
        daoHelper = new DAOHelper(context);
    }

    /**
     * Busca os produtos de um determinado mercado
     *
     * @param mercadoParametro
     * @return
     */
    public List<ProdutoMercado> buscarPorMercado(Mercado mercadoParametro) {
        StringBuilder builder = new StringBuilder();
        builder.append("SELECT ");
        builder.append("    pm.id as pm_id, ");
        builder.append("    pm.preco as pm_preco, ");
        builder.append("    m.id as m_id, ");
        builder.append("    m.nome as m_nome, ");
        builder.append("    p.id as p_id, ");
        builder.append("    p.nome as p_nome ");
        builder.append("FROM Produtos_Mercados pm ");
        builder.append("    INNER JOIN Mercados m on m.id = pm.Mercado_id ");
        builder.append("    INNER JOIN Produtos p on p.id = pm.Produto_id ");
        builder.append("WHERE m.id = ? ");

        String[] args = {
                mercadoParametro.getId().toString()
        };

        SQLiteDatabase database = daoHelper.getReadableDatabase();

        Cursor cursor = database.rawQuery(builder.toString(), args);

        List<ProdutoMercado> listaDeProdutoMercado = new ArrayList<>();

        while (cursor.moveToNext()) {
            ProdutoMercado produtoMercado = new ProdutoMercado();
            produtoMercado.setId(cursor.getLong(cursor.getColumnIndex("pm_id")));
            produtoMercado.setPreco(cursor.getDouble(cursor.getColumnIndex("pm_preco")));

            Mercado mercado = new Mercado();
            mercado.setId(cursor.getLong(cursor.getColumnIndex("m_id")));
            mercado.setNome(cursor.getString(cursor.getColumnIndex("m_nome")));

            Produto produto = new Produto();
            produto.setId(cursor.getLong(cursor.getColumnIndex("p_id")));
            produto.setNome(cursor.getString(cursor.getColumnIndex("p_nome")));

            produtoMercado.setMercado(mercado);
            produtoMercado.setProduto(produto);

            listaDeProdutoMercado.add(produtoMercado);
        }

        return listaDeProdutoMercado;
    }

}
