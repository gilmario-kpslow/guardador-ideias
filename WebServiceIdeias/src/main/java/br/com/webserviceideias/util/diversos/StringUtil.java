/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.webserviceideias.util.diversos;

/**
 *
 * @author gilmario
 */
public class StringUtil {

    public static String capitalizar(String texto) {
        if (texto.length() > 0) {
            texto = texto.substring(0, 1).toUpperCase() + texto.substring(1);
        }
        if (texto.length() > 1) {
            texto = texto.substring(0, 1) + texto.substring(1).toLowerCase();
        }
        return texto;
    }
}
