package org.example;

import java.util.HashMap;
import java.util.Random;

import static java.lang.Math.*;

public class Settler {
    String colour;
    int speed;
    Food equipmentFood;
    BuildingMaterials equipmentBuildingMaterials;
    Coordinates position;

    public Settler(String colour, int speed, Food equipmentFood, BuildingMaterials equipmentBuildingMaterials, Coordinates position) {
        this.colour = colour;
        this.speed = speed;
        this.equipmentFood = equipmentFood;
        this.equipmentBuildingMaterials = equipmentBuildingMaterials;
        this.position = position;
    }

    public Food acquireFood(Food equipment) {
        return equipment;
    }

    public BuildingMaterials acquireBuildingMaterials(BuildingMaterials equipment) {
        return equipment;
    }

    public Coordinates changePosition(Coordinates position) {
        return position;
    }

    public void movement(HashMap<Coordinates, Food> foodHashMap, HashMap<Coordinates, BuildingMaterials> buildingMaterialsHashMap) {
        Random rand = new Random();
        Vector location = new Vector(position.x, position.y);
        Vector velocity = new Vector(0, 0);
        while (true) {
//            int random_x = rand.nextInt(-2,2);
//            int random_y = rand.nextInt(-2,2);
//
//            position.x = position.x + speed * random_x;
//            position.y = position.y + speed * random_y;

            Vector acceleration = new Vector(rand.nextDouble(-1, 1), rand.nextDouble(-1, 1));
            location.add(velocity);
            velocity.add(acceleration);

            if (velocity.getVectorLength() >= 1.5) acceleration = acceleration.multiply(0);

            limit();
            var food = foodHashMap.entrySet().stream()
                    .filter(keySet -> {
                        var key = keySet.getKey();
                        if (pow((keySet.getKey().x-position.x),2)<25 && pow(keySet.getKey().y - position.y, 2) < 25) return true;
                        return false;
                    }).findAny().orElse(null);

            if (food != null) {
                equipmentFood = food.getValue();
                while (pow((position.x - Settlement.position.x), 2) > 25 && pow((position.y - Settlement.position.y), 2) > 25) {
                    Vector returnVelocity = new Vector(Settlement.position.x - position.x, Settlement.position.y - position.y);

                    location.add(returnVelocity.normalize());

                    limit();
                }//powrot do osady
                Settlement.ownedFood(foodHashMap.get(position).nourishment);
            }

            var buildingMaterials = buildingMaterialsHashMap.entrySet().stream()
                    .filter(keySet -> {
                        var key = keySet.getKey();
                        if (pow((keySet.getKey().x-position.x),2)<25 && pow(keySet.getKey().y - position.y, 2) < 25) return true;
                        return false;
                    }).findAny().orElse(null);

            if (buildingMaterials != null){
                equipmentBuildingMaterials = buildingMaterials.getValue();
                while (pow((position.x - Settlement.position.x), 2) > 25 && pow((position.y - Settlement.position.y), 2) > 25) {
                    Vector returnVelocity = new Vector(Settlement.position.x - position.x, Settlement.position.y - position.y);

                    location.add(returnVelocity.normalize());

                    limit();
                }
                Settlement.ownedBuildingMaterials(buildingMaterialsHashMap.get(position).constructionValue); //

            }
        }//cant complete without throwing an exception
    }

    private void limit() {
        if (position.x > MapCreation.size.x) position.x = 0;
        if (position.x < 0) position.x = MapCreation.size.x;
        if (position.y > MapCreation.size.y) position.y = 0;
        if (position.y < 0) position.y = MapCreation.size.y;
    }

}
