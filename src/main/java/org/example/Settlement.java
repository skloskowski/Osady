package org.example;

public class Settlement {
    String colour;
    int population;
    float speed;
    Food neededFood;
    Food ownedFood;
    BuildingMaterials neededBuildingMaterials;
    BuildingMaterials ownedBuildingMaterials;
    Coordinates position;

    public Settlement(String colour, int population, float speed, Food neededFood, Food ownedFood, BuildingMaterials neededBuildingMaterials, BuildingMaterials ownedBuildingMaterials, Coordinates position){
        this.colour = colour;
        this.population = population;
        this.speed = speed;
        this.neededFood = neededFood;
        this.ownedFood = ownedFood;
        this.neededBuildingMaterials = neededBuildingMaterials;
        this.ownedBuildingMaterials = ownedBuildingMaterials;
        this.position = position;
    }

    public int changePopulation(int population, Resources neededResources, Resources ownedResources){
        return population; // population is going to depend on resources
    }

    public Food getNeededFood() {
        return neededFood;
    }
    public Food getOwnedFood() {
        return ownedFood;
    }
    public BuildingMaterials getNeededBuildingMaterials() {
        return neededBuildingMaterials;
    }
    public BuildingMaterials getOwnedBuildingMaterials() {
        return ownedBuildingMaterials;
    }
    public int getPopulation() {
        return population;
    }
}
