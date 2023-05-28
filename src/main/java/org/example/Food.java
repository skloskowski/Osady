package org.example;

public class Food extends Resources{
    int nourishment;
    public Food(String name, int nourishment) {
        super(name);
        this.nourishment = nourishment;
    }
}
