package br.com.sincronizador.util;

import android.content.Context;
import android.os.AsyncTask;
import br.com.sincronizador.listener.ServiceListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gilmario
 */
public class WebServiceUtil extends AsyncTask<String, Void, String> {

    private final ServiceListener<String> listener;
    private final Context context;

    public WebServiceUtil(Context context, ServiceListener listener) {
        this.context = context;
        this.listener = listener;
    }

    @Override
    protected String doInBackground(String... parametros) {
        try {
            return new UrlConnectionUtil(context).connect(parametros[0]).getStringConnection();
        } catch (Exception ex) {
            Logger.getLogger(WebServiceUtil.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    protected void onPostExecute(String result) {
        listener.process(result);
    }

}
