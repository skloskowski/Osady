package org.example;


import java.awt.*;
import java.util.List;
import java.util.Random;

import static java.lang.Math.*;

public class Settler{

    Settlement settlement;
    float maxSpeed;
    Coordinates position;
    Color color;
    boolean isMoving = true;
    long lastStopTimestamp;
    long stoppedFor;
    boolean equiped = false;

    FoodLocation lastTakenFromFood;
    BuildingMaterialsLocation lastTakenFromBuild;

    public Settler(Coordinates position, Settlement settlement) {
        this.position = position;
        this.settlement = settlement;
        this.maxSpeed = settlement.getSpeed();
        this.color = settlement.color;
        lastTakenFromFood = null;
        lastTakenFromBuild = null;
    }

    public Coordinates getPosition() {
        return position;
    }

    public void movement(List<FoodLocation> foodLocationList, List<BuildingMaterialsLocation> buildingMaterialsLocationList) {

        if (!isMoving) {
            if (System.currentTimeMillis() - lastStopTimestamp >= stoppedFor) isMoving = false;
            else return;
        }

        Random rand = new Random();
        Vector location = new Vector(position.x, position.y);
        Vector velocity = new Vector(0, 0);

        Vector acceleration = new Vector(rand.nextDouble(-1*maxSpeed, 1*maxSpeed), rand.nextDouble(-1*maxSpeed, 1*maxSpeed));
        velocity = velocity.add(acceleration);
        location = location.add(velocity);

        position = limit(location.getX(), location.getY());

//        position.x = (int) round(location.getX());
//        position.y = (int) round(location.getY());

        var foodLocation = foodLocationList.stream()
                .filter(food -> {
                    if (pow(position.x - food.position.x, 2) <= 25 && pow(position.y - food.position.y, 2) <= 25)
                        return true;
                    return false;
                }).findAny().orElse(null);

        if (foodLocation != null ) {
            equiped = true;
            Vector getFood = new Vector(foodLocation.position.x - position.x, foodLocation.position.y - position.y);

            location.add(getFood.normalize());

            position = limit(location.getX(), location.getY());


//                position.x = (int) round(location.getX());
//                position.y = (int) round(location.getY());
            if (equiped) {
                Vector returnVelocity = new Vector(settlement.position.x - position.x, settlement.position.y - position.y);

                location.add(returnVelocity.normalize());

                position = limit(location.getX(), location.getY());

//                position.x = (int) round(location.getX());
//                position.y = (int) round(location.getY());


                if (lastTakenFromFood != foodLocation){
                    settlement.getOwnedNourishment(foodLocation.nourishment);
                    lastTakenFromFood = foodLocation;
                }

            }
        }


        var buildingMaterialsLocation = buildingMaterialsLocationList.stream()
                .filter(x -> {
                  if(pow(position.x- x.position.x,2) <= 25 && pow(position.y-x.position.y,2) <= 25)
                    return false;
                  return true;
                }).findAny().orElse(null);//nie equals musi byc w poblizu a nie rowne
        if (buildingMaterialsLocation != null) {
                Vector getFood = new Vector(buildingMaterialsLocation.position.x - position.x, buildingMaterialsLocation.position.y - position.y);

                location.add(getFood.normalize());

                position = limit(location.getX(), location.getY());

//                position.x = (int) round(location.getX());
//                position.y = (int) round(location.getY());

            isMoving = true;
            stoppedFor = buildingMaterialsLocation.extractionTime;
            lastStopTimestamp = System.currentTimeMillis();
            if(equiped) {
                Vector returnVelocity = new Vector(settlement.position.x - position.x, settlement.position.y - position.y);

                location.add(returnVelocity.normalize());

                position = limit(location.getX(), location.getY());

//                position.x = (int) round(location.getX());
//                position.y = (int) round(location.getY());


                if (lastTakenFromBuild != buildingMaterialsLocation){
                    settlement.getOwnedBuildingMaterials(buildingMaterialsLocation.name);
                    lastTakenFromBuild = buildingMaterialsLocation;
                }


            }
        }

        position = limit(location.getX(), location.getY());

    }


    private Coordinates limit(double x, double y) {
        if (x >= MapCreation.size.x) x = 1;
        if (x <= 0) x = MapCreation.size.x - 1;
        if (y >= MapCreation.size.y) y = 1;
        if (y <= 0) y = MapCreation.size.y - 1;
        return new Coordinates((int) round(x),(int) round(y));
    }
    public Color getColor() {
        return color;
    }

}
