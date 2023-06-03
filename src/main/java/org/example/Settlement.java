package org.example;


import java.awt.*;
import java.util.HashMap;
import java.util.Random;

import static java.lang.Math.pow;

public class Settlement {
    /***
     *
     * @return ownedNourishment
     */
    public int getOwnedNourishment() {
        return ownedNourishment;
    }

    /***
     *
     * @return coordinates of settlement
     */
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

    /***
     *
     * @return get color of settlement
     */
    public Color getColor() {
        return color;
    }

    /***
     *
     * @return random Color
     */
    public Color getRandomColor(){
        Random rand = new Random();
        return new Color(rand.nextFloat(1), rand.nextFloat(1), rand.nextFloat(1));
    }

    /***
     * change population based on neededNourishment, ownedNourishment and owned and needed building materials
     * @return change in population
     */
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

    /***
     * needed nourishment based on speed and population
     * @return needed nourishment
     */
    public int getNeededNourishment(){
        return (int)(pow(speed,3)+ 2 * population);
    }

    /***
     * change amount of OwnedNourishment by nourishment
     * @param nourishment amount of nourishment to add
     */
    public void getOwnedNourishment(int nourishment){
        ownedNourishment += nourishment;
    }

    /***
     * add 20 of name Material
     * @param name name of added material
     */
    public void getOwnedBuildingMaterials(String name){

        if(buildingMaterialsNumber.containsKey(name)){
            int value = buildingMaterialsNumber.get(name);
            buildingMaterialsNumber.replace(name, value, value + 20);
        }
    }

    /***
     *
     * @return amount of Stone in settlement
     */
    public int getStoneAmount(){
        return buildingMaterialsNumber.get("Stone");
    }

    /***
     *
     * @return amount of Wood in settlement
     */
    public int getWoodAmount(){
        return buildingMaterialsNumber.get("Wood");
    }

    /***
     *
     * @return speed of settlers in settlement
     */
    public float getSpeed() {
        return speed;
    }
}
