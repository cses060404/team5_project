package com.example.wchang.team5_project;

import android.app.Activity;

import java.io.Serializable;
import java.util.Vector;

/**
 * For this app's MVC design, this controller manages the interactions between the View and the
 * Model.
 */
public class Controller implements Serializable {
    Model model;
    Activity mainActivity;

    /**
     *   Controller class owns a Model and an Activity class representing the view.
     *   Coordinates communication between the two.
     */
    public Controller() {
        model = new Model();
        mainActivity = new Activity();
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

    /**
    *   This Function compares the string of the passed FoodItem to
    *   the strings of the FoodItems stored in model.pantry. If a similar
    *   string is found it adds their quantities. Otherwise it adds it
    *   as a new FoodItem to model.pantry
    */
    void addItem(FoodItem newItem){
        // look to see if item is already in the vector
        for(int i = 0; i < model.pantry.size(); i++) {
            // if it is add the quantity values
            if(model.pantry.get(i).name.toUpperCase().equals(newItem.name.toUpperCase())){
                model.pantry.get(i).quantity += newItem.quantity;
                return;
            }
        }
        // else add item to the vector
        newItem.setName(newItem.getName().toUpperCase());
        model.pantry.add(newItem);
    }
    /**
    *   Searches model.Pantry for an equivalent name to the passed
    *   FoodItem. If found it is deleted from model.Pantry .
    */
    void deleteItem(FoodItem oldItem){
        for(int i = 0; i < model.pantry.size(); i++) {
            // if it is add the quantity values
            if(model.pantry.get(i).name.equals(oldItem.name)){
                model.pantry.remove(model.pantry.get(i));
                return;
            }
        }
    }

    void deleteRecipe(int index) {
        model.recipes.remove(index);
    }

    /**
    *   This Function adds a the passed Recipe to model.recipes
    */
    void addRecipe(Recipe newRecipe){
        model.addRecipe(newRecipe);
    }

    /**
    *   Takes a Vector<Recipe> as a parameter. It will traverse all
    *   recipes in this vector and compare their FoodItem's to
    *   model.pantry . Any similar FoodItems are ignored. Others are
    *   put into a temporary Vector<FoodItem> that is returned at the
    *   end of the function.
    */
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

    /**
    *   Takes a Recipe as a parameter. It will traverse all
    *   FoodItems in this Recipe. Any similar FoodItems are ignored. Others are
    *   put into a temporary Vector<FoodItem> that is returned at the
    *   end of the function.
    */
    public Vector<FoodItem> makeList(Recipe usingRecipe){
        Vector<FoodItem> needed = new Vector<>();
        if(model.pantry.size() != 0) {
            for (int j = 0; j < usingRecipe.getIngredients().size(); j++) {
                for (int k = 0; k < model.pantry.size(); k++) {
                    // j is the recipe FoodItem index
                    // k is the pantry FoodItem index
                    // compare all J's to K's. if not found add to needed list
                    if (model.pantry.get(k).name.equals(usingRecipe.getIngredients().get(j).name)) {
                        //create a new FoodItem with the needed quantity
                        FoodItem newFoodItem = new FoodItem(model.pantry.get(k).name, (usingRecipe.getIngredients().get(j).quantity - model.pantry.get(k).quantity), model.pantry.get(k).unit);
                        if (newFoodItem.quantity > 0)
                            needed.add(newFoodItem);
                    } else {
                        FoodItem newFoodItem = new FoodItem(usingRecipe.getIngredients().get(j).name, usingRecipe.getIngredients().get(j).quantity, usingRecipe.getIngredients().get(j).unit);
                        needed.add(newFoodItem);
                    }

                }

            }
        }
        else  {
            for (int j = 0; j < usingRecipe.getIngredients().size(); j++) {
            FoodItem newFoodItem = new FoodItem(usingRecipe.getIngredients().get(j).name, usingRecipe.getIngredients().get(j).quantity, usingRecipe.getIngredients().get(j).unit);
            needed.add(newFoodItem);}
        }
        return needed;
    }

    public Vector<Recipe> getRecipes() {return model.recipes;}

    public Vector<FoodItem> getPantry() {return model.pantry;}
}
