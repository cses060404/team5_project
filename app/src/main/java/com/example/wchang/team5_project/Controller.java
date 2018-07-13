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

    public Vector<FoodItem> makeList(Vector<Recipe> usingRecipe){
        Vector<FoodItem> needed = new Vector<>();
        for(int i = 0; i < usingRecipe.size(); i++){
            for(int j = 0; j < usingRecipe.get(i).getIngredients().size(); j++) {
                for(int k = 0; k < model.pantry.size(); k++) {
                // j is the recipe FoodItem index
                // k is the pantry FoodItem index
                // compare all J's to K's. if not found add to needed list
                    if (model.pantry.get(k).name.equals(usingRecipe.get(i).getIngredients().get(j).name) ) {
                        //create a new FoodItem with the needed quantity
                        FoodItem newFoodItem = new FoodItem(model.pantry.get(k).name, (usingRecipe.get(i).getIngredients().get(j).quantity - model.pantry.get(k).quantity), model.pantry.get(k).unit);
                        if(newFoodItem.quantity > 0)
                            needed.add(newFoodItem);
                    } else {
                        FoodItem newFoodItem = new FoodItem(usingRecipe.get(i).getIngredients().get(j).name, usingRecipe.get(i).getIngredients().get(j).quantity, usingRecipe.get(i).getIngredients().get(j).unit);
                        needed.add(newFoodItem);
                    }
                }
            }
        }
        return needed;
    }

    public Vector<Recipe> getRecipes() {return model.recipes;}

    public Vector<FoodItem> getPantry() {return model.pantry;}
}
