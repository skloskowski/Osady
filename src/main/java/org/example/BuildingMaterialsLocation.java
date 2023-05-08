package org.example;

public class BuildingMaterialsLocation extends BuildingMaterials{
    Coordinates position;

    public BuildingMaterialsLocation(String name, int weight, int nourishment, Coordinates position){
        super(name, weight, nourishment);
        this.position = position;
    }
}
