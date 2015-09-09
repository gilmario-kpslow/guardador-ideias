package br.com.sincronizador.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class DialogBuilder {

    public static void mensagemDialogConfirmacao(Context context, String mensagem, DialogInterface.OnClickListener listener, DialogInterface.OnClickListener listenerNegative) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(mensagem);
        builder.setTitle("Confirmação");
        builder.setPositiveButton("Sim", listener);
        builder.setNegativeButton("Não", listenerNegative);
        builder.create().show();
    }

    public static void mensagemDialogConfirmacao(Context context, DialogInterface.OnClickListener listener, String[] opcoes) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Opções");
        builder.setItems(opcoes, listener);
        builder.create().show();
    }

}
