package br.com.sincronizador.listener;

import android.content.DialogInterface;
import br.com.sincronizador.modelos.Tarefa;

/**
 *
 * @author gilmario
 */
public class TarefaProcessaListener implements DialogInterface.OnClickListener {

    private final Tarefa tarefa;

    public TarefaProcessaListener(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    public void onClick(DialogInterface dialog, int which) {
        switch (which) {
            case 0:
                // Editar
                break;
            case 1:
                // Agendar
                tarefa.agendar();
                break;
            case 2:
                // Parar
                break;
            case 3:
                // Cancelar
                break;
            case 4:
                // Concluir
                break;
        }
    }

}
