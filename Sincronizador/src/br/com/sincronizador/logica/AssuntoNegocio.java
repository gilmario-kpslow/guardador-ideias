package br.com.sincronizador.logica;

import android.content.Context;
import br.com.sincronizador.dao.AssuntoDAO;
import br.com.sincronizador.dao.DAO;
import br.com.sincronizador.modelos.Assunto;
import br.com.sincronizador.validacao.ValidaAssunto;
import br.com.sincronizador.validacao.excecao.ValidationExection;

/**
 *
 * @author gilmario
 */
public class AssuntoNegocio extends AbstractNegocio<Assunto> {

    public AssuntoNegocio(Context context) {
        super(new AssuntoDAO(context));
    }

    @Override
    public AssuntoDAO getDao() {
        return (AssuntoDAO) super.getDao();
    }

    @Override
    protected boolean validaEntidade(Assunto t) throws ValidationExection {
        return new ValidaAssunto(t).validar();
    }

}
