package org.example;

import java.awt.*;
import java.util.Random;

public class Food extends Resources{
    private int nourishment;

    public int getNourishment() {
        return nourishment;
    }

    private Color color;

    public Color getColor() {
        return color;
    }

    public Food(String name, int nourishment) {
        super(name);
        color = getRandomColor();
        this.nourishment = nourishment;
    }
    public Color getRandomColor(){
        Random rand = new Random();
        return new Color(rand.nextFloat(1), rand.nextFloat(1), rand.nextFloat(1));
    }
}
