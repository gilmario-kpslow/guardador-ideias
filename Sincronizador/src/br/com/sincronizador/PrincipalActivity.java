package br.com.sincronizador;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import br.com.sincronizador.fragmento.CadastraAssuntoFragment;
import br.com.sincronizador.fragmento.CadastraTarefaFragment;
import br.com.sincronizador.fragmento.FragmentAdapter;
import br.com.sincronizador.fragmento.ListaAssuntoFragment;
import br.com.sincronizador.fragmento.ListaTarefaFragment;
import br.com.sincronizador.listener.DrawableLayoutListenerImplement;
import br.com.sincronizador.listener.FinalListener;
import br.com.sincronizador.listener.MainFragmentController;

public class PrincipalActivity extends Activity {

    private DrawerLayout drawerLayout;
    private ListView listView;
    private MainFragmentController main;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final ActionBar actionBar = getActionBar();
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        drawerLayout.setDrawerListener(new DrawableLayoutListenerImplement(actionBar));
        listView = (ListView) findViewById(R.id.lista_opcoes);
        main = new MainFragmentController(getFragmentManager(), new FinalListener() {

            public void finish() {
                drawerLayout.closeDrawer(listView);
            }
        });
        FragmentAdapter adapter = new FragmentAdapter(this, R.layout.fragmento);
        adapter.add(new CadastraAssuntoFragment());
        adapter.add(new ListaAssuntoFragment(main));
        adapter.add(new CadastraTarefaFragment());
        adapter.add(new ListaTarefaFragment(main));
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_admin, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        drawerLayout.openDrawer(listView);
        return true;
    }

}
