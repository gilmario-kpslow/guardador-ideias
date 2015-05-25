package br.com.gilmariosoftware.webserviceideias.dao.generic;

import br.com.gilmariosoftware.webserviceideias.modelo.Projeto;
import br.com.gilmariosoftware.webserviceideias.modelo.util.ProjetoDashboardModel;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.primefaces.model.DashboardColumn;
import org.primefaces.model.DashboardModel;
import org.primefaces.model.DefaultDashboardColumn;
import org.primefaces.model.DefaultDashboardModel;

/**
 *
 * @author gilmario
 */
@Stateless
public class ProjetoRepositorio extends DAORepositorio<Projeto, Long> implements Serializable {

    public ProjetoRepositorio() {
        super(Projeto.class);
    }

    public Integer contar() {
        CriteriaBuilder b = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Projeto> q = b.createQuery(Projeto.class);
        q.from(Projeto.class);
        return getEntityManager().createQuery(q).getResultList().size();
    }

    public DashboardModel getModel() {
        List<Projeto> projetos = encontrarTodas();
        DashboardModel model = new DefaultDashboardModel();
        for (Projeto p : projetos) {
            DashboardColumn column = new DefaultDashboardColumn();
            column.addWidget(p.getNome());
            model.addColumn(column);
        }
        return model;
    }

}
