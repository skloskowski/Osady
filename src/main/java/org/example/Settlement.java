package org.example;

import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.Math.pow;

public class Settlement { // Pamiętać dodać kolory

    // String colour;
    int population;
    private float speed;
    private int ownedNourishment;
    int neededNourishment;
    int neededConstructionValues;
    int neededMaterialAmount1;
    int neededMaterialAmount2;
    int neededMaterialAmount3;
    int ownedBuildingMaterials;
    Coordinates position;
    HashMap<String,Integer>buildingMaterialsNumber = new HashMap<>();

    public Settlement(int population, float speed, int ownedBuildingMaterials, Coordinates position){
        // this.colour = colour;
        this.population = population;
        this.speed = speed;
        this.ownedBuildingMaterials = ownedBuildingMaterials;
        this.position = position;
        this.neededNourishment = getNeededNourishment();
        this.neededConstructionValues = getNeededConstructionValues();
    }

//    public int changePopulation(int population, Resources neededResources, Resources ownedResources){
//        return population; // population is going to depend on resources
//    }
//    public int changePopulation(int population, Food neededFood, Food ownedFood, BuildingMaterials neededBuildingMaterials, BuildingMaterials ownedBuildingMaterials){
//        if(neededFood.nourishment >= ownedFood.nourishment){
//            ownedFood.nourishment -= neededFood.nourishment;
//            population++;
//        }
//
//    }
    public int changePopulation(int population){
        if(ownedNourishment >= getNeededNourishment()){
            ownedNourishment -= getNeededNourishment();
            population++;
        }
        if(buildingMaterialsNumber.get("Material1") >= neededMaterialAmount1 && buildingMaterialsNumber.get("Material2") >= neededMaterialAmount2 && buildingMaterialsNumber
                .get("Material3") >= neededMaterialAmount3){

            buildingMaterialsNumber.replace("Material1",buildingMaterialsNumber.get("Material1")-neededMaterialAmount1);
            neededMaterialAmount1++;

            buildingMaterialsNumber.replace("Material2",buildingMaterialsNumber.get("Material2")-neededMaterialAmount2);
            neededMaterialAmount2++;

            buildingMaterialsNumber.replace("Material3",buildingMaterialsNumber.get("Material3")-neededMaterialAmount3);
            neededMaterialAmount3++;

            population++;

        }
        return population;
    }
    public int getNeededConstructionValues() {
        return (int)(pow(speed,2) + population);
    }
    public int getNeededNourishment(){
        return (int)(pow(speed,2) + population);
    }
    public int getPopulation() {
        return population;
    }
    //change population
    public void getOwnedNourishment(int nourishment){
        ownedNourishment += nourishment;
    }
    public void getOwnedBuildingMaterials(String name){
        buildingMaterialsNumber.put("Material1", 0);
        buildingMaterialsNumber.put("Material2", 0);
        buildingMaterialsNumber.put("Material3", 0);

        if(buildingMaterialsNumber.containsKey(name)){
            int value = buildingMaterialsNumber.get(name);
            buildingMaterialsNumber.replace(name, value, value + 1);
        }
    }

    public float getSpeed() {
        return speed;
    }
}
//colours
//change movement
//sleep