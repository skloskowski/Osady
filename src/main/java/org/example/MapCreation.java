package org.example;

public class MapCreation {
    Coordinates size;
    int numberSettlements;
    int numberFood;
    int numberBuildingMaterials;


    public MapCreation(Coordinates size, int numberSettlements, int numberFood, int numberBuildingMaterials){
        this.size = size;
        this.numberSettlements = numberSettlements;
        this.numberFood = numberFood;
        this. numberBuildingMaterials = numberBuildingMaterials;
    }

    public void CreateMap(Coordinates size, int numberSettlements, int numberFood, int numberBuildingMaterials){
    }

    public Coordinates RandomCoordinates(Coordinates coordinates){
        return coordinates;
    }

    public void CreateSettlements(int numberSettlements){
    }

}
