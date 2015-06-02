package br.com.sincronizador.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import br.com.sincronizador.modelos.Tarefa;
import br.com.sincronizador.util.DataConverterUtil;

/**
 *
 * @author gilmario
 */
public class TarefaDAO extends DAO<Tarefa> {

    private final AssuntoDAO assuntoDAO;

    public TarefaDAO(Context context) {
        super(context);
        assuntoDAO = new AssuntoDAO(context);
    }

    @Override
    public String getTabela() {
        return "tarefa";
    }

    @Override
    public String[] getColunas() {
        return new String[]{"_id", "titulo", "descricao", "data_cadastro", "data_previsao", "data_inicio", "data_conclusao", "status", "assunto", "stringhash"};
    }

    @Override
    protected Tarefa montar(Cursor cursor) {
        DataConverterUtil util = new DataConverterUtil();
        Tarefa tarefa = new Tarefa();
        int i = 0;
        tarefa.setId(cursor.getLong(i++));
        tarefa.setTitulo(cursor.getString(i++));
        tarefa.setDescricao(cursor.getString(i++));
        tarefa.setDataCadastro(util.converte(cursor.getLong(i++)));
        tarefa.setDataPrevisao(util.converte(cursor.getLong(i++)));
        tarefa.setDataInicio(util.converte(cursor.getLong(i++)));
        tarefa.setDataInicio(util.converte(cursor.getLong(i++)));
        tarefa.setDataConclusao(util.converte(cursor.getLong(i++)));
        tarefa.setStatus(Tarefa.StatusTarefa.valueOf(cursor.getString(i++)));
        tarefa.setAssunto(assuntoDAO.carregar(cursor.getLong(i++)));
        tarefa.setStringhash(cursor.getString(i++));
        return tarefa;
    }

    @Override
    protected ContentValues createContentValues(Tarefa entidade) {
        ContentValues values = new ContentValues();
        DataConverterUtil util = new DataConverterUtil();
        values.put(getColunas()[0], entidade.getId());
        values.put(getColunas()[1], entidade.getTitulo());
        values.put(getColunas()[2], entidade.getDescricao());
        values.put(getColunas()[3], util.parseData(entidade.getDataCadastro()));
        values.put(getColunas()[4], util.parseData(entidade.getDataPrevisao()));
        values.put(getColunas()[5], util.parseData(entidade.getDataInicio()));
        values.put(getColunas()[6], util.parseData(entidade.getDataConclusao()));
        values.put(getColunas()[7], entidade.getStatus().toString());
        values.put(getColunas()[8], entidade.getStringhash());
        return values;
    }

}
