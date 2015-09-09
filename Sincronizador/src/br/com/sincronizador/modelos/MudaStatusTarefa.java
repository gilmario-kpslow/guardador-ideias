package br.com.sincronizador.modelos;

import br.com.sincronizador.modelos.exections.TarefaExceptions;

/**
 *
 * @author gilmario
 */
public interface MudaStatusTarefa {

    public void agendarTarefa(Tarefa tarefa, AlteradorStatus alteradorStatus) throws TarefaExceptions;

    public void cancelarTarefa(Tarefa tarefa) throws TarefaExceptions;

    public void pararTarefa(Tarefa tarefa) throws TarefaExceptions;

    public void concluirTarefa(Tarefa tarefa) throws TarefaExceptions;
}
