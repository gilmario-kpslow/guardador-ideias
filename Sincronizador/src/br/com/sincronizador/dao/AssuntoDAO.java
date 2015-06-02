package br.com.sincronizador.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import br.com.sincronizador.modelos.Assunto;

/**
 *
 * @author gilmario
 */
public class AssuntoDAO extends DAO<Assunto> {

    public AssuntoDAO(Context context) {
        super(context);
    }

    @Override
    public String getTabela() {
        return "assunto";
    }

    @Override
    public String[] getColunas() {
        return new String[]{"_id", "descricao", "stringhash"};
    }

    @Override
    protected Assunto montar(Cursor cursor) {
        Assunto assunto = new Assunto();
        assunto.setId(cursor.getLong(0));
        assunto.setDescricao(cursor.getString(1));
        assunto.setStringhash(cursor.getString(2));
        return assunto;
    }

    @Override
    protected ContentValues createContentValues(Assunto entidade) {
        ContentValues values = new ContentValues();
        values.put(getColunas()[0], entidade.getId());
        values.put(getColunas()[1], entidade.getDescricao());
        values.put(getColunas()[2], entidade.getStringhash());
        return values;
    }

}
