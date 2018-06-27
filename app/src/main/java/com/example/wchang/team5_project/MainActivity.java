package com.example.wchang.team5_project;

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

public class MainActivity extends AppCompatActivity {

    Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new Controller(this);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
    }

    protected void onPause() {
        super.onPause();
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

    public void addRecipeBtn(View view) {
        Intent intent = new Intent(this, AddRecipeActivity.class);
        startActivity(intent);
    }

    // Refresh or update data
    public void updateData(View view) {
        EditText foodName = (EditText) findViewById(R.id.name);
        EditText quantity = (EditText) findViewById(R.id.quantity);
        EditText unit = (EditText) findViewById(R.id.unit);
        //Converts the data items into one continuous string
        //This is in case we ever want to use this
        String item  = quantity.getText().toString() + " " + unit.getText().toString()
                + " " + foodName.getText().toString();
        FoodItem foodItem = new FoodItem(foodName.getText().toString(),
                Float.parseFloat(quantity.getText().toString()),unit.getText().toString());
        controller.addItem(foodItem);
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