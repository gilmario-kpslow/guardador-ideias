package br.com.gilmariosoftware.webserviceideias.util.diversos;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;

/**
 *
 * @author gilmario
 */
public class StringHashUtil {

    public static String geraHash(String frase) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String hash = frase.concat(Calendar.getInstance().toString());
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(hash.getBytes("UTF-8"));
        StringBuilder hexString = new StringBuilder();
        for (byte b : md.digest()) {
            hexString.append(String.format("%02X", 0xFF & b));
        }
        return hexString.toString();
    }

    public static String convertMD5(String frase) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(frase.getBytes("UTF-8"));
        StringBuilder hexString = new StringBuilder();
        for (byte b : md.digest()) {
            hexString.append(String.format("%02X", 0xFF & b));
        }
        return hexString.toString();
    }

}
