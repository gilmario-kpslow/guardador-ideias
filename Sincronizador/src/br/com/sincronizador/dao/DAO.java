package br.com.sincronizador.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gilmario
 * @param <T>
 */
public abstract class DAO<T> {

    private final CriadorDeBanco resolver;
    private final SQLiteDatabase db;

    public abstract String getTabela();

    public abstract String[] getColunas();

    protected abstract T montar(Cursor cursor);

    protected abstract ContentValues createContentValues(T entidade);

    public DAO(Context context) {
        resolver = new CriadorDeBanco(context);
        db = resolver.getWritableDatabase();
    }

    public CriadorDeBanco getResolver() {
        return resolver;
    }

    public SQLiteDatabase getDb() {
        return db;
    }

    public int excluir(Long id) throws Exception {
        int resultado = getDb().delete(getTabela(), " _ID =? ", new String[]{id.toString()});
        return resultado;
    }

    public List<T> listar() {
        List<T> lista = new ArrayList<T>();
        Cursor cursor = getResolver().getReadableDatabase().query(getTabela(), getColunas(), null, null, null, null, "_ID");
        cursor.moveToFirst();
        for (int i = 0; i < cursor.getCount(); i++) {
            lista.add(montar(cursor));
            cursor.moveToNext();
        }
        return lista;
    }

    public Long salva(T entidade) {
        long resultado = getDb().insertOrThrow(getTabela(), null, createContentValues(entidade));
        return resultado;
    }

    public T carregar(Long id) {
        Cursor cursor = getResolver().getReadableDatabase().query(getTabela(), getColunas(), " _id=?", new String[]{id.toString()}, null, null, null);
        cursor.moveToFirst();
        return montar(cursor);
    }

}
