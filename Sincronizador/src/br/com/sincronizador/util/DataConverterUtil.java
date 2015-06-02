package br.com.sincronizador.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author gilmario
 */
public class DataConverterUtil {

    private final SimpleDateFormat simpleDateFormat;

    public DataConverterUtil() {
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", new Locale("pt", "pt_BR"));
    }

    public Date converte(Long miliseconds) {
        if (miliseconds != null) {
            return new Date(miliseconds);
        }
        return null;
    }

    public Long parseData(Date dataCadastro) {
        if (dataCadastro != null) {
            return dataCadastro.getTime();
        }
        return null;
    }
}
