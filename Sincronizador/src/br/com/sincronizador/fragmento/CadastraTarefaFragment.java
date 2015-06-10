package br.com.sincronizador.fragmento;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import br.com.sincronizador.R;
import br.com.sincronizador.logica.AssuntoNegocio;
import br.com.sincronizador.logica.TarefaNegocio;
import br.com.sincronizador.modelos.Assunto;
import br.com.sincronizador.modelos.Tarefa;
import java.util.List;

/**
 *
 * @author gilmario
 */
public class CadastraTarefaFragment extends SincronizadorFragmento implements View.OnClickListener {

    private EditText descricao;
    private EditText titulo;
    private Spinner assunto;
    private Tarefa tarefa;

    public CadastraTarefaFragment() {

    }

    public CadastraTarefaFragment(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.cadastro_tarefa, null);
        descricao = (EditText) rootView.findViewById(R.id.cadastro_tarefa_descricao);
        titulo = (EditText) rootView.findViewById(R.id.cadastro_tarefa_titulo);
        assunto = (Spinner) rootView.findViewById(R.id.cadastro_tarefa_assunto);
        AssuntoNegocio assuntoNegocio = new AssuntoNegocio(getActivity());
        List<Assunto> ass = assuntoNegocio.listar();
        assunto.setAdapter(new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, ass));
        Button button = (Button) rootView.findViewById(R.id.btn_salvar_tarefa);
        button.setOnClickListener(this);
        if (tarefa != null) {
            descricao.setText(tarefa.getDescricao());
            titulo.setText(tarefa.getTitulo());
            assunto.setSelection(ass.indexOf(tarefa.getAssunto()));
        }
        return rootView;
    }

    public void onClick(View v) {
        try {
            TarefaNegocio negocio = new TarefaNegocio(getActivity());
            if (tarefa == null) {
                tarefa = new Tarefa();
            }
            tarefa.setTitulo(titulo.getText().toString());
            tarefa.setDescricao(descricao.getText().toString());
            tarefa.setAssunto((Assunto) assunto.getSelectedItem());
            negocio.salvar(tarefa);
            Toast.makeText(getActivity(), "Tarefa cadastrada com sucesso!", Toast.LENGTH_SHORT).show();
            clearView();
        } catch (Exception e) {
            Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void clearView() {
        descricao.setText("");
        titulo.setText("");
        assunto.setSelection(0);
    }

    @Override
    public String getNome() {
        return "Cadastro de Tarefas";
    }

}
