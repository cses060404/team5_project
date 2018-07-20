package com.example.wchang.team5_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.Vector;

/**
 * This activity is created for displaying the shopping list generated after comparing what you need to buy for a recipe.
 */
public class DisplayShoppingList extends AppCompatActivity {
private Vector <FoodItem> rc;
public String shoppingList;
public TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_shopping_list);

        // This connects the local TextView variable to the shoppingListView.
        tv = findViewById(R.id.shoppingListView);
        //The function returns the position of the recipe being selected in an int value.
        int p = ShoppingFragment.getPosition();

        //This finds the recipe by the p value and then assign the recipe to a local variable data.
        Recipe data = MainActivity.controller.getRecipes().get(p);

        //It passes the recipe to the makeList Function and return the items needed as a Vector and assign it to the rc vector.
        rc = MainActivity.controller.makeList(data);
        shoppingList = "";
        //This for loop go through each item in the FoodItem Vector and make the string list for display.
        for (int i = 0; i < rc.size(); i++)
        {
            shoppingList += rc.get(i).name + " " + rc.get(i).quantity + " \n";
        }

        // If the list if not empty, then display the list; otherwise, display "You don't need anything."
        if (shoppingList != "")
        {
            //This setText sets the string to the text field in the view.
            tv.setText("You need: \n" + shoppingList);
        }
        else
            //This setText sets the string to the text field in the view.
            tv.setText("You don't need anything!!");
    }
}
