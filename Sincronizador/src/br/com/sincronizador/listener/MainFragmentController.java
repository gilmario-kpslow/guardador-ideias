package br.com.sincronizador.listener;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.View;
import android.widget.AdapterView;
import br.com.sincronizador.R;

/**
 *
 * @author gilmario
 */
public class MainFragmentController implements AdapterView.OnItemClickListener {

    private final FragmentManager manager;
    private final FinalListener finalListener;

    public MainFragmentController(FragmentManager manager, FinalListener listener) {
        this.manager = manager;
        this.finalListener = listener;
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Fragment frag = (Fragment) parent.getItemAtPosition(position);
        inicializaFragmento(frag);
    }

    public void inicializaFragmento(Fragment fragment) {
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.conteudo, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
        finalListener.finish();
    }

}
