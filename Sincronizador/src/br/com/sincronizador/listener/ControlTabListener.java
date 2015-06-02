package br.com.sincronizador.listener;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;

/**
 *
 * @author gilmario
 */
public class ControlTabListener implements ActionBar.TabListener {

    private final Fragment fragment;
    private ActionBar actionBar;

    public ControlTabListener(Fragment fragment, ActionBar actionBar) {
        this.fragment = fragment;
        this.actionBar = actionBar;

    }

    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

}
