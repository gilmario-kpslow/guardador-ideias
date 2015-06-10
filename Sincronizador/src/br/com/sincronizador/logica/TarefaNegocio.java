package br.com.sincronizador.logica;

import android.content.Context;
import br.com.sincronizador.dao.TarefaDAO;
import br.com.sincronizador.modelos.Tarefa;
import br.com.sincronizador.validacao.ValidaTarefa;
import br.com.sincronizador.validacao.ValidadorManager;

/**
 *
 * @author gilmario
 */
public class TarefaNegocio extends AbstractNegocio<Tarefa> {

    public TarefaNegocio(Context context) {
        super(new TarefaDAO(context));
    }

    @Override
    protected TarefaDAO getDao() {
        return (TarefaDAO) super.getDao();
    }

    @Override
    protected ValidadorManager getValidatorManager(Tarefa tarefa) {
        return new ValidaTarefa(tarefa);
    }

}
