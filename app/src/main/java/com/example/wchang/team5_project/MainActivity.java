package com.example.wchang.team5_project;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        readSharedPreferances();
    }

    protected void onPause() {
        super.onPause();
        sriteSharedPreferences();
    }

    protected void onStart(){
        super.onStart();
    }

    protected void onResume(){
        super.onResume();
    }



    protected void onStop(){
        super.onStop();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    private void writeShareddPreferences(){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(SP;
        editor.commit();
    }
    private void readSharedPreferences(){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        String ... = sp.getString(...);
        ...
        }
}
//This is Darren's comment 2