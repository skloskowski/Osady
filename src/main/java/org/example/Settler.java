package org.example;
public class Settler {
    String colour;
    float speed;
    Resources equipment;
    Coordinates position;

    public Settler(String colour, float speed, Resources equipment, Coordinates position){
        this.colour = colour;
        this.speed = speed;
        this.equipment = equipment;
        this.position = position;
    }

    public Resources acquireResources(Resources equipment){
        return equipment;
    }

    public Coordinates changePosition(Coordinates position){
        return position;
    }
}
