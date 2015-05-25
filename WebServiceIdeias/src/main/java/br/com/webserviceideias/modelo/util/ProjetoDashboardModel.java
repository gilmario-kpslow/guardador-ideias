package br.com.webserviceideias.modelo.util;

import br.com.webserviceideias.modelo.Projeto;
import java.util.ArrayList;
import java.util.List;
import org.primefaces.component.dashboard.Dashboard;
import org.primefaces.model.DashboardColumn;
import org.primefaces.model.DashboardModel;
import org.primefaces.model.DefaultDashboardModel;

/**
 *
 * @author gilmario
 */
public class ProjetoDashboardModel implements DashboardModel {

    private final List<Projeto> listaDeprojetos;

    public ProjetoDashboardModel() {
        this.listaDeprojetos = new ArrayList<>();
    }

    public ProjetoDashboardModel(List<Projeto> listaDeprojetos) {
        this.listaDeprojetos = listaDeprojetos;
    }

    @Override
    public void addColumn(DashboardColumn dc) {

    }

    @Override
    public List<DashboardColumn> getColumns() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DashboardColumn getColumn(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void transferWidget(DashboardColumn dc, DashboardColumn dc1, String string, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
