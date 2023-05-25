package org.example;

public class BuildingMaterials extends Resources{
    int extractionTime;
    int constructionValue;
    public BuildingMaterials(String name, int weight, int extractionTime, int constructionValue) {
        super(name, weight);
        this.extractionTime = extractionTime;
        this.constructionValue = constructionValue;
    }
}
