package org.example;

import java.awt.*;
import java.util.Random;

public class BuildingMaterials extends Resources{
    long extractionTime;
    Color color;
    int constructionValue;
    public BuildingMaterials(String name, long extractionTime, int constructionValue) {
        super(name);
        color = getColor();
        this.extractionTime = extractionTime;
        this.constructionValue = constructionValue;
    }
    public Color getColor(){
        Random rand = new Random();
        return new Color(rand.nextFloat(1), rand.nextFloat(1), rand.nextFloat(1));
    }
}
