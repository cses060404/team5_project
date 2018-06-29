package com.example.wchang.team5_project;

import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AsyncLoadItem extends AsyncTask<Void, Void, String> {

    private String barcode;
    private FoodItem foodItem;


    public AsyncLoadItem(String barcode, FoodItem foodItem) {
        this.barcode = barcode;
        this.foodItem = foodItem;
    }

    @Override
    protected String doInBackground(Void... voids) {

        try {
            //this is a sample api
            String s = "https://api.upcdatabase.org/product/0111222333446/098f6bcd4621d373cade4e832627b4f6";
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
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String s) {
        Gson gson = new Gson();
        foodItem = gson.fromJson(s, FoodItem.class);
    }
}
