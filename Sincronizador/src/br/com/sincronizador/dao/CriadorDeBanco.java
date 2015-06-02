package br.com.sincronizador.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 *
 * @author gilmario
 */
public class CriadorDeBanco extends SQLiteOpenHelper {

    private static final String BANCO_DADOS = "DB_SINCRONIZADOR";
    private static int VERSAO = 1;

    public CriadorDeBanco(Context context) {
        super(context, BANCO_DADOS, null, VERSAO);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            db.execSQL("PRAGMA foreign_keys=ON;");
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE assunto (_id INTEGER PRIMARY KEY, descricao TEXT unique not null, stringhash TEXT)");
        db.execSQL("CREATE TABLE tarefa (_id INTEGER PRIMARY KEY, titulo TEXT NOT NULL, descricao TEXT, data_cadastro DATE NOT NULL, data_previsao DATE NOT NULL, data_inicio DATE, data_conclusao DATE, status TEXT NOT NULL CHECK(status in ('Pendente', 'Agendada', 'Iniciada', 'Concluida', 'Cancelada')), assunto INTEGER NOT NULL references assunto(_id) ON DELETE RESTRICT, stringhash TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int atual, int nova) {

    }

}
