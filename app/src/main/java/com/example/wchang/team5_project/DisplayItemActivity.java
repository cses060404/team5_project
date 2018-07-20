package com.example.wchang.team5_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.TextView;

/**
 * Displays the items added onto the recipe
 */
public class DisplayItemActivity extends AppCompatActivity {

    private FoodItem oldFoodItem;
    private TextView item_name;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_item);
        item_name = findViewById(R.id.itemName);
        index = getIntent().getExtras().getInt("position");

        updateView();
    }

    public void updateView(){
        oldFoodItem = MainActivity.controller.getPantry().get(index);
        item_name.setText(oldFoodItem.getName());
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateView();
    }

    public void deleteBtn(View view) {
        MainActivity.controller.deleteItem(oldFoodItem);
        Toast.makeText(this, "Item Deleted!", Toast.LENGTH_LONG).show();
        finish();
    }
}
