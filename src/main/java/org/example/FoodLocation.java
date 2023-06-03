package org.example;

public class FoodLocation extends Food{
    private Coordinates position;

    /***
     *
     * @return position of Location
     */
    public Coordinates getPosition() {
        return position;
    }

    public FoodLocation(String name, int nourishment, Coordinates position){
        super(name, nourishment);
        this.position = position;
    }
}
