package org.example;

import java.util.ArrayList;

public class Settlement { // Pamiętać dodać kolory

    // String colour;
    int population;
    float speed;
    int neededFood;
    int ownedFood;
    int neededNourishment = 10; // to będzie funkcja prędkości i liczebności -> większa prędkość większe zapotrzebowanie (fcja kwadratowa(?))
    int neededConstructionValues = 10;
    int neededBuildingMaterials;
    int ownedBuildingMaterials;
    static Coordinates position;

    public Settlement(int population, float speed, int ownedFood, int ownedBuildingMaterials, Coordinates position){
        // this.colour = colour;
        this.population = population;
        this.speed = speed;
        this.ownedFood = ownedFood;
        this.ownedBuildingMaterials = ownedBuildingMaterials;
        this.position = position;
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
    public int getNeededFood() {
        return neededFood;
    }
    public int getNeededBuildingMaterials() {
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
