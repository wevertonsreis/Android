package br.com.comprex.comprex.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DAOHelper extends SQLiteOpenHelper {

    private static final String NOME_DB = "Comprex";
    private static final int VERSAO_DB = 1;

    public DAOHelper(Context context) {
        super(context, NOME_DB, null, VERSAO_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        StringBuilder builderQuery = new StringBuilder();

        builderQuery.append("CREATE TABLE Mercados ( ");
        builderQuery.append("   id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        builderQuery.append("   nome VARCHAR(100) NOT NULL ");
        builderQuery.append("); ");

        db.execSQL(builderQuery.toString());
        builderQuery.delete(0, builderQuery.length());

        builderQuery.append("CREATE TABLE Produtos ( ");
        builderQuery.append("   id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        builderQuery.append("   nome VARCHAR(100) NOT NULL ");
        builderQuery.append("); ");

        db.execSQL(builderQuery.toString());
        builderQuery.delete(0, builderQuery.length());

        builderQuery.append("CREATE TABLE Listas ( ");
        builderQuery.append("   id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        builderQuery.append("   nome VARCHAR(100) NOT NULL, ");
        builderQuery.append("   situacao VARCHAR(100), ");
        builderQuery.append("   Mercado_id INTEGER REFERENCES Mercados (id) ");
        builderQuery.append("); ");

        db.execSQL(builderQuery.toString());
        builderQuery.delete(0, builderQuery.length());

        builderQuery.append("CREATE TABLE Produtos_Mercados ( ");
        builderQuery.append("   id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        builderQuery.append("   Mercado_id INTEGER REFERENCES Mercados (id), ");
        builderQuery.append("   Produto_id INTEGER REFERENCES Produtos (id), ");
        builderQuery.append("   preco REAL NOT NULL ");
        builderQuery.append("); ");

        db.execSQL(builderQuery.toString());
        builderQuery.delete(0, builderQuery.length());

        builderQuery.append("CREATE TABLE Produtos_Listas ( ");
        builderQuery.append("   id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        builderQuery.append("   Lista_id INTEGER REFERENCES Listas (id), ");
        builderQuery.append("   Produto_Mercado_id INTEGER REFERENCES Produtos_Mercados (id), ");
        builderQuery.append("   quantidade INTEGER NOT NULL ");
        builderQuery.append("); ");

        db.execSQL(builderQuery.toString());

        inserirValoresIniciais(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        StringBuilder builderQuery = new StringBuilder();
        builderQuery.append("DROP TABLE IF EXISTS Produtos_Listas;");
        db.execSQL(builderQuery.toString());

        builderQuery.delete(0, builderQuery.length());
        builderQuery.append("DROP TABLE IF EXISTS Produtos_Mercados;");
        db.execSQL(builderQuery.toString());

        builderQuery.delete(0, builderQuery.length());
        builderQuery.append("DROP TABLE IF EXISTS Listas;");
        db.execSQL(builderQuery.toString());

        builderQuery.delete(0, builderQuery.length());
        builderQuery.append("DROP TABLE IF EXISTS Produtos;");
        db.execSQL(builderQuery.toString());

        builderQuery.delete(0, builderQuery.length());
        builderQuery.append("DROP TABLE IF EXISTS Mercados;");
        db.execSQL(builderQuery.toString());

        onCreate(db);
    }

    /**
     *
     * @param db
     */
    private void inserirValoresIniciais(SQLiteDatabase db) {

        // Mercados 1

        ContentValues valores = new ContentValues();
        valores.put("nome", "Hortifruti Fernanda");
        long idMercado1 = db.insert("Mercados", null, valores);

        valores.clear();
        valores.put("nome", "Melancia");
        long idProduto1 = db.insert("Produtos", null, valores);

        valores.clear();
        valores.put("nome", "Morango");
        long idProduto2 = db.insert("Produtos", null, valores);

        valores.clear();
        valores.put("nome", "Banana");
        long idProduto3 = db.insert("Produtos", null, valores);

        valores.clear();
        valores.put("nome", "Uva");
        long idProduto4 = db.insert("Produtos", null, valores);

        valores.clear();
        valores.put("nome", "Melão");
        long idProduto5 = db.insert("Produtos", null, valores);

        valores.clear();
        valores.put("nome", "Abacaxi");
        long idProduto6 = db.insert("Produtos", null, valores);

        valores.clear();
        valores.put("Mercado_id", idMercado1);
        valores.put("Produto_id", idProduto1);
        valores.put("preco", 9.99);
        db.insert("Produtos_Mercados", null, valores);

        valores.clear();
        valores.put("Mercado_id", idMercado1);
        valores.put("Produto_id", idProduto2);
        valores.put("preco", 15.99);
        db.insert("Produtos_Mercados", null, valores);

        valores.clear();
        valores.put("Mercado_id", idMercado1);
        valores.put("Produto_id", idProduto3);
        valores.put("preco", 3.99);
        db.insert("Produtos_Mercados", null, valores);

        valores.clear();
        valores.put("Mercado_id", idMercado1);
        valores.put("Produto_id", idProduto4);
        valores.put("preco", 18.99);
        db.insert("Produtos_Mercados", null, valores);

        valores.clear();
        valores.put("Mercado_id", idMercado1);
        valores.put("Produto_id", idProduto5);
        valores.put("preco", 5.99);
        db.insert("Produtos_Mercados", null, valores);

        valores.clear();
        valores.put("Mercado_id", idMercado1);
        valores.put("Produto_id", idProduto6);
        valores.put("preco", 8.99);
        db.insert("Produtos_Mercados", null, valores);

        // Mercado 2

        valores.clear();
        valores.put("nome", "Lola's Doces Artesanais");
        long idMercado2 = db.insert("Mercados", null, valores);

        valores.clear();
        valores.put("nome", "Brigadeiro Tradicional (20gr)");
        long idProduto7 = db.insert("Produtos", null, valores);

        valores.clear();
        valores.put("nome", "Linha gourmet (Paçoca, prestígio) (20gr)");
        long idProduto8 = db.insert("Produtos", null, valores);

        valores.clear();
        valores.put("nome", "Morango (40 gr)");
        long idProduto9 = db.insert("Produtos", null, valores);

        valores.clear();
        valores.put("nome", "Doce de abóbora (40 gr)");
        long idProduto10 = db.insert("Produtos", null, valores);

        valores.clear();
        valores.put("Mercado_id", idMercado2);
        valores.put("Produto_id", idProduto7);
        valores.put("preco", 4.00);
        db.insert("Produtos_Mercados", null, valores);

        valores.clear();
        valores.put("Mercado_id", idMercado2);
        valores.put("Produto_id", idProduto8);
        valores.put("preco", 4.50);
        db.insert("Produtos_Mercados", null, valores);

        valores.clear();
        valores.put("Mercado_id", idMercado2);
        valores.put("Produto_id", idProduto9);
        valores.put("preco", 5.00);
        db.insert("Produtos_Mercados", null, valores);

        valores.clear();
        valores.put("Mercado_id", idMercado2);
        valores.put("Produto_id", idProduto10);
        valores.put("preco", 4.00);
        db.insert("Produtos_Mercados", null, valores);

        // Mercado 3

        valores.clear();
        valores.put("nome", "Mark Mercado");
        long idMercado3 = db.insert("Mercados", null, valores);

        valores.clear();
        valores.put("nome", "Arroz");
        long idProduto11 = db.insert("Produtos", null, valores);

        valores.clear();
        valores.put("nome", "Bolacha");
        long idProduto12 = db.insert("Produtos", null, valores);

        valores.clear();
        valores.put("nome", "Bolacha Recheada");
        long idProduto13 = db.insert("Produtos", null, valores);

        valores.clear();
        valores.put("nome", "Cereal");
        long idProduto14 = db.insert("Produtos", null, valores);

        valores.clear();
        valores.put("Mercado_id", idMercado3);
        valores.put("Produto_id", idProduto11);
        valores.put("preco", 4.00);
        db.insert("Produtos_Mercados", null, valores);

        valores.clear();
        valores.put("Mercado_id", idMercado3);
        valores.put("Produto_id", idProduto12);
        valores.put("preco", 4.00);
        db.insert("Produtos_Mercados", null, valores);

        valores.clear();
        valores.put("Mercado_id", idMercado3);
        valores.put("Produto_id", idProduto13);
        valores.put("preco", 4.00);
        db.insert("Produtos_Mercados", null, valores);

        valores.clear();
        valores.put("Mercado_id", idMercado3);
        valores.put("Produto_id", idProduto14);
        valores.put("preco", 4.00);
        db.insert("Produtos_Mercados", null, valores);

        //Mercado 4

        valores.clear();
        valores.put("nome", "NoVo HoRiZonte Mercado");
        long idMercado4 = db.insert("Mercados", null, valores);

        valores.clear();
        valores.put("nome", "Cerveja");
        long idProduto15 = db.insert("Produtos", null, valores);

        valores.clear();
        valores.put("nome", "Chocolate");
        long idProduto16 = db.insert("Produtos", null, valores);

        valores.clear();
        valores.put("Mercado_id", idMercado4);
        valores.put("Produto_id", idProduto15);
        valores.put("preco", 4.00);
        db.insert("Produtos_Mercados", null, valores);

        valores.clear();
        valores.put("Mercado_id", idMercado4);
        valores.put("Produto_id", idProduto16);
        valores.put("preco", 4.00);
        db.insert("Produtos_Mercados", null, valores);

        // Mercado 5

        valores.clear();
        valores.put("nome", "Santista Mercado");
        long idMercado5 = db.insert("Mercados", null, valores);

        valores.clear();
        valores.put("nome", "Danone");
        long idProduto17 = db.insert("Produtos", null, valores);

        valores.clear();
        valores.put("nome", "Dolly");
        long idProduto18 = db.insert("Produtos", null, valores);

        valores.clear();
        valores.put("Mercado_id", idMercado5);
        valores.put("Produto_id", idProduto17);
        valores.put("preco", 4.00);
        db.insert("Produtos_Mercados", null, valores);

        valores.clear();
        valores.put("Mercado_id", idMercado5);
        valores.put("Produto_id", idProduto18);
        valores.put("preco", 4.00);
        db.insert("Produtos_Mercados", null, valores);
    }

}