package br.com.sincronizador.modelos;

/**
 *
 * @author gilmario
 */
public class AgendarTarefa implements AlteradorStatus {

    public void alterarStatus(Tarefa tarefa) {
        tarefa.setStatus(Tarefa.StatusTarefa.Agendada);
        // Salvar no banco
        // 
        // Incluir na lista de agedamento
    }

}
