package com.example.wchang.team5_project;

/**
 *   Food Item Class used to store the name, quantity, and unit of measurement for and item.
 */
public class FoodItem {
    String name;
    float quantity;
    String unit;
    String barcode;

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
    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }
    public void setQuantity(String quantity) {this.quantity = Float.valueOf(quantity);}

    public String getUnit() {
        return unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String toString(){
        return this.name + " " + this.quantity + " " + this.unit;
    }
    public String displayDetail() {
        if(unit.equals("")) {
            return name + " (" + quantity + ")";
        } else {
            return name + " (" + quantity + " " + unit + ")";
        }
    }

}
