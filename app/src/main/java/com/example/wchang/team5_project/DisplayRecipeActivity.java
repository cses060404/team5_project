package com.example.wchang.team5_project;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Vector;

/**
 * public class DisplayRecipeActivity
 *      Start the new page which can display the selected recipe information
 */
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

        //convert the json string into object from previews activity
        String json = getIntent().getExtras().getString("recipe");
        Gson gson = new Gson();
        recipe = gson.fromJson(json, Recipe.class);
        index = getIntent().getExtras().getInt("position");

        updateView();
    }

    /**
     * public void updateView()
     *      display the view correctly
     */
    public void updateView() {
        recipe = MainActivity.controller.getRecipes().get(index);
        tv_name.setText(recipe.getName());
        ll_items.removeAllViewsInLayout();
        for(int i = 0; i < recipe.getIngredients().size(); i++) {
            TextView tv = new TextView(this);
            tv.setText(recipe.getIngredients().get(i).displayDetail());
            tv.setId(i);
            tv.setTextSize(20);
            ll_items.addView(tv);
        }

        //Even though we have an array to store our directions, but we only use one string to store them.
        //just run the for loop in case
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

    /**\
     * public void editBtn
     * @param view
     *     Start the activity to edit the recipe
     */
    public void editBtn(View view) {
        Intent intent = new Intent(this, AddRecipeActivity.class);
        //sending the data with json string
        Gson gson = new Gson();
        String json = gson.toJson(recipe);
        intent.putExtra("recipe", json);
        intent.putExtra("index", index);
        startActivity(intent);
    }

    /**
     * public void deleteBtn
     * @param view
     *     delete the selected recipe
     */
    public void deleteBtn(View view) {
        MainActivity.controller.deleteRecipe(index);
        Toast.makeText(this, "Recipe Deleted!", Toast.LENGTH_LONG).show();
        finish();
    }
}
