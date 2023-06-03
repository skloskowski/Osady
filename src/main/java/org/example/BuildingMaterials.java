package org.example;

import java.awt.*;
import java.util.Random;

public class BuildingMaterials extends Resources{
    long extractionTime;
    private Color color;
    int constructionValue;
    public BuildingMaterials(String name, long extractionTime, int constructionValue) {
        super(name);
        color = getRandomColor();
        this.extractionTime = extractionTime;
        this.constructionValue = constructionValue;
    }

    /***
     * get random color
     * @return random color
     */
    private Color getRandomColor(){
        Random rand = new Random();
        return new Color(rand.nextFloat(1), rand.nextFloat(1), rand.nextFloat(1));
    }

    /***
     *
     * @return color of building materials
     */
    public Color getColor() {
        return color;
    }
}
