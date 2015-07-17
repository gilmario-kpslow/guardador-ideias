package br.com.sincronizador.servico;

import br.com.sincronizador.negocio.AssuntoNegocio;
import com.google.gson.Gson;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author gilmario
 */
@Path("/assunto")
@Produces(MediaType.APPLICATION_JSON)
public class AssuntoRestService {

    @EJB
    private AssuntoNegocio negocio;

    @GET
    @Path("/lista")
    public String getAssuntos() {
        return new Gson().toJson(negocio.listar());
    }

}
