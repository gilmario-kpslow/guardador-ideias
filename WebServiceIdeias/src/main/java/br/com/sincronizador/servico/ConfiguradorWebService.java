package br.com.sincronizador.servico;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author gilmario
 */
@ApplicationPath("/webservice")
public class ConfiguradorWebService extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<>();
        classes.add(AssuntoRestService.class);
        return classes;
    }

}
