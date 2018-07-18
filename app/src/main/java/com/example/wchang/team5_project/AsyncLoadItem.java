package com.example.wchang.team5_project;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AsyncLoadItem extends AsyncTask<Void, Void, String> {

    private Barcode barcode;
    private Activity activity;
    private RetrievedData result;


    public AsyncLoadItem(Barcode barcode, Activity activity, RetrievedData data) {
        this.barcode = barcode;
        this.activity = activity;
        result = data;
    }

    @Override
    protected String doInBackground(Void... voids) {

        try {
            //this is a sample api
            String s = "https://api.nutritionix.com/v1_1/item?upc=" + barcode.getContent() + "&appId=72991a57&appKey=483a7a789931c3da312222b79ca986c3";
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
        Toast.makeText(activity, "Loading Data...", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPostExecute(String s) {
        if(s != null) {
            Gson gson = new Gson();
            result = gson.fromJson(s, RetrievedData.class);
            Toast.makeText(activity, "Loading Completed!", Toast.LENGTH_SHORT).show();
            Toast.makeText(activity, result.getItemName(), Toast.LENGTH_LONG).show();

        /*
        Intent intent = new Intent(activity, DisplayResultActivity.class);
        intent.putExtra("result", s);
        activity.startActivity(intent);
        */


            ((TextView) activity.findViewById(R.id.name)).setText(result.getItemName());
        } else {
            Toast.makeText(activity, "Sorry, we cannot find the data from our database!", Toast.LENGTH_LONG).show();
        }
    }
}
