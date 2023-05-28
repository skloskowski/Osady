package org.example;

public class BuildingMaterials extends Resources{
    long extractionTime;
    int constructionValue;
    public BuildingMaterials(String name, long extractionTime, int constructionValue) {
        super(name);
        this.extractionTime = extractionTime;
        this.constructionValue = constructionValue;
    }
}
