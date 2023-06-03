package org.example;

import java.awt.*;
import java.util.Random;

public class Food extends Resources{
    private int nourishment;

    /***
     *
     * @return nourishment of food
     */
    public int getNourishment() {
        return nourishment;
    }

    private Color color;

    /***
     *
     * @return color of food
     */
    public Color getColor() {
        return color;
    }

    public Food(String name, int nourishment) {
        super(name);
        color = getRandomColor();
        this.nourishment = nourishment;
    }

    /***
     * get random color
     * @return random color
     */
    public Color getRandomColor(){
        Random rand = new Random();
        return new Color(rand.nextFloat(1), rand.nextFloat(1), rand.nextFloat(1));
    }
}
