package br.com.sincronizador.validacao;

import br.com.sincronizador.modelos.Tarefa;

/**
 *
 * @author gilmario
 */
public class ValidaTarefa extends ValidadorManager {

    public ValidaTarefa(Tarefa tarefa) {
        super(new ValidaString(tarefa.getTitulo(), 3, 20, true),
                new ValidaString(tarefa.getDescricao(), 3, 255, true),
                new ValidaNotNull(tarefa.getDataCadastro()),
                new ValidaNotNull(tarefa.getAssunto()),
                new ValidaNotNull(tarefa.getStatus()));
    }

}
