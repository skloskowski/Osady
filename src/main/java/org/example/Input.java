package org.example;

public class Input {
    Coordinates size;
    int numberSettlements;
    int numberFood;
    int numberBuildingMaterials;

    /*
    public Input(Coordinates size, int numberSettlements, int numberFood, int numberBuildingMaterials){
        this.size = size;
        this.numberSettlements = numberSettlements;
        this.numberFood = numberFood;
        this. numberBuildingMaterials = numberBuildingMaterials;
    } */

    public void askSize(){
        size = new Coordinates(0, 0);
    }
    public void askSettlements(){
        numberSettlements = 0;
    }
    public void askFood(){
        numberFood = 0;
    }
    public void numberBuildingMaterials(){
        numberBuildingMaterials = 0;
    }
}
