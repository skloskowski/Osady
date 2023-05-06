package org.example;

public class Food extends Resources{
    int nourishment;
    public Food(String name, int weight, int nourishment) {
        super(name, weight);
        this.nourishment = nourishment;
    }
}
