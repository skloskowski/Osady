package org.example;

public class FoodLocation extends Food{
    Coordinates position;

    public FoodLocation(String name, int weight, int nourishment, Coordinates position){
        super(name, weight, nourishment);
        this.position = position;
    }
}
