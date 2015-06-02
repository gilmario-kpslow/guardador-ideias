package br.com.sincronizador.listener;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.View;
import android.widget.AdapterView;
import br.com.sincronizador.R;
import br.com.sincronizador.fragmento.CadastraAssuntoFragment;

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
        FragmentTransaction transaction = manager.beginTransaction();
        if (position == 0) {
            transaction.replace(R.id.conteudo, new CadastraAssuntoFragment());
            transaction.addToBackStack(null);
        }
        if (position == 1) {
            //transaction.replace(R.id.conteudo, new ListaAssunto());
            transaction.addToBackStack(null);
        }
        transaction.commit();
        finalListener.finish();
    }

}
