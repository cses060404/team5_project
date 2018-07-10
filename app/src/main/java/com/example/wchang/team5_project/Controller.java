package com.example.wchang.team5_project;

import android.app.Activity;

import java.io.Serializable;
import java.util.Vector;

public class Controller implements Serializable {
    Model model;
    Activity mainActivity;

    public Controller() {
        model = new Model();
        mainActivity = new Activity();
        FoodItem foodItem = new FoodItem("butter",1,"cup");
        addItem(foodItem);
    }

    Controller(Activity mainActivity){
        model = new Model();
        this.mainActivity = mainActivity;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Model getModel() {
        return model;
    }

    void addItem(FoodItem newItem){
        model.pantry.add(newItem);
    }

    void addRecipe(Recipe newRecipe){
        model.addRecipe(newRecipe);
    }

    public Vector<Recipe> getRecipes() {return model.recipes;}

    public Vector<FoodItem> getPantry() {return model.pantry;}
}
