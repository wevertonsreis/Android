package br.com.comprex.comprex.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.comprex.comprex.modelo.Lista;
import br.com.comprex.comprex.modelo.Mercado;

public class ListaDAO {

    private DAOHelper daoHelper;

    public ListaDAO(Context context) {
        daoHelper = new DAOHelper(context);
    }

    /**
     *
     * @param lista
     */
    public void inserir(Lista lista) {
        SQLiteDatabase writableDatabase = daoHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nome", lista.getNome());
        values.put("situacao", lista.getSituacao());
        values.put("Mercado_id", lista.getMercado().getId());

        writableDatabase.insert("Listas", null, values);
    }

    /**
     *
     * @param mercadoParametro
     * @return
     */
    public List<Lista> buscarPorMercado(Mercado mercadoParametro) {
        StringBuilder builder = new StringBuilder();
        builder.append("SELECT ");
        builder.append("    l.id, ");
        builder.append("    l.nome, ");
        builder.append("    l.situacao, ");
        builder.append("    l.Mercado_id, ");
        builder.append("    m.nome as nomeMercado ");
        builder.append("FROM Listas l ");
        builder.append("    INNER JOIN Mercados m on m.id = l.Mercado_id ");
        builder.append("WHERE m.id = ?");

        String[] args = {
                mercadoParametro.getId().toString()
        };

        SQLiteDatabase database = daoHelper.getReadableDatabase();

        Cursor cursor = database.rawQuery(builder.toString(), args);

        List<Lista> listas = new ArrayList<>();

        while (cursor.moveToNext()) {
            Lista lista = new Lista();
            lista.setId(cursor.getLong(cursor.getColumnIndex("id")));
            lista.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            lista.setSituacao(cursor.getString(cursor.getColumnIndex("situacao")));

            Mercado mercado = new Mercado();
            mercado.setId(cursor.getLong(cursor.getColumnIndex("Mercado_id")));
            mercado.setNome(cursor.getString(cursor.getColumnIndex("nomeMercado")));

            lista.setMercado(mercado);
            listas.add(lista);
        }

        return listas;
    }

    public void close() {
        daoHelper.close();
    }

}
