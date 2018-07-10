package com.example.wchang.team5_project;

public class FoodItem {
    String name;
    float quantity;
    String unit;

    public FoodItem() {
        name = null;
        quantity = 0;
        unit = null;
    }

    public FoodItem(String name, float quantity, String unit){
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public float getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String toString(){
        return this.name;
    }
}
