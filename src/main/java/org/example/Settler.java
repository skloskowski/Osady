package org.example;
public class Settler {
    String colour;
    float speed;
    Food equipmentFood;
    BuildingMaterials equipmentBuildingMaterials;
    Coordinates position;

    public Settler(String colour, float speed, Food equipmentFood, BuildingMaterials equipmentBuildingMaterials, Coordinates position){
        this.colour = colour;
        this.speed = speed;
        this.equipmentFood = equipmentFood;
        this.equipmentBuildingMaterials = equipmentBuildingMaterials;
        this.position = position;
    }

    public Food acquireFood(Food equipment){
        return equipment;
    }
    public BuildingMaterials acquireBuildingMaterials(BuildingMaterials equipment){
        return equipment;
    }
    public Coordinates changePosition(Coordinates position){
        return position;
    }
}
