package org.example;

import java.awt.*;
import java.util.Random;

public class Food extends Resources{
    int nourishment;
    Color color;
    public Food(String name, int nourishment) {
        super(name);
        color = getColor();
        this.nourishment = nourishment;
    }
    public Color getColor(){
        Random rand = new Random();
        return new Color(rand.nextFloat(1), rand.nextFloat(1), rand.nextFloat(1));
    }
}
