package com.example.wchang.team5_project;

import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Vector;
import java.util.stream.Stream;

public class Recipe {
    Vector<FoodItem> ingredients;
    Vector<String> directions;
    String name;

    public Recipe() {
        ingredients = new Vector<FoodItem>();
        directions = new Vector<String>();
        name = null;
    }

    public void addFoodItem(FoodItem newItem){
        ingredients.add(newItem);
    }

    public void addDirection(String newDirection){
        directions.add(newDirection);
    }


    public Vector<FoodItem> getIngredients() {
        return ingredients;
    }

    public Vector<String> getDirections() {
        return directions;
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String toString(){
        return this.name;
    }

}
