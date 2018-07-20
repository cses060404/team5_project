package com.example.wchang.team5_project;

import android.app.Activity;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.Vector;

public class AddRecipeActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 1001;
    public static final int REQUEST_CODE_2 = 1010;
    private EditText et_name;
    private LinearLayout ll_item;
    private EditText et_direction;
    private String selectedItem;
    private Vector<FoodItem> items;
    private Recipe recipe;

    private int index;               //Represent the position of item that is click by previews list page
    private boolean isModifiedPage;  //Allow the code to know if it is a adding page or editing page


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);

        //assign the variable and layout
        et_name = findViewById(R.id.editText_name);
        ll_item = findViewById(R.id.linearLayout_item);
        et_direction = findViewById(R.id.editText_direction);
        items = new Vector<FoodItem>();

        isModifiedPage = (getIntent().getExtras() != null);

        //if it is editing page, change some layout attribute to display the correct page
        if(isModifiedPage) {
            String json = getIntent().getExtras().getString("recipe");
            //Use JSON to retrieve the object from previews activiy
            Gson gson = new Gson();
            recipe = gson.fromJson(json, Recipe.class);
            index = getIntent().getExtras().getInt("index");
            et_name.setText(recipe.getName());
            items = recipe.getIngredients();
            et_direction.setText(recipe.getDirections().get(0));
            ((TextView)findViewById(R.id.textView_title)).setText("Edit Recipe");
            ((Button)findViewById(R.id.button_add)).setText("SAVE");
        }

    }

    //Start the other activity to add item into new recipe
    public void addItemBtn(View view) {
        Intent intent = new Intent(this, AddItemToRecipeActivity.class);
        startActivityForResult(intent, REQUEST_CODE);

    }

    //Validate the adding or editing page if the text field is empty or not
    public boolean validateForm() {
        if(et_name.getText().toString().matches("")) {
            Toast.makeText(this, "Please Enter The Recipe Name!", Toast.LENGTH_SHORT).show();
            et_name.requestFocus();
            return false;
        }
        else if(items.size() == 0) {
            Toast.makeText(this, "Please Enter At Least 1 Item!", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(et_direction.getText().toString().matches("")) {
            Toast.makeText(this, "Please Enter The Direction!", Toast.LENGTH_SHORT).show();
            et_direction.requestFocus();
            return false;
        }
        else {
            if(isModifiedPage) {
                Toast.makeText(this, "Recipe Saved!", Toast.LENGTH_LONG).show();
            }
            else
                Toast.makeText(this, "Recipe Added!", Toast.LENGTH_LONG).show();
            return true;
        }
    }

    //Save the adding or editing page information into recipes array
    public void addRecipeBtn(View view) {
        if(validateForm()) {
            String name = et_name.getText().toString();
            String direction = et_direction.getText().toString();

            Recipe newRecipe = new Recipe();
            newRecipe.addDirection(direction);
            newRecipe.setName(name);
            for (int i = 0; i < items.size(); i++) {
                newRecipe.addFoodItem(items.get(i));
            }

            //do save process if it is editing page
            if (isModifiedPage) {
                MainActivity.controller.deleteRecipe(index);
                MainActivity.controller.getRecipes().insertElementAt(newRecipe, index);
            } else
                MainActivity.controller.addRecipe(newRecipe);

            finish();
        }
    }

    //just finish the activity without other action
    public void cancelBtn(View view) {
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateItemView();
    }

    //Retrieve the data from next activity and add them into the item of the new recipe
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode) {
            case REQUEST_CODE:
                if(resultCode == Activity.RESULT_OK) {
                    FoodItem newItem = new FoodItem();
                    newItem.setName(data.getStringExtra("selectedItem"));
                    newItem.setQuantity(data.getStringExtra("selectedItemQuantity"));
                    newItem.setUnit("");

                    boolean isNewItem = true;
                    for(int i = 0; i < items.size(); i++) {
                        if(newItem.getName().toLowerCase().equals(items.get(i).getName().toLowerCase())) {
                            isNewItem = false;
                            items.get(i).setQuantity(items.get(i).getQuantity() + newItem.getQuantity());
                        }
                    }
                    Vector<FoodItem> pantry = MainActivity.controller.getPantry();
                    int index;
                    for(index = 0; index < pantry.size(); index++) {
                        if(pantry.get(index).getName().equals(newItem.getName()))
                            newItem.setUnit(pantry.get(index).getUnit());
                    }

                    if(isNewItem) {
                        items.add(newItem);
                    }

                    updateItemView();
                }

            case REQUEST_CODE_2:
                if(resultCode == Activity.RESULT_OK) {
                    if(data.getExtras().getBoolean("isDeleted")) {
                        items.remove(data.getExtras().getInt("index"));
                    }
                    else {
                        int index = data.getExtras().getInt("index");
                        String name = data.getExtras().getString("selectedItem");
                        String quantity = data.getExtras().getString("selectedItemQuantity");

                        items.get(index).setName(name);
                        items.get(index).setQuantity(quantity);
                    }

                    updateItemView();
                }
        }
    }

    //Display the items list correctly
    public void updateItemView() {
        ll_item.removeAllViewsInLayout();
        for(int i = 0; i < items.size(); i++) {
            TextView tv = new TextView(this);
            tv.setText(items.get(i).displayDetail());
            tv.setTextSize(24);
            tv.setId(i);

            final int finalI = i;
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), AddItemToRecipeActivity.class);

                    Gson gson = new Gson();
                    String json = gson.toJson(items.get(finalI));

                    intent.putExtra("item", json);
                    intent.putExtra("index", finalI);

                    startActivityForResult(intent, REQUEST_CODE_2);
                }
            });
            ll_item.addView(tv);
        }
    }
}
