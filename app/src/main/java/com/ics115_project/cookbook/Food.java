package com.ics115_project.cookbook;

public class Food {
    String foodName;
    String foodType;
    String chefUserName;

    public Food(){

    }

    public Food(String foodName, String foodType, String chefUserName){
        this.foodName = foodName;
        this.foodType = foodType;
        this.chefUserName = chefUserName;
    }

    public String getFoodName() {
        return foodName;
    }

    public String getFoodType() {
        return foodType;
    }

    public String getChefUserName() {
        return chefUserName;
    }
}
