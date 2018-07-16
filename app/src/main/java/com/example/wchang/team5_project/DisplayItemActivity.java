package com.example.wchang.team5_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class DisplayItemActivity extends AppCompatActivity {
FoodItem oldFoodItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_item);
        oldFoodItem = new FoodItem("placeholder",1,"na");
    }

    public void deleteBtn(View view) {
        MainActivity.controller.deleteItem(oldFoodItem);
        Toast.makeText(this, "Item Deleted!", Toast.LENGTH_LONG).show();
        finish();
    }
}
