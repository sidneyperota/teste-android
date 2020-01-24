package com.example.testefinanceiro.servidor;

import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class HTTPService extends AsyncTask<Void, Void, String  > {


    @Override
    protected String doInBackground(Void... voids) {

        //StringBuilder resposta = new StringBuilder();

        String resposta = "Sidney";

        try {


            //URL url = new URL("http://localhost:8080/api.php");

            //URL url = new URL("http://ws.matheuscastiglioni.com.br/ws/cep/find/27283035/json/");

            URL url = new URL("https://sifrapec.000webhostapp.com/api.php");



            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            //urlConnection.setRequestMethod("GET");
            //urlConnection.setRequestProperty("Accept", "application/json");
            //urlConnection.setConnectTimeout(5000);

            urlConnection.connect();

            InputStream stream = urlConnection.getInputStream();


            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));


            resposta = reader.readLine();

            /*

            //Scanner scanner = new Scanner(  url.openStream() );

            while ( scanner.hasNext() ) {
               // resposta.append(scanner.next() );
            }   */


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

      return resposta.toString();
    }
}
