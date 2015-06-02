package br.com.sincronizador.menu;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import br.com.sincronizador.R;

/**
 *
 * @author gilmario
 */
public class MenuListItem extends ListFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.lista_generica, container);
        return rootView;
    }

}
