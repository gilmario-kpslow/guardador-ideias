package br.com.sincronizador;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import br.com.sincronizador.listener.DrawableLayoutListenerImplement;
import br.com.sincronizador.listener.FinalListener;
import br.com.sincronizador.listener.MainFragmentController;

public class PrincipalActivity extends Activity {

    private DrawerLayout drawerLayout;
    private ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final ActionBar actionBar = getActionBar();
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        drawerLayout.setDrawerListener(new DrawableLayoutListenerImplement(actionBar));
        listView = (ListView) findViewById(R.id.lista_opcoes);
        ListAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, new String[]{"Cadastra Assunto", "Lista de Assuntos"});
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new MainFragmentController(getFragmentManager(), new FinalListener() {

            public void finish() {
                drawerLayout.closeDrawer(listView);
            }
        }));
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
