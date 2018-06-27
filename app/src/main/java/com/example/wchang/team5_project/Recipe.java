package com.example.wchang.team5_project;

import java.util.Vector;

public class Recipe {
    Vector<FoodItem> ingredients;
    Vector<String> directions;

    private void addFoodItem(FoodItem newItem){
        ingredients.add(newItem);
    }

    private void addDirection(String newDirection){
        directions.add(newDirection);
    }

}
