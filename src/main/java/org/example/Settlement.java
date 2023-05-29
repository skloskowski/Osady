package org.example;

import java.util.HashMap;

import static java.lang.Math.pow;

public class Settlement { // Pamiętać dodać kolory

    // String colour;
    int population;
    int color;
    float speed;
    int ownedNourishment;
    int neededNourishment;
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
        buildingMaterialsNumber.put("Wood", 0);
        buildingMaterialsNumber.put("Stone", 0);
        buildingMaterialsNumber.put("Clay", 0);
    }
    public int changePopulation(){
        int newPopulation = 0;
        if(ownedNourishment >= getNeededNourishment()){
            ownedNourishment -= getNeededNourishment();
            newPopulation++;
        }
        if(ownedNourishment < getNeededNourishment() ){//jaka ilosc
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
        if(buildingMaterialsNumber.get("Stone") < neededStoneAmount  && buildingMaterialsNumber.get("Wood") < neededWoodAmount  && buildingMaterialsNumber
                .get("Clay") < neededClayAmount ) { //jaka ilosc
            newPopulation--;
        }

        return newPopulation;
    }


    public int getNeededNourishment(){
        return (int)(pow(speed,2) + population);
    }
    public int getPopulation() {
        return population;
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
