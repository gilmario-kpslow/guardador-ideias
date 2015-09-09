package br.com.sincronizador.logica;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import br.com.sincronizador.modelos.Tarefa;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author gilmario
 */
public class Agendador extends Service {

    private final IBinder localBinder = new LocalBinder();
    private Looper serviceLooper;
    private final List<Tarefa> tarefas;

    public Agendador() {
        this.tarefas = new ArrayList<Tarefa>();
    }

    public class LocalBinder extends Binder {

        Agendador getService() {
            return Agendador.this;
        }
    }

    private final class TarefaAgendadaHandle extends Handler {

        public TarefaAgendadaHandle(Looper l) {
            super(l);
        }

        @Override
        public void handleMessage(Message msg) {
            while (true) {
                synchronized (this) {
                    try {
                        wait(1000);
                        verificarAgendamentos();
                    } catch (Exception e) {
                        Log.e("ERRO", e.getMessage());
                    }
                }
            }
        }

    }

    private void verificarAgendamentos() {
        long atualTime = new Date().getTime();
        for (Tarefa t : tarefas) {
            if (t.getStatus().equals(Tarefa.StatusTarefa.Agendada)) {
                if (t.getDataInicio().getTime() < atualTime) {
                    t.iniciar();
                    iniciaAlarme(t);
                }
            }
        }
    }

    public void adicionaTarefa(Tarefa tarefa) {
        this.tarefas.add(tarefa);
    }

    public void removeTarefa(Tarefa tarefa) {
        this.tarefas.remove(tarefa);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return localBinder;
    }

    private void iniciaAlarme(Tarefa tarefa) {
        // Iniciar um alarme aqui
        // Adicionar uma notificalçao

    }

}
