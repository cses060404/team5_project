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
        // look to see if item is already in the vector
        for(int i = 0; i < model.pantry.size(); i++) {
            // if it is add the quantity values
            if(model.pantry.get(i).name.equals(newItem.name)){
                model.pantry.get(i).quantity += newItem.quantity;
                return;
            }
        }
        // else add item to the vector
        model.pantry.add(newItem);
    }

    void deleteItem(FoodItem oldItem){
        for(int i = 0; i < model.pantry.size(); i++) {
            // if it is add the quantity values
            if(model.pantry.get(i).name.equals(oldItem.name)){
                model.pantry.remove(model.pantry.get(i));
                return;
            }
        }
    }

    void addRecipe(Recipe newRecipe){
        model.addRecipe(newRecipe);
    }

    public Vector<Recipe> getRecipes() {return model.recipes;}

    public Vector<FoodItem> getPantry() {return model.pantry;}
}
