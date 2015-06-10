package br.com.sincronizador.logica;

import android.content.Context;
import br.com.sincronizador.dao.AssuntoDAO;
import br.com.sincronizador.modelos.Assunto;
import br.com.sincronizador.validacao.ValidaAssunto;
import br.com.sincronizador.validacao.ValidadorManager;

/**
 *
 * @author gilmario
 */
public class AssuntoNegocio extends AbstractNegocio<Assunto> {

    public AssuntoNegocio(Context context) {
        super(new AssuntoDAO(context));
    }

    @Override
    protected AssuntoDAO getDao() {
        return (AssuntoDAO) super.getDao();
    }

    @Override
    protected ValidadorManager getValidatorManager(Assunto t) {
        return new ValidaAssunto(t);
    }

}
