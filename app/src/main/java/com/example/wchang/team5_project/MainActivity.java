package com.example.wchang.team5_project;

import android.content.ClipData;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import google.zxing.integration.android.IntentIntegrator;
import google.zxing.integration.android.IntentResult;

/**
 * Contains the main methods for updating/deleting data, starting activities for new
 * recipes, starting the scanner, and receiving results from the scanner.
 */
public class MainActivity extends AppCompatActivity{

    public static Controller controller;
    public final String DATA = "Model_File";
    private Barcode barcode;
    private RetrievedData data;

    public void loadData() {
        SharedPreferences prefs = getSharedPreferences(DATA, MODE_PRIVATE);
        String jsonString = prefs.getString("model", "");
        Gson gson = new Gson();
        if(jsonString != "") {
            Model restoredModel = gson.fromJson(jsonString, Model.class);
            controller.setModel(restoredModel);
        } else {
            controller.setModel(new Model());
        }
    }

    public void saveData() {
        SharedPreferences.Editor editor = getSharedPreferences(DATA, MODE_PRIVATE).edit();
        Gson gson = new Gson();
        String json = gson.toJson(controller.getModel());
        editor.putString("model", json);
        editor.commit();
        editor.apply();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new Controller(this);
        barcode = new Barcode();
        loadData();

        /*
        This next code is just to temporalily have some recipes to work with we need to d
        delete this later..
         */

        /*
            Recipe newRecipe = new Recipe();
            newRecipe.addDirection("put the pop-tarts in the toaster");
            FoodItem newFoodItem = new FoodItem("Pop-Tarts", 2, "na");
            newRecipe.addFoodItem(newFoodItem);
            newRecipe.setName("Pop-Tarts");
            controller.addRecipe(newRecipe);
            */


        //finished temporary recipes

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

    }


    public void scanningBtn(View v) {
        //start scanning
        if(v.getId() == R.id.scanBtn){
            IntentIntegrator scanIntegrator = new IntentIntegrator(this);
            scanIntegrator.initiateScan();
        }
    }


    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);

        if (scanningResult != null) {
            //Scanning Result
            barcode.setContent(scanningResult.getContents());
            barcode.setFormat(scanningResult.getFormatName());

            //Trying to get data from api
            data = new RetrievedData();
            AsyncLoadItem loadItem = new AsyncLoadItem(barcode, this, data);
            loadItem.execute();
            //item = api.getItem();

            //ItemLoader il = new ItemLoader();
            //il.execute(barcode);
        }
        else{
            Toast toast = Toast.makeText(getApplicationContext(),
                    "No scan data received!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }


    protected void onPause() {
        super.onPause();
        saveData();
    }

    protected void onStart(){
        super.onStart();
    }

    protected void onResume(){
        super.onResume();
        saveData();
    }

    protected void onStop(){
        super.onStop();
        saveData();
    }

    protected void onDestroy() {
        super.onDestroy();
        saveData();
    }

    public void addRecipeBtn(View view) {
        Intent intent = new Intent(this, AddRecipeActivity.class);
        startActivity(intent);
    }

    // Refresh or update data
    public void updateData(View view) {
        EditText foodName = (EditText) findViewById(R.id.name);
        EditText quantity = (EditText) findViewById(R.id.quantity);
        EditText unit = (EditText) findViewById(R.id.unit);
        if (foodName.getText() == null || "".equals(foodName.getText().toString()))
            return;
        if (quantity.getText() == null || "".equals(quantity.getText().toString()))
            return;
        if (unit.getText() == null || "".equals(unit.getText().toString()))
            return;
        //Converts the data items into one continuous string
        //This is in case we ever want to use this
        String item  = quantity.getText().toString() + " " + unit.getText().toString()
                + " " + foodName.getText().toString();
        FoodItem foodItem = new FoodItem(foodName.getText().toString(),
                Float.parseFloat(quantity.getText().toString()),unit.getText().toString());
        controller.addItem(foodItem);
        foodName.setText("");
        quantity.setText("");
        unit.setText("");
        Toast.makeText(this, "Added New Item Successfully", Toast.LENGTH_LONG).show();
        View current = getCurrentFocus();
        if(current != null) current.clearFocus();
    }

    //Deletes food items
    public void deleteData(View view) {
        //It is unclear how the data will be handled here
        EditText foodName = (EditText) findViewById(R.id.name);
        EditText quantity = (EditText) findViewById(R.id.quantity);
        EditText unit = (EditText) findViewById(R.id.unit);
        //This is in case we ever want to use this
        String item  = quantity.getText().toString() + " " + unit.getText().toString()
                + " " + foodName.getText().toString();
        FoodItem foodItem = new FoodItem(foodName.getText().toString(),
                Float.parseFloat(quantity.getText().toString()),unit.getText().toString());
        controller.deleteItem(foodItem);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment selectedFragment = null;

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.navigation_item:
                    selectedFragment = new ItemFragment();
                    break;
                case R.id.navigation_recipe:
                    selectedFragment = new RecipeFragment();
                    break;
                case R.id.navigation_shopping:
                    selectedFragment = new ShoppingFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            return true;
        }
    };

    /*
    public void asyncTestingBtn(View view) {
        data = new RetrievedData();
        AsyncLoadItem a = new AsyncLoadItem(barcode, this, data);
        a.execute();
    }
    */
}