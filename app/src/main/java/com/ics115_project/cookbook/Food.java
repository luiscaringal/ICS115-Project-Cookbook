package com.ics115_project.cookbook;

public class Food {
    String foodName;
    String foodType;
    double foodPrice;
    String chefUserName;

    public Food(){

    }

    public Food(String foodName, String foodType, double foodPrice, String chefUserName){
        this.foodName = foodName;
        this.foodType = foodType;
        this.foodPrice = foodPrice;
        this.chefUserName = chefUserName;
    }

    public String getFoodName() {
        return foodName;
    }

    public String getFoodType() {
        return foodType;
    }

    public double getFoodPrice() {
        return foodPrice;
    }

    public String getChefUserName() {
        return chefUserName;
    }
}
