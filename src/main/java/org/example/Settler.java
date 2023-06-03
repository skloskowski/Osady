package org.example;


import java.awt.*;
import java.util.List;
import java.util.Random;

import static java.lang.Math.*;

public class Settler{

    public Settlement getSettlement() {
        return settlement;
    }
    public Color getColor() {
        return color;
    }
    public Coordinates getPosition() {
        return position;
    }
    private Settlement settlement;
    private float maxSpeed;
    private Coordinates position;
    private Color color;
    private boolean isMoving = true;
    private long lastStopTimestamp;
    private long stoppedFor;
    private boolean equiped = false;

    private FoodLocation lastTakenFromFood;
    private BuildingMaterialsLocation lastTakenFromBuild;

    public Settler(Coordinates position, Settlement settlement) {
        this.position = position;
        this.settlement = settlement;
        this.maxSpeed = settlement.getSpeed();
        this.color = settlement.getColor();
        lastTakenFromFood = null;
        lastTakenFromBuild = null;
    }

    /***
     * move to random location unless there is foodLocation or BuildingMaterialLocation nearby then move towards it
     * @param foodLocationList list of all foodLocations
     * @param buildingMaterialsLocationList list of all buildingMaterialsLocation
     */
    public void movement(List<FoodLocation> foodLocationList, List<BuildingMaterialsLocation> buildingMaterialsLocationList) {

        if (!isMoving) {
            if (System.currentTimeMillis() - lastStopTimestamp >= stoppedFor) isMoving = false;
            else return;
        }

        Random rand = new Random();
        Vector location = new Vector(position.getX(), position.getY());
        Vector velocity = new Vector(0, 0);

        Vector acceleration = new Vector(rand.nextDouble(-1*maxSpeed, 1*maxSpeed), rand.nextDouble(-1*maxSpeed, 1*maxSpeed));
        velocity = velocity.add(acceleration);
        location = location.add(velocity);

        position = limit(location.getX(), location.getY());

        var foodLocation = foodLocationList.stream()
                .filter(food -> {
                    if (pow(position.getX() - food.getPosition().getX(), 2) <= 25 && pow(position.getY() - food.getPosition().getY(), 2) <= 25)
                        return true;
                    return false;
                }).findAny().orElse(null);

        if (foodLocation != null ) {
            equiped = true;
            Vector getFood = new Vector(foodLocation.getPosition().getX() - position.getX(), foodLocation.getPosition().getY() - position.getY());

            location.add(getFood.normalize());

            position = limit(location.getX(), location.getY());

            if (equiped) {
                Vector returnVelocity = new Vector(settlement.getPosition().getX() - position.getX(), settlement.getPosition().getY() - position.getY());

                location.add(returnVelocity.normalize());

                position = limit(location.getX(), location.getY());

                if (lastTakenFromFood != foodLocation){
                    settlement.getOwnedNourishment(foodLocation.getNourishment());
                    lastTakenFromFood = foodLocation;
                }

            }
        }


        var buildingMaterialsLocation = buildingMaterialsLocationList.stream()
                .filter(x -> {
                  if(pow(position.getX()- x.getPosition().getX(),2) <= 25 && pow(position.getY()-x.getPosition().getY(),2) <= 25)
                    return false;
                  return true;
                }).findAny().orElse(null);
        if (buildingMaterialsLocation != null) {
                Vector getFood = new Vector(buildingMaterialsLocation.getPosition().getX() - position.getX(), buildingMaterialsLocation.getPosition().getY() - position.getY());

                location.add(getFood.normalize());

                position = limit(location.getX(), location.getY());

            isMoving = true;
            stoppedFor = buildingMaterialsLocation.extractionTime;
            lastStopTimestamp = System.currentTimeMillis();
            if(equiped) {
                Vector returnVelocity = new Vector(settlement.getPosition().getX() - position.getX(), settlement.getPosition().getY() - position.getY());

                location.add(returnVelocity.normalize());

                position = limit(location.getX(), location.getY());

                if (lastTakenFromBuild != buildingMaterialsLocation){
                    settlement.getOwnedBuildingMaterials(buildingMaterialsLocation.getName());
                    lastTakenFromBuild = buildingMaterialsLocation;
                }


            }
        }

        position = limit(location.getX(), location.getY());

    }

    /***
     * if x or y is bigger than map size move to opposing edge of map
     * @param x position x
     * @param y position y
     * @return coordinates x, y
     */
    private Coordinates limit(double x, double y) {
        if (x >= MapCreation.size.getX()) x = 1;
        if (x <= 0) x = MapCreation.size.getX() - 1;
        if (y >= MapCreation.size.getY()) y = 1;
        if (y <= 0) y = MapCreation.size.getY() - 1;
        return new Coordinates((int) round(x),(int) round(y));
    }

}
