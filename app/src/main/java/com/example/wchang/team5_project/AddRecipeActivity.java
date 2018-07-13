package com.example.wchang.team5_project;

import android.app.Activity;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.Vector;

public class AddRecipeActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 1001;
    private EditText et_name;
    private LinearLayout ll_item;
    private EditText et_direction;
    private String selectedItem;
    private Vector<FoodItem> items;
    private Recipe recipe;
    private int index;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);

        et_name = findViewById(R.id.editText_name);
        ll_item = findViewById(R.id.linearLayout_item);
        et_direction = findViewById(R.id.editText_direction);
        items = new Vector<FoodItem>();



        if(getIntent().getExtras() != null) {
            String json = getIntent().getExtras().getString("recipe");
            Gson gson = new Gson();
            recipe = gson.fromJson(json, Recipe.class);
            index = getIntent().getExtras().getInt("index");
            et_name.setText(recipe.getName());
            items = recipe.getIngredients();
            et_direction.setText(recipe.getDirections().get(0));
        }

    }

    public void addItemBtn(View view) {
        Intent intent = new Intent(this, AddItemToRecipeActivity.class);
        startActivityForResult(intent, REQUEST_CODE);

    }

    public void addRecipeBtn(View view) {
        String name = et_name.getText().toString();
        String direction = et_direction.getText().toString();

        Recipe newRecipe = new Recipe();
        newRecipe.addDirection(direction);
        newRecipe.setName(name);
        for(int i = 0; i < items.size(); i++) {
            newRecipe.addFoodItem(items.get(i));
        }

        if(getIntent().getExtras() != null) {
            MainActivity.controller.deleteRecipe(index);
            MainActivity.controller.getRecipes().insertElementAt(newRecipe, index);
        }
        else
            MainActivity.controller.addRecipe(newRecipe);

        finish();
    }

    public void cancelBtn(View view) {
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateItemView();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode) {
            case REQUEST_CODE:
                if(resultCode == Activity.RESULT_OK) {
                    FoodItem newItem = new FoodItem();
                    newItem.setName(data.getStringExtra("selectedItem"));
                    newItem.setQuantity(data.getStringExtra("selectedItemQuantity"));

                    Vector<FoodItem> pantry = MainActivity.controller.getPantry();
                    int index;
                    for(index = 0; index < pantry.size(); index++) {
                        if(pantry.get(index).getName().equals(newItem.getName()))
                            newItem.setUnit(pantry.get(index).getUnit());
                    }
                    items.add(newItem);
                    updateItemView();
                }
        }
    }

    public void updateItemView() {
        ll_item.removeAllViewsInLayout();
        for(int i = 0; i < items.size(); i++) {
            TextView tv = new TextView(this);
            tv.setText(items.get(i).displayDetail());
            tv.setTextSize(24);
            tv.setId(i);
            ll_item.addView(tv);
        }
    }
}
