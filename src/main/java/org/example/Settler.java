package org.example;

import java.util.ArrayList;
import java.util.Random;

import static java.lang.Math.*;

public class Settler{ // Pamiętać dodaj kolory
    // String colour;
    Settlement settlement;
    float maxSpeed;
    Coordinates position;
    int color;
    boolean isMoving = true;
    long lastStopTimestamp;
    long stoppedFor;

    public Settler(Coordinates position, Settlement settlement) {
        // this.colour = colour;
        this.position = position;
        this.settlement = settlement;
        this.maxSpeed = settlement.getSpeed();
        this.color = settlement.color;
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

    //    public void movement(HashMap<FoodLocation, Food> foodHashMap, HashMap<BuildingMaterialsLocation, BuildingMaterials> buildingMaterialsHashMap) {
//        Random rand = new Random();
//        Vector location = new Vector(position.x, position.y);
//        Vector velocity = new Vector(0, 0);
//        while (true) {
////            int random_x = rand.nextInt(-2,2);
////            int random_y = rand.nextInt(-2,2);
////
////            position.x = position.x + speed * random_x;
////            position.y = position.y + speed * random_y;
//
//            Vector acceleration = new Vector(rand.nextDouble(-1, 1), rand.nextDouble(-1, 1));
//            location.add(velocity);
//            velocity.add(acceleration);
//
//            if (velocity.getVectorLength() >= maxSpeed) acceleration = acceleration.multiply(0);
//
//            limit();
//            var food = foodHashMap.entrySet().stream()
//                    .filter(keySet -> {
//                        var key = keySet.getKey();
//                        if (pow((keySet.getKey().position.x-position.x),2)<25 && pow(keySet.getKey().position.y - position.y, 2) < 25) return true;
//                        return false;//czy moge tu metode
//                    }).findAny().orElse(null);
//
//            if (food != null) {
//                equipmentFood = food.getValue();
//                while (pow((position.x - settlement.position.x), 2) > 25 && pow((position.y - settlement.position.y), 2) > 25) {
//                    Vector returnVelocity = new Vector(settlement.position.x - position.x, settlement.position.y - position.y);
//
//                    location.add(returnVelocity.normalize());
//
//                    limit();
//                }//powrot do osady
//                Settlement.getOwnedFood(foodHashMap.get(position).nourishment);
//            }
//
//            var buildingMaterials = buildingMaterialsHashMap.entrySet().stream()
//                    .filter(keySet -> {
//                        var key = keySet.getKey();
//                        if (pow((keySet.getKey().position.x-position.x),2)<25 && pow(keySet.getKey().position.y - position.y, 2) < 25) return true;
//                        return false;
//                    }).findAny().orElse(null);
//
//            if (buildingMaterials != null){
//                equipmentBuildingMaterials = buildingMaterials.getValue();
//                while (pow((position.x - settlement.position.x), 2) > 25 && pow((position.y - settlement.position.y), 2) > 25) {
//                    Vector returnVelocity = new Vector(settlement.position.x - position.x, settlement.position.y - position.y);
//
//                    location.add(returnVelocity.normalize());
//
//                    limit();
//                }
//                Settlement.getOwnedBuildingMaterials(buildingMaterialsHashMap.get(position).constructionValue); //
//
//            }
//        }
//    }
    public void movement(ArrayList<FoodLocation> foodLocationList, ArrayList<BuildingMaterialsLocation> buildingMaterialsLocationList) {
        if (!isMoving) {
            if (System.currentTimeMillis() - lastStopTimestamp >= stoppedFor) isMoving = false;
            else return;
        }
        Random rand = new Random();
        Vector location = new Vector(position.x, position.y);
        Vector velocity = new Vector(0, 0);

        Vector acceleration = new Vector(rand.nextDouble(-1, 1), rand.nextDouble(-1, 1));
        location.add(velocity);
        velocity.add(acceleration);

        if (velocity.getVectorLength() >= maxSpeed) acceleration = acceleration.multiply(0);

        limit();
        var foodLocation = foodLocationList.stream()
                .filter(fd -> fd.position.equals(position)).findAny().orElse(null);

        if (foodLocation != null) {
            while (pow((position.x - foodLocation.position.x), 2) > 4 && pow((position.y - foodLocation.position.y), 2) > 4) {
                Vector getFood = new Vector(foodLocation.position.x - position.x, foodLocation.position.y - position.y);

                location.add(getFood.normalize());

                limit();
            }//idk

            while (pow((position.x - settlement.position.x), 2) > 25 && pow((position.y - settlement.position.y), 2) > 25) {
                Vector returnVelocity = new Vector(settlement.position.x - position.x, settlement.position.y - position.y);

                location.add(returnVelocity.normalize());

                limit();
            }//powrot do osady
            settlement.getOwnedNourishment(foodLocation.nourishment);
        }

        var buildingMaterialsLocation = buildingMaterialsLocationList.stream()
                .filter(buildingMaterials -> buildingMaterials.position.equals(position)).findAny().orElse(null);
        if (buildingMaterialsLocation != null) {
            while (pow((position.x - buildingMaterialsLocation.position.x), 2) > 4 && pow((position.y - buildingMaterialsLocation.position.y), 2) > 4) {
                Vector getFood = new Vector(buildingMaterialsLocation.position.x - position.x, buildingMaterialsLocation.position.y - position.y);

                location.add(getFood.normalize());

                limit();
            }
            isMoving = true;
            stoppedFor = buildingMaterialsLocation.extractionTime;
            lastStopTimestamp = System.currentTimeMillis();
            if (buildingMaterialsLocation != null) {
                while (pow((position.x - settlement.position.x), 2) > 25 && pow((position.y - settlement.position.y), 2) > 25) {
                    Vector returnVelocity = new Vector(settlement.position.x - position.x, settlement.position.y - position.y);

                    location.add(returnVelocity.normalize());

                    limit();
                }
                settlement.getOwnedBuildingMaterials(buildingMaterialsLocation.name);
            }
        }
    }

    private void limit() {
        if (position.x > MapCreation.size.x) position.x = 0;
        if (position.x < 0) position.x = MapCreation.size.x;
        if (position.y > MapCreation.size.y) position.y = 0;
        if (position.y < 0) position.y = MapCreation.size.y;
    }


}
