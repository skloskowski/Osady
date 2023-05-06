package org.example;

public class BuildingMaterials extends Resources{
    int extractionTime;
    public BuildingMaterials(String name, int weight, int extractionTime) {
        super(name, weight);
        this.extractionTime = extractionTime;
    }
}
