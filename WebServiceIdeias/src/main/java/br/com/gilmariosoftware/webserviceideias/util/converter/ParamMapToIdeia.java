/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gilmariosoftware.webserviceideias.util.converter;

import br.com.gilmariosoftware.webserviceideias.modelo.Ideia;
import java.util.Calendar;
import java.util.Map;

/**
 *
 * @author gilmario
 */
public class ParamMapToIdeia {

    private final Map parametros;
    private static final String ID_IDEIA = "id_ideia";
    private static final String DATA_CADASTRO_IDEIA = "data_cadastro_ideia";
    private static final String DESCRICAO_IDEIA = "data_cadastro_ideia";
    private static final String STATUS_IDEIA = "status_ideia";
    private static final String TITULO_IDEIA = "titulo_ideia";

    public ParamMapToIdeia(Map parametros) {
        this.parametros = parametros;
    }

    public Ideia processa() {
        Ideia ideia = new Ideia();
        ideia.setId((Long) processaParametro(ID_IDEIA));
        ideia.setDataCadastro((Calendar) processaParametro(DATA_CADASTRO_IDEIA));
        ideia.setDescricao((String) processaParametro(DESCRICAO_IDEIA));
        ideia.setStatus(Ideia.StatusIdeia.valueOf((String) processaParametro(STATUS_IDEIA)));
        ideia.setTitulo((String) processaParametro(TITULO_IDEIA));
        return ideia;
    }

    private Object processaParametro(String nome) {
        if (parametros.containsKey(nome)) {
            return parametros.get(nome);
        } else {
            return null;
        }
    }
}
