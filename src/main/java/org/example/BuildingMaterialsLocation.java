package org.example;

public class BuildingMaterialsLocation extends BuildingMaterials{
    Coordinates position;

    public BuildingMaterialsLocation(String name,long extractionTime, int constructionValue, Coordinates position){
        super(name, extractionTime, constructionValue);
        this.position = position;
    }

    public Coordinates getPosition() {
        return position;
    }
}
