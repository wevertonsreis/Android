package br.com.comprex.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DAOHelper extends SQLiteOpenHelper {

    private static final String NOME_DB = "Compras";
    private static final int VERSAO_DB = 15;

    public DAOHelper(Context context) {
        super(context, NOME_DB, null, VERSAO_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        StringBuilder builderQuery = new StringBuilder();

        builderQuery.append("CREATE TABLE Categorias ( ");
        builderQuery.append("   id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        builderQuery.append("   nome VARCHAR(100) NOT NULL ");
        builderQuery.append("); ");

        db.execSQL(builderQuery.toString());
        builderQuery.delete(0, builderQuery.length());

        builderQuery.append("CREATE TABLE Produtos ( ");
        builderQuery.append("   id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        builderQuery.append("   nome VARCHAR(100) NOT NULL, ");
        builderQuery.append("   preco REAL NOT NULL, ");
        builderQuery.append("   Categoria_id INTEGER REFERENCES Categorias (id) ");
        builderQuery.append("); ");

        db.execSQL(builderQuery.toString());
        builderQuery.delete(0, builderQuery.length());

        builderQuery.append("CREATE TABLE Listas ( ");
        builderQuery.append("   id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        builderQuery.append("   nome VARCHAR(100) NOT NULL, ");
        builderQuery.append("   situacao VARCHAR(100) ");
        builderQuery.append("); ");

        db.execSQL(builderQuery.toString());
        builderQuery.delete(0, builderQuery.length());

        builderQuery.append("CREATE TABLE Listas_Produtos ( ");
        builderQuery.append("   id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        builderQuery.append("   Lista_id INTEGER REFERENCES Listas (id), ");
        builderQuery.append("   Produto_id INTEGER REFERENCES Produtos (id) ");
        builderQuery.append("); ");

        db.execSQL(builderQuery.toString());
        builderQuery.delete(0, builderQuery.length());

        builderQuery.append("CREATE TABLE Mercados ( ");
        builderQuery.append("   id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        builderQuery.append("   nome VARCHAR(100) NOT NULL ");
        builderQuery.append("); ");

        db.execSQL(builderQuery.toString());
        builderQuery.delete(0, builderQuery.length());

        builderQuery.append("CREATE TABLE Mercados_Produtos ( ");
        builderQuery.append("   id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        builderQuery.append("   Mercado_id INTEGER REFERENCES Mercados (id), ");
        builderQuery.append("   Produto_id INTEGER REFERENCES Produtos (id) ");
        builderQuery.append("); ");

        db.execSQL(builderQuery.toString());
        System.out.println(builderQuery.toString());

        ContentValues valores = new ContentValues();
        valores.put("nome", "Melancia");
        valores.put("preco", 10.00);

        db.insert("Produtos", null, valores);

        valores = new ContentValues();
        valores.put("nome", "Morango");
        valores.put("preco", 15.00);

        db.insert("Produtos", null, valores);

        valores = new ContentValues();
        valores.put("nome", "Banana");
        valores.put("preco", 5.00);

        db.insert("Produtos", null, valores);

        valores = new ContentValues();
        valores.put("nome", "Uva");
        valores.put("preco", 20.00);

        db.insert("Produtos", null, valores);

        valores = new ContentValues();
        valores.put("nome", "Melão");
        valores.put("preco", 12.00);

        db.insert("Produtos", null, valores);

        valores = new ContentValues();
        valores.put("nome", "Abacaxi");
        valores.put("preco", 20.00);

        db.insert("Produtos", null, valores);

        valores = new ContentValues();
        valores.put("nome", "Maça");
        valores.put("preco", 20.00);

        db.insert("Produtos", null, valores);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        StringBuilder builderQuery = new StringBuilder();

        builderQuery.append("DROP TABLE IF EXISTS Categorias");

        db.execSQL(builderQuery.toString());
        builderQuery.delete(0, builderQuery.length());

        builderQuery.append("DROP TABLE IF EXISTS Listas");

        db.execSQL(builderQuery.toString());
        builderQuery.delete(0, builderQuery.length());

        builderQuery.append("DROP TABLE IF EXISTS Produtos");

        db.execSQL(builderQuery.toString());
        builderQuery.delete(0, builderQuery.length());

        builderQuery.append("DROP TABLE IF EXISTS Listas_Produtos");

        db.execSQL(builderQuery.toString());
        builderQuery.delete(0, builderQuery.length());

        builderQuery.append("DROP TABLE IF EXISTS Mercados");

        db.execSQL(builderQuery.toString());
        builderQuery.delete(0, builderQuery.length());

        builderQuery.append("DROP TABLE IF EXISTS Mercados_Produtos");

        db.execSQL(builderQuery.toString());

        onCreate(db);
    }

}
