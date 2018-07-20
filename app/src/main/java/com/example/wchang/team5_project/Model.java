package com.example.wchang.team5_project;

import java.util.Vector;

/**
 * For this app's MVC design, this class deals with the data in the app.
 */
public class Model {
    Vector<FoodItem> pantry;
    Vector<Recipe> recipes;

    public Model() {
        pantry = new Vector<FoodItem>();
        recipes = new Vector<Recipe>();
    }

    public void addRecipe(Recipe newRecipe) {
        recipes.add(newRecipe);
    }


}
