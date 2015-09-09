package br.com.sincronizador.fragmento;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import br.com.sincronizador.R;
import br.com.sincronizador.listener.MainFragmentController;
import br.com.sincronizador.listener.TarefaProcessaListener;
import br.com.sincronizador.logica.AssuntoNegocio;
import br.com.sincronizador.logica.TarefaNegocio;
import br.com.sincronizador.modelos.Assunto;
import br.com.sincronizador.modelos.Tarefa;
import br.com.sincronizador.modelos.adapters.TarefaAdapter;
import br.com.sincronizador.util.DialogBuilder;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gilmario
 */
public class ListaTarefaFragment extends SincronizadorFragmento implements View.OnClickListener, AdapterView.OnItemClickListener {

    private Button btnConsulta;
    private Spinner assuntoSpinner;
    private AssuntoNegocio assuntoNegocio;
    private TarefaNegocio tarefaNegocio;
    private TarefaAdapter tarefaAdapter;
    private final MainFragmentController mainFragmentController;

    public ListaTarefaFragment(MainFragmentController controller) {
        this.mainFragmentController = controller;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.lista_tarefa, null);
        btnConsulta = (Button) rootView.findViewById(R.id.btn_consulta_tarefa);
        btnConsulta.setOnClickListener(this);
        assuntoNegocio = new AssuntoNegocio(getActivity());
        tarefaNegocio = new TarefaNegocio(getActivity());
        assuntoSpinner = (Spinner) rootView.findViewById(R.id.consulta_tarefa_assunto);
        assuntoSpinner.setAdapter(new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, assuntoNegocio.listar()));
        ListView listView = (ListView) rootView.findViewById(R.id.lista_tarefa_lista);
        tarefaAdapter = new TarefaAdapter(getActivity(), R.layout.lista_tarefa_row, new ArrayList<Tarefa>());
        listView.setAdapter(tarefaAdapter);
        listView.setOnItemClickListener(this);
        return rootView;
    }

    public void onClick(View v) {
        consultarTarefas();
    }

    private void consultarTarefas() {
        Assunto assunto = (Assunto) assuntoSpinner.getSelectedItem();
        List<Tarefa> lista = tarefaNegocio.listar();
        tarefaAdapter.clear();
        tarefaAdapter.addAll(lista);
        tarefaAdapter.notifyDataSetChanged();
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        final Tarefa tarefa = tarefaAdapter.getItem(position);
        DialogBuilder.mensagemDialogConfirmacao(getActivity(), new TarefaProcessaListener(tarefa), getActivity().getResources().getStringArray(R.array.opcoes_tarefa));
    }

    @Override
    public String getNome() {
        return "Lista de Tarefas";
    }

}
