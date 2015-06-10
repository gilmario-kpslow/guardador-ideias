package br.com.sincronizador.modelos.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import br.com.sincronizador.R;
import br.com.sincronizador.modelos.Assunto;
import java.util.List;

/**
 *
 * @author gilmario
 */
public class AssuntoAdapter extends ArrayAdapter<Assunto> {

    public AssuntoAdapter(Context context, int resource, List<Assunto> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.lista_assunto_row, null);
        Assunto assunto = getItem(position);
        TextView descricao = (TextView) convertView.findViewById(R.id.descricao_assunto_row);
        descricao.setText(assunto.getDescricao());
        return convertView;
    }

}
