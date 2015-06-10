package br.com.sincronizador.listener;

import android.app.ActionBar;
import android.support.v4.widget.DrawerLayout;
import android.view.View;

/**
 *
 * @author gilmario
 */
public class DrawableLayoutListenerImplement implements DrawerLayout.DrawerListener {

    private final ActionBar actionBar;

    public DrawableLayoutListenerImplement(ActionBar actionBar) {
        this.actionBar = actionBar;
    }

    public void onDrawerSlide(View view, float f) {
    }

    public void onDrawerOpened(View view) {
        //actionBar.hide();
    }

    public void onDrawerClosed(View view) {
        //actionBar.show();
    }

    public void onDrawerStateChanged(int i) {

    }

}
