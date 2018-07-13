package com.example.wchang.team5_project;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Vector;

public class DisplayRecipeActivity extends AppCompatActivity {

    private TextView tv_name;
    private LinearLayout ll_items;
    private TextView tv_direction;

    private Recipe recipe;
    private int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_recipe);

        tv_name = findViewById(R.id.textView_recipe_name);
        ll_items = findViewById(R.id.linearLayout_item);
        tv_direction = findViewById(R.id.textView_direction_contents);

        String json = getIntent().getExtras().getString("recipe");
        Gson gson = new Gson();
        recipe = gson.fromJson(json, Recipe.class);
        index = getIntent().getExtras().getInt("position");

        updateView();
    }

    public void updateView() {
        tv_name.setText(recipe.getName());
        ll_items.removeAllViewsInLayout();
        for(int i = 0; i < recipe.getIngredients().size(); i++) {
            TextView tv = new TextView(this);
            tv.setText(recipe.getIngredients().get(i).displayDetail());
            tv.setId(i);
            tv.setTextSize(20);
            ll_items.addView(tv);
        }
        for(int i = 0; i < recipe.getDirections().size(); i++) {
            TextView tv = new TextView(this);
            tv.setText(recipe.getDirections().get(i));
            tv.setId(i);
            tv.setTextSize(20);
            tv_direction.setText(recipe.getDirections().get(i));
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateView();
    }

    public void editBtn(View view) {
        Intent intent = new Intent(this, AddRecipeActivity.class);
        Gson gson = new Gson();
        String json = gson.toJson(recipe);
        intent.putExtra("recipe", json);
        intent.putExtra("index", index);
        startActivity(intent);
    }

    public void deleteBtn(View view) {
        MainActivity.controller.deleteRecipe(index);
        finish();
    }
}