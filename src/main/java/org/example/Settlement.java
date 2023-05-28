package org.example;

import java.util.HashMap;
import java.util.List;

import static java.lang.Math.pow;

public class Settlement { // Pamiętać dodać kolory

    // String colour;
    int population;
    int color;
    float speed;
    int ownedNourishment;
    int neededNourishment;
    int neededConstructionValues;
    int neededStoneAmount;
    int neededWoodAmount;
    int neededClayAmount;
    int ownedBuildingMaterials;
    Coordinates position;
    HashMap<String,Integer> buildingMaterialsNumber = new HashMap<>();

    public Settlement(int population, float speed, int ownedNourishment, int ownedBuildingMaterials, Coordinates position){
        // this.colour = colour;
        this.ownedNourishment = ownedNourishment;
        this.population = population; //zeby nie bylo <0
        this.speed = speed;
        this.ownedBuildingMaterials = ownedBuildingMaterials;
        this.position = position;
        this.neededNourishment = getNeededNourishment();
        this.neededConstructionValues = getNeededConstructionValues();
        buildingMaterialsNumber.put("Wood", 0);
        buildingMaterialsNumber.put("Stone", 0);
        buildingMaterialsNumber.put("Clay", 0);
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
        int newPopulation = 0;
        if(ownedNourishment >= getNeededNourishment()){
            ownedNourishment -= getNeededNourishment();
            newPopulation++;
        }

        if(ownedNourishment <= getNeededNourishment() - 2){//jaka ilosc
            newPopulation--;
        }

        if(buildingMaterialsNumber.get("Stone") >= neededStoneAmount && buildingMaterialsNumber.get("Wood") >= neededWoodAmount && buildingMaterialsNumber
                .get("Clay") >= neededClayAmount){

            buildingMaterialsNumber.replace("Stone",buildingMaterialsNumber.get("Stone")- neededStoneAmount);
            neededStoneAmount++;

            buildingMaterialsNumber.replace("Wood",buildingMaterialsNumber.get("Wood")- neededWoodAmount);
            neededWoodAmount++;

            buildingMaterialsNumber.replace("Clay",buildingMaterialsNumber.get("Clay")- neededClayAmount);
            neededClayAmount++;

            newPopulation++;

        }
        if(buildingMaterialsNumber.get("Stone") <= neededStoneAmount - 2 && buildingMaterialsNumber.get("Wood") <= neededWoodAmount - 2 && buildingMaterialsNumber
                .get("Clay") <= neededClayAmount - 2){ //jaka ilosc

            newPopulation--;

        }
        return newPopulation;
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