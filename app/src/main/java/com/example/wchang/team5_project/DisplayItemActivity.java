package com.example.wchang.team5_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;
import android.widget.TextView;

/**
 *   Display Item Activity is opened when the onClick event listener is called from HomeFragment.
 *   It displays the chosen FoodItem and allows you to modify its name or delete it.
 */
public class DisplayItemActivity extends AppCompatActivity {

    private FoodItem oldFoodItem;
    private TextView item_name;
    int index;
    private Boolean isItemDeleted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_item);
        item_name = findViewById(R.id.itemName);
        index = getIntent().getExtras().getInt("position");
        isItemDeleted = false;

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
        isItemDeleted = true;
        Toast.makeText(this, "Item Deleted!", Toast.LENGTH_LONG).show();
        finish();
    }

    public void onPause(){
        super.onPause();
        if(!isItemDeleted)
            MainActivity.controller.getPantry().get(index).name = item_name.getText().toString().toUpperCase();
    }
}
