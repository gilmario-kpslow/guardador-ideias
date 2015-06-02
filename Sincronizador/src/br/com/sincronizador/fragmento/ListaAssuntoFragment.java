package br.com.sincronizador.fragmento;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import br.com.sincronizador.R;

/**
 *
 * @author gilmario
 */
public class ListaAssuntoFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.lista_assunto, null);

        return rootView;
    }

}
