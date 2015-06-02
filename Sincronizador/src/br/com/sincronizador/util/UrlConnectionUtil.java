package br.com.sincronizador.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author gilmario
 */
public class UrlConnectionUtil {

    private final Context context;
    private HttpURLConnection conexao;

    public UrlConnectionUtil(Context context) {
        this.context = context;
    }

    public void disconect() {
        if (conexao != null) {
            conexao.disconnect();
        }
    }

    public String getStringConnection() throws MalformedURLException, IOException, Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(conexao.getInputStream(), "UTF-8"));
        StringBuilder resposta = new StringBuilder(br.readLine());
        while (br.ready()) {
            resposta.append(br.readLine());
        }
        br.close();
        disconect();
        return resposta.toString();
    }

    public UrlConnectionUtil connect(String stringUrl) throws MalformedURLException, IOException, Exception {
        if (verificaEstadoConexao()) {
            URL url = new URL(stringUrl);
            conexao = (HttpURLConnection) url.openConnection();
        } else {
            throw new Exception("Você não está conectado.");
        }
        return this;
    }

    public InputStream getStreamConnection() throws IOException {
        return conexao.getInputStream();
    }

    public boolean verificaEstadoConexao() {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (manager != null) {
            NetworkInfo netInfo = manager.getActiveNetworkInfo();
            if (netInfo != null) {
                return (netInfo.getType() == ConnectivityManager.TYPE_WIFI || netInfo.getType() == ConnectivityManager.TYPE_MOBILE);
            }
        }
        return false;

    }

}
