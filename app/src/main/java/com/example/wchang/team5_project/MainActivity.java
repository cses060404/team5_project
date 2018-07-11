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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    public static Controller controller;
    public final String DATA = "Model_File";

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

        loadData();

        /*
        This next code is just to temporalily have some recipes to work with we need to d
        delete this later..
         */

            Recipe newRecipe = new Recipe();
            newRecipe.addDirection("put the pop-tarts in the toaster");
            FoodItem newFoodItem = new FoodItem("Pop-Tarts", 2, "na");
            newRecipe.addFoodItem(newFoodItem);
            newRecipe.setName("Pop-Tarts");
            controller.addRecipe(newRecipe);
            


        //finished temporary recipes

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
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
}