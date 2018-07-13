package com.example.wchang.team5_project;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AsyncLoadItem extends AsyncTask<Void, Void, String> {

    private Barcode barcode;
    private Activity activity;


    public AsyncLoadItem(Barcode barcode, Activity activity) {
        this.barcode = barcode;
        this.activity = activity;
    }

    @Override
    protected String doInBackground(Void... voids) {

        try {
            //this is a sample api
            String s = "https://api.barcodelookup.com/v2/products?barcode=9780140157376&formatted=y&key=tk1qu2huudl9znmbr894o1cr9gc1yy";
            URL url = new URL(s);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line = "";
            String allLines = "";   //store JSON String into here
            publishProgress();
            do {
                line = reader.readLine();
                if (line != null) {
                    allLines += line;
                }
            }
            while (line != null);

            connection.disconnect();

            return allLines;

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return "Something Went Wrong!";
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
        Toast.makeText(activity, "Loading Data...", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPostExecute(String s) {
        Gson gson = new Gson();
        Toast.makeText(activity, "Loading Completed!", Toast.LENGTH_SHORT).show();
        Toast.makeText(activity, s, Toast.LENGTH_LONG).show();
    }
}
