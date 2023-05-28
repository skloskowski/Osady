package org.example;

public class BuildingMaterials extends Resources{
    int extractionTime;
    int constructionValue;
    public BuildingMaterials(String name, int extractionTime, int constructionValue) {
        super(name);
        this.extractionTime = extractionTime;
        this.constructionValue = constructionValue;
    }
}
