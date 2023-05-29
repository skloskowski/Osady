package org.example;


import java.awt.*;
import java.util.HashMap;
import java.util.Random;

import static java.lang.Math.pow;

public class Settlement {

    int population;
    Color color;
    float speed;
    int ownedNourishment;
    int neededNourishment;
    int neededStoneAmount;
    int neededWoodAmount;
    int neededClayAmount;
    int ownedBuildingMaterials;
    public Coordinates position;
    HashMap<String,Integer> buildingMaterialsNumber = new HashMap<>();

    public Settlement(int population, float speed, int ownedNourishment, int ownedBuildingMaterials, Coordinates position){
        this.color = getColor();
        this.ownedNourishment = ownedNourishment;
        this.population = population;
        this.speed = speed;
        this.ownedBuildingMaterials = ownedBuildingMaterials;
        this.position = position;
        this.neededNourishment = getNeededNourishment();
        buildingMaterialsNumber.put("Wood", 0);
        buildingMaterialsNumber.put("Stone", 0);
        buildingMaterialsNumber.put("Clay", 0);
    }
    public Color getColor(){
        Random rand = new Random();
        return new Color(rand.nextFloat(1), rand.nextFloat(1), rand.nextFloat(1));
    }
    public int changePopulation(){
        int newPopulation = 0;
//        if(ownedNourishment >= getNeededNourishment()){
//            ownedNourishment -= getNeededNourishment();
//            newPopulation++;
//        }
//        if(ownedNourishment < getNeededNourishment() ){//jaka ilosc
//            newPopulation--;
//        }
//
//
//        if(buildingMaterialsNumber.get("Stone") >= neededStoneAmount && buildingMaterialsNumber.get("Wood") >= neededWoodAmount && buildingMaterialsNumber
//                .get("Clay") >= neededClayAmount){
//
//            buildingMaterialsNumber.replace("Stone",buildingMaterialsNumber.get("Stone")- neededStoneAmount);
//            neededStoneAmount++;
//
//            buildingMaterialsNumber.replace("Wood",buildingMaterialsNumber.get("Wood")- neededWoodAmount);
//            neededWoodAmount++;
//
//            buildingMaterialsNumber.replace("Clay",buildingMaterialsNumber.get("Clay")- neededClayAmount);
//            neededClayAmount++;
//
//            newPopulation++;
//
//        }
//        if(buildingMaterialsNumber.get("Stone") < neededStoneAmount  && buildingMaterialsNumber.get("Wood") < neededWoodAmount  && buildingMaterialsNumber
//                .get("Clay") < neededClayAmount ) { //jaka ilosc
//            newPopulation--;
//        }

        return newPopulation;
    }
    public int getNeededNourishment(){
        return (int)(pow(speed,2)+population);
    }
    public void getOwnedNourishment(int nourishment){
        ownedNourishment += nourishment;
    }
    public void getOwnedBuildingMaterials(String name){

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
