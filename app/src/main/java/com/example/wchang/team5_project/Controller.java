package com.example.wchang.team5_project;

import android.app.Activity;

public class Controller {
    Model model;
    Activity mainActivity;

    Controller(Activity mainActivity){
        this.mainActivity = mainActivity;
    }

    void addItem(FoodItem newItem){
        model.pantry.add(newItem);
    }

    void addRecipe(Recipe newRecipe){
        model.recipes.add(newRecipe);
    }
}
