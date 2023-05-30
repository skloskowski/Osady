package org.example;


import java.awt.*;
import java.util.HashMap;
import java.util.Random;

import static java.lang.Math.pow;

public class Settlement {

    public int getOwnedNourishment() {
        return ownedNourishment;
    }
    public Coordinates getPosition() {
        return position;
    }

    int population;
    private Color color;
    private float speed;
    private int ownedNourishment;
    private Coordinates position;
    HashMap<String,Integer> buildingMaterialsNumber = new HashMap<>();

    public Settlement(int population, float speed, int ownedNourishment, Coordinates position){
        this.color = getRandomColor();
        this.ownedNourishment = ownedNourishment;
        this.population = population;
        this.speed = speed;
        this.position = position;
        buildingMaterialsNumber.put("Wood", 0);
        buildingMaterialsNumber.put("Stone", 0);
        // buildingMaterialsNumber.put("Clay", 0);
    }

    public Color getColor() {
        return color;
    }

    public Color getRandomColor(){
        Random rand = new Random();
        return new Color(rand.nextFloat(1), rand.nextFloat(1), rand.nextFloat(1));
    }
    public int changePopulation(){
        int newPopulation = 0;
        if(ownedNourishment >= getNeededNourishment()){
            ownedNourishment -= getNeededNourishment();
            newPopulation++;
        }
        if(ownedNourishment < getNeededNourishment() ){
            ownedNourishment -= (ownedNourishment/2);
            newPopulation--;
        }


        if(buildingMaterialsNumber.get("Stone") >= population && buildingMaterialsNumber.get("Wood") >= population){

            buildingMaterialsNumber.replace("Stone",buildingMaterialsNumber.get("Stone")- population);

            buildingMaterialsNumber.replace("Wood",buildingMaterialsNumber.get("Wood")- population);

            // buildingMaterialsNumber.replace("Clay",buildingMaterialsNumber.get("Clay")- population);

            newPopulation++;

        }
        if(buildingMaterialsNumber.get("Stone") < population  && buildingMaterialsNumber.get("Wood") < population) {

            buildingMaterialsNumber.replace("Stone", 0);
            buildingMaterialsNumber.replace("Wood", 0);
            // buildingMaterialsNumber.replace("Clay", 0);

            newPopulation--;
        }
        return newPopulation;
    }
    public int getNeededNourishment(){
        return (int)(pow(speed,3)+ 2 * population);
    }
    public void getOwnedNourishment(int nourishment){
        ownedNourishment += nourishment;
    }
    public void getOwnedBuildingMaterials(String name){

        if(buildingMaterialsNumber.containsKey(name)){
            int value = buildingMaterialsNumber.get(name);
            buildingMaterialsNumber.replace(name, value, value + 20);
        }
    }

    public int getStoneAmount(){
        return buildingMaterialsNumber.get("Stone");
    }

    public int getWoodAmount(){
        return buildingMaterialsNumber.get("Wood");
    }

    public float getSpeed() {
        return speed;
    }
}
