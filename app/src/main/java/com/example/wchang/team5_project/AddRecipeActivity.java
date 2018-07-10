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

import java.util.Vector;

public class AddRecipeActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 1001;
    private EditText et_name;
    private LinearLayout ll_item;
    private EditText et_direction;
    private String selectedItem;
    private Vector<RequiredItem> items;

    class RequiredItem {
        private String name;
        private String quantity;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getQuantity() {
            return quantity;
        }

        public void setQuantity(String quantity) {
            this.quantity = quantity;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);


        et_name = findViewById(R.id.editText_name);
        ll_item = findViewById(R.id.linearLayout_item);
        et_direction = findViewById(R.id.editText_direction);
        items = new Vector<RequiredItem>();
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
            FoodItem newFoodItem = new FoodItem();
            newFoodItem.setName(items.get(i).getName());
            newFoodItem.setQuantity(items.get(i).getQuantity());
            newRecipe.addFoodItem(newFoodItem);
        }

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
                    RequiredItem newItem = new RequiredItem();
                    newItem.setName(data.getStringExtra("selectedItem"));
                    newItem.setQuantity(data.getStringExtra("selectedItemQuantity"));
                    items.add(newItem);
                    updateItemView();
                }
        }
    }

    public void updateItemView() {
        ll_item.removeAllViewsInLayout();
        for(int i = 0; i < items.size(); i++) {
            TextView tv = new TextView(this);
            tv.setText(items.get(i).getName() + "(" + items.get(i).getQuantity() + ")");
            tv.setTextSize(24);
            tv.setId(i);
            ll_item.addView(tv);
        }
    }
}
