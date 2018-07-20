package com.example.wchang.team5_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.Vector;

/**
 * Displays the shopping list.
 */
public class DisplayShoppingList extends AppCompatActivity {
private Vector <FoodItem> rc;
public String shoppingList;
public TextView tv;
   // @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_shopping_list);
        tv = findViewById(R.id.shoppingListView);
        int p = ShoppingFragment.getPosition();
        Recipe data = MainActivity.controller.getRecipes().get(p);
        rc = MainActivity.controller.makeList(data);
        shoppingList = "";

        for (int i = 0; i < rc.size(); i++)
        {
            shoppingList += rc.get(i).name + " " + rc.get(i).quantity + " \n";
        }
        if (shoppingList != "")
        {
            tv.setText(shoppingList);
        }
        else
            tv.setText("You don't need anything!!");
    }
}
