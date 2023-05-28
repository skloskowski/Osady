package org.example;

public class FoodLocation extends Food{
    Coordinates position;

    public FoodLocation(String name, int nourishment, Coordinates position){
        super(name, nourishment);
        this.position = position;
    }
}
