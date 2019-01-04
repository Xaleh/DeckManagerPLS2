package br.com.alexandresilvareis.deckmangerpls2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class CityModel extends SQLiteOpenHelper {

    public CityModel(Context context) { super(context, "Deck Manager PLS2", null, 1);}

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Cidades (id PRIMARY KEY, nome TEXT NOT NULL, cor TEXT NOT NULL, quantidade INTEGER NOT NULL, chance_de_sair INTEGER NOT NULL);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "";
        switch (oldVersion) {
            case 1:
                sql = "ALTER TABLE Cidades ADD COLUMN status INTEGER";
                db.execSQL(sql);
        }
    }

    public void insere(Cidade cidade) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = pegaDadosDaCidade(cidade);
        db.insert("Cidades", null, dados);
    }

    private ContentValues pegaDadosDaCidade(Cidade cidade) {
        ContentValues dados = new ContentValues();
        dados.put("nome", cidade.getNome());
        dados.put("cor", cidade.getCor());
        dados.put("quantidade", cidade.getQuantidade());
        dados.put("chance_de_sair", cidade.getChance_de_sair());
        return dados;
    }

    public List<Cidade> buscaCidades() {
        String sql = "SELECT * FROM Cidades;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);

        List<Cidade> cidades = new ArrayList<Cidade>();
        while (c.moveToNext()) {
            Cidade cidade = new Cidade();
            cidade.setId(c.getLong(c.getColumnIndex("id")));
            cidade.setNome(c.getString(c.getColumnIndex("nome")));
            cidade.setCor(c.getString(c.getColumnIndex("cor")));
            cidade.setQuantidade(c.getInt(c.getColumnIndex("quantidade")));
            cidade.setChance_de_sair(c.getInt(c.getColumnIndex("chance_de_sair")));

            cidades.add(cidade);
        }
        c.close();

        return cidades;
    }

    public void deleta(Cidade cidade) {
        SQLiteDatabase db = getWritableDatabase();
        String[] params = {cidade.getId().toString()};
        db.delete("Cidades", "id = ?", params);
    }

    public void altera(Cidade cidade) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = pegaDadosDaCidade(cidade);
        String[] params = {cidade.getId().toString()};
        db.update("Cidades", dados, "id = ?", params);
    }
}
