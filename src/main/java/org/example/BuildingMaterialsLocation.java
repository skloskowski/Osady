package org.example;

public class BuildingMaterialsLocation extends BuildingMaterials{
    Coordinates position;

    public BuildingMaterialsLocation(String name, int weight, int nourishment, int constructionValue, Coordinates position){
        super(name, weight, nourishment,constructionValue);
        this.position = position;
    }
}
