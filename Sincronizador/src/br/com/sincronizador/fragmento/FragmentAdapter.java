package br.com.sincronizador.fragmento;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import br.com.sincronizador.R;

/**
 *
 * @author gilmario
 */
public class FragmentAdapter extends ArrayAdapter<SincronizadorFragmento> {

    public FragmentAdapter(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.fragmento_row, null);
        TextView nomeFragmento = (TextView) convertView.findViewById(R.id.nome_fragmento_row);
        nomeFragmento.setText(getItem(position).getNome());
        return convertView;
    }

}
