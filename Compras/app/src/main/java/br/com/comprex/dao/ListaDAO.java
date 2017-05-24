package br.com.comprex.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.comprex.modelo.Lista;

public class ListaDAO {

    private DAOHelper daoHelper;

    public ListaDAO(Context context) {
        daoHelper = new DAOHelper(context);
    }

    public void inserir(Lista lista) {
        SQLiteDatabase writableDatabase = daoHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nome", lista.getNome());
        values.put("situacao", lista.getSituacao());

        writableDatabase.insert("Listas", null, values);
    }

    public List<Lista> buscarTodas() {
        String sql = "SELECT * FROM Listas";

        SQLiteDatabase database = daoHelper.getReadableDatabase();

        Cursor cursor = database.rawQuery(sql, null);

        List<Lista> listas = new ArrayList<>();

        while (cursor.moveToNext()) {
            Lista lista = new Lista();
            lista.setId(cursor.getLong(cursor.getColumnIndex("id")));
            lista.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            lista.setSituacao(cursor.getString(cursor.getColumnIndex("situacao")));
            listas.add(lista);
        }

        return listas;
    }

    public void close() {
        daoHelper.close();
    }
}
