package br.com.comprex.comprex.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.comprex.comprex.modelo.Mercado;

public class MercadoDAO {

    private DAOHelper daoHelper;

    public MercadoDAO(Context context) {
        daoHelper = new DAOHelper(context);
    }

    public List<Mercado> buscarTodas() {
        String sql = "SELECT * FROM Mercados";

        SQLiteDatabase database = daoHelper.getReadableDatabase();

        Cursor cursor = database.rawQuery(sql, null);

        List<Mercado> mercados = new ArrayList<>();

        while (cursor.moveToNext()) {
            Mercado mercado = new Mercado();
            mercado.setId(cursor.getLong(cursor.getColumnIndex("id")));
            mercado.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            mercados.add(mercado);
        }

        return mercados;
    }

}
