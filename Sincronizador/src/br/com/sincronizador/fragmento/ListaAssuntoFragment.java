package br.com.sincronizador.fragmento;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import br.com.sincronizador.R;
import br.com.sincronizador.listener.MainFragmentController;
import br.com.sincronizador.logica.AssuntoNegocio;
import br.com.sincronizador.modelos.Assunto;
import br.com.sincronizador.modelos.adapters.AssuntoAdapter;
import br.com.sincronizador.util.DialogBuilder;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gilmario
 */
public class ListaAssuntoFragment extends SincronizadorFragmento implements View.OnClickListener, AdapterView.OnItemClickListener {

    private Button btnConsulta;
    private EditText campoDescricao;
    private AssuntoNegocio assuntoNegocio;
    private AssuntoAdapter assuntoAdapter;
    private final MainFragmentController mainFragmentController;

    public ListaAssuntoFragment(MainFragmentController controller) {
        this.mainFragmentController = controller;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.lista_assunto, null);
        btnConsulta = (Button) rootView.findViewById(R.id.btn_consulta_assunto);
        btnConsulta.setOnClickListener(this);
        assuntoNegocio = new AssuntoNegocio(getActivity());
        campoDescricao = (EditText) rootView.findViewById(R.id.consulta_assunto_descricao);
        ListView listView = (ListView) rootView.findViewById(R.id.lista_assunto_lista);
        assuntoAdapter = new AssuntoAdapter(getActivity(), R.layout.lista_assunto_row, new ArrayList<Assunto>());
        listView.setAdapter(assuntoAdapter);
        listView.setOnItemClickListener(this);
        return rootView;
    }

    public void onClick(View v) {
        consultarAssuntos();
    }

    private void consultarAssuntos() {
        String descricao = campoDescricao.getText().toString();
        List<Assunto> lista = assuntoNegocio.listar();
        assuntoAdapter.clear();
        assuntoAdapter.addAll(lista);
        assuntoAdapter.notifyDataSetChanged();
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        final Assunto assunto = assuntoAdapter.getItem(position);
        DialogBuilder.mensagemDialogConfirmacao(getActivity(), "Excluir assunto?", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                if (which == Dialog.BUTTON_POSITIVE) {
                    mainFragmentController.inicializaFragmento(new CadastraAssuntoFragment(assunto));
                }
            }
        });
    }

    @Override
    public String getNome() {
        return "Lista de Assunto";
    }

}
