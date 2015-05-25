package br.com.gilmariosoftware.webserviceideias.modelo.util;

import br.com.gilmariosoftware.webserviceideias.modelo.Projeto;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.primefaces.model.DashboardColumn;

/**
 *
 * @author gilmario
 */
public class ProjetoColumn implements DashboardColumn {

    private final Projeto projeto;
    private final List<String> widgets;

    public ProjetoColumn(Projeto projeto) {
        this.projeto = projeto;
        this.widgets = new LinkedList<>();
    }

    @Override
    public void removeWidget(String id) {
        widgets.remove(id);
    }

    @Override
    public List<String> getWidgets() {
        return Collections.unmodifiableList(widgets);
    }

    @Override
    public int getWidgetCount() {
        return widgets.size();
    }

    @Override
    public String getWidget(int i) {
        return widgets.get(i);
    }

    @Override
    public void addWidget(String string) {
        this.widgets.add(string);
    }

    @Override
    public void addWidget(int i, String string) {
        this.widgets.add(i, string);
    }

    @Override
    public void reorderWidget(int i, String string) {
        widgets.remove(string);
        addWidget(i, string);
    }

}
