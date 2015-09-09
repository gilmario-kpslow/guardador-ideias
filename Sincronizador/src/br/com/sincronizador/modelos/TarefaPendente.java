package br.com.sincronizador.modelos;

import br.com.sincronizador.modelos.exections.TarefaExceptions;

/**
 *
 * @author gilmario
 */
public class TarefaPendente implements MudaStatusTarefa {

    public void agendarTarefa(Tarefa tarefa, AgendarTarefa alteradorStatus) throws TarefaExceptions {
        alteradorStatus.alterarStatus(tarefa);
    }

    public void cancelarTarefa(Tarefa tarefa) throws TarefaExceptions {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void pararTarefa(Tarefa tarefa) throws TarefaExceptions {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void concluirTarefa(Tarefa tarefa) throws TarefaExceptions {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void agendarTarefa(Tarefa tarefa, AlteradorStatus alteradorStatus) throws TarefaExceptions {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
