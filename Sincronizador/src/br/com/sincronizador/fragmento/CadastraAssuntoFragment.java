package br.com.sincronizador.fragmento;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import br.com.sincronizador.R;
import br.com.sincronizador.logica.AssuntoNegocio;
import br.com.sincronizador.modelos.Assunto;

/**
 *
 * @author gilmario
 */
public class CadastraAssuntoFragment extends SincronizadorFragmento implements View.OnClickListener {

    private EditText descricao;
    private Assunto assunto;

    public CadastraAssuntoFragment() {

    }

    public CadastraAssuntoFragment(Assunto assunto) {
        this.assunto = assunto;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.cadastro_assunto, null);
        descricao = (EditText) rootView.findViewById(R.id.cadastro_assunto_descricao);
        Button button = (Button) rootView.findViewById(R.id.btn_salvar);
        button.setOnClickListener(this);
        if (assunto != null) {
            descricao.setText(assunto.getDescricao());
        }
        return rootView;
    }

    public void onClick(View v) {
        try {
            AssuntoNegocio negocio = new AssuntoNegocio(getActivity());
            if (assunto == null) {
                assunto = new Assunto();
            }
            assunto.setDescricao(descricao.getText().toString());
            negocio.salvar(assunto);
            Toast.makeText(getActivity(), "Assunto cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
            clearView();
        } catch (Exception e) {
            Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void clearView() {
        descricao.setText("");
    }

    @Override
    public String getNome() {
        return "Cadastro de Assuntos";
    }

}
