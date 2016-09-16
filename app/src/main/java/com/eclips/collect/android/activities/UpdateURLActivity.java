package com.eclips.collect.android.activities;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

import com.eclips.collect.android.R;
import com.eclips.collect.android.application.Collect;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by IntegracaoMT on 21/12/2015.
 */
public class UpdateURLActivity extends Activity {
    public static final String KEY_USERNAME = "username";

    // Progress Dialog
    private ProgressDialog pDialog;
    public static final int progress_bar_type = 0;

    // File url to download


    //@Override
    public void onCreate(Bundle b) {
        b = getIntent().getExtras();
        super.onCreate(b);
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        String user = sp.getString(KEY_USERNAME, "");
        String arq = "";
        arq = b.getString("arq");


        setContentView(R.layout.update_activity);

        Toast.makeText(getApplicationContext(), "Atualizando: " + user + "/" + arq, Toast.LENGTH_LONG).show();

        DownloadFileFromURL downURL = new DownloadFileFromURL();
        downURL.execute(arq, user);

    }

    /**
     * Showing Dialog
     * */

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case progress_bar_type: // we set this to 0
                pDialog = new ProgressDialog(this);
                pDialog.setMessage("Atualizando arquivos. Aguarde...");
                pDialog.setIndeterminate(false);
                pDialog.setMax(100);
                pDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                pDialog.setCancelable(true);
                pDialog.setCanceledOnTouchOutside(false);
                pDialog.show();
                return pDialog;
            default:
                return null;
        }
    }

    /**
     * Background Async Task to download file
     * */
    final class DownloadFileFromURL extends AsyncTask<Object, String, String> {

        /**
         * Before starting background thread Show Progress Bar Dialog
         * */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            showDialog(progress_bar_type);
        }

        /**
         * Downloading file in background thread
         * */
        @Override
        protected String doInBackground(Object... params) {
            int count;
            try {
                String url_base = "http://projetoradisunb.com.br/aplicativo/mbtiles/";
                String arq_ext = (String) params[0];
                String usr_ext = (String) params[1];
                URL url = new URL(url_base + arq_ext);
                //URL url = new URL(url_base + usr_ext + "/" + arq_ext);
                URLConnection conection = url.openConnection();
                conection.connect();

                // this will be useful so that you can show a tipical 0-100%
                // progress bar
                int lenghtOfFile = conection.getContentLength();

                // download the file
                InputStream input = new BufferedInputStream(url.openStream(),
                        8192);

                // Output stream
                OutputStream output = new FileOutputStream(Collect.OFFLINE_LAYERS.toString()
                        + "/" + arq_ext);

                byte data[] = new byte[1024];

                long total = 0;

                while ((count = input.read(data)) != -1) {
                    total += count;
                    // publishing the progress....
                    // After this onProgressUpdate will be called
                    publishProgress("" + (int) ((total * 100) / lenghtOfFile));

                    // writing data to file
                    output.write(data, 0, count);
                }

                // flushing output
                output.flush();

                // closing streams
                output.close();
                input.close();

            } catch (Exception e) {
                Log.e("Erro: ", e.getMessage());

            }

            return null;
        }

        /**
         * Updating progress bar
         * */
        protected void onProgressUpdate(String... progress) {
            // setting progress percentage
            pDialog.setProgress(Integer.parseInt(progress[0]));
        }

        /**
         * After completing background task Dismiss the progress dialog
         * **/
        @Override
        protected void onPostExecute(String file_url) {
            // dismiss the dialog after the file was downloaded
            dismissDialog(progress_bar_type);
            System.exit(0);

        }

    }
}