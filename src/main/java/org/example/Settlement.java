package org.example;

import java.util.ArrayList;

public class Settlement {
    String colour;
    int population;
    float speed;
    Food neededFood;
    Food ownedFood;
    int neededNourishment = 10;
    int neededConstructionValues = 10;
    BuildingMaterials neededBuildingMaterials;
    BuildingMaterials ownedBuildingMaterials;
    static Coordinates position;

    public Settlement(String colour, int population, float speed, Food neededFood, Food ownedFood, BuildingMaterials neededBuildingMaterials, BuildingMaterials ownedBuildingMaterials, Coordinates position){
        this.colour = colour;
        this.population = population;
        this.speed = speed;
        this.neededFood = neededFood;
        this.ownedFood = ownedFood;
        this.neededBuildingMaterials = neededBuildingMaterials;
        this.ownedBuildingMaterials = ownedBuildingMaterials;
        Settlement.position = position;
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
    public Food getNeededFood() {
        return neededFood;
    }
    public BuildingMaterials getNeededBuildingMaterials() {
        return neededBuildingMaterials;
    }
    public int getPopulation() {
        return population;
    }
    //change population
    public static ArrayList <Integer> getOwnedFood(int nourishment){
        ArrayList<Integer> ownedFood = new ArrayList<>();
        ownedFood.add(nourishment);
        return ownedFood;
    }
    public static ArrayList <Integer> getOwnedBuildingMaterials(int constructionValue){
        ArrayList<Integer> ownedBuildingMaterials = new ArrayList<>();
        ownedBuildingMaterials.add(constructionValue);
        return ownedBuildingMaterials;
    }
}
