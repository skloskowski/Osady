package org.example;

public class BuildingMaterialsLocation extends BuildingMaterials{
    Coordinates position;

    public BuildingMaterialsLocation(String name, int nourishment, int constructionValue, Coordinates position){
        super(name, nourishment,constructionValue);
        this.position = position;
    }
}
