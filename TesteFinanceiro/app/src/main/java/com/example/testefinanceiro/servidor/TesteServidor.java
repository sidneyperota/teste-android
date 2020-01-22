package com.example.testefinanceiro.servidor;

import com.example.testefinanceiro.MainActivity;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutionException;

import javax.net.ssl.HttpsURLConnection;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class TesteServidor {


    public void obterDadosServidor() {


        /*

       URL url;

        try {
            url = new URL("http://localhost:8080/api.php");

            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            InputStream in = new BufferedInputStream(urlConnection.getInputStream());


            OkHttpClient client = new OkHttpClient();

            String sUrl = "http://localhost:8080/api.php";

            Request request = new Request.Builder().url(sUrl).build();





        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    */


    HTTPService httpService = new HTTPService();
        try {


            String str = httpService.execute().get();

            System.out.println( "Caixas"+ str );


        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }




}
