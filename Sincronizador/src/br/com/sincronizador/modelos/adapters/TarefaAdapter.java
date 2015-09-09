package br.com.sincronizador.modelos.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import br.com.sincronizador.R;
import br.com.sincronizador.modelos.Tarefa;
import java.util.List;

/**
 *
 * @author gilmario
 */
public class TarefaAdapter extends ArrayAdapter<Tarefa> {

    public TarefaAdapter(Context context, int resource, List<Tarefa> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.lista_tarefa_row, null);
        Tarefa tarefa = getItem(position);
        TextView titulo = (TextView) convertView.findViewById(R.id.titulo_tarefa_row);
        titulo.setText(tarefa.getTitulo());
        TextView descricao = (TextView) convertView.findViewById(R.id.descricao_tarefa_row);
        descricao.setText(tarefa.getDescricao());
        return convertView;
    }

}
