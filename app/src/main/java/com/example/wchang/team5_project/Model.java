package com.example.wchang.team5_project;

import java.util.Vector;

/**
 *   Model Class used to maintain the data of the app. It keeps a FoodItem vector to represent
 *   your pantry and a Recipe vector. This data is modified through Controller.
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
