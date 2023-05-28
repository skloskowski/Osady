package org.example;

import java.util.HashMap;

import static java.lang.Math.pow;

public class Settlement { // Pamiętać dodać kolory

    // String colour;
    int population;
    int color;
    float speed;
    private int ownedNourishment;
    int neededNourishment;
    int neededConstructionValues;
    int neededMaterialAmount1;
    int neededMaterialAmount2;
    int neededMaterialAmount3;
    int ownedBuildingMaterials;
    Coordinates position;
    HashMap<String,Integer>buildingMaterialsNumber = new HashMap<>();

    public Settlement(int population, float speed, int ownedNourishment, int ownedBuildingMaterials, Coordinates position){
        // this.colour = colour;
        this.ownedNourishment = ownedNourishment;
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
        if(buildingMaterialsNumber.get("Wood") >= neededMaterialAmount1 && buildingMaterialsNumber.get("Stone") >= neededMaterialAmount2 && buildingMaterialsNumber
                .get("Clay") >= neededMaterialAmount3){

            buildingMaterialsNumber.replace("Wood",buildingMaterialsNumber.get("Wood")-neededMaterialAmount1);
            neededMaterialAmount1++;

            buildingMaterialsNumber.replace("Stone",buildingMaterialsNumber.get("Stone")-neededMaterialAmount2);
            neededMaterialAmount2++;

            buildingMaterialsNumber.replace("Clay",buildingMaterialsNumber.get("Clay")-neededMaterialAmount3);
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
        buildingMaterialsNumber.put("Wood", 0);
        buildingMaterialsNumber.put("Stone", 0);
        buildingMaterialsNumber.put("Clay", 0);

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
//sleep