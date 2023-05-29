package org.example;

import javafx.scene.paint.Color;

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

    public Settler(Coordinates position, Settlement settlement) {
        // this.colour = colour;
        this.position = position;
        this.settlement = settlement;
        this.maxSpeed = settlement.getSpeed();
        this.color = settlement.color;
    }

    public void movement(List<FoodLocation> foodLocationList, List<BuildingMaterialsLocation> buildingMaterialsLocationList) {

        if (!isMoving) {
            if (System.currentTimeMillis() - lastStopTimestamp >= stoppedFor) isMoving = false;
            else return;
        }

        Random rand = new Random();
        Vector location = new Vector(position.x, position.y);
        Vector velocity = new Vector(0, 0);

        Vector acceleration = new Vector(rand.nextDouble(-1, 1), rand.nextDouble(-1, 1));
        velocity = velocity.add(acceleration);
        location = location.add(velocity);
        position.x = (int) round(location.getX());
        position.y = (int) round(location.getY());

        if (velocity.getVectorLength() >= maxSpeed) acceleration = acceleration.multiply(0);

        limit();
        var foodLocation = foodLocationList.stream()
                .filter(food -> food.position.equals(position)).findAny().orElse(null);

        if (foodLocation != null) {
            while (pow((location.getX() - foodLocation.position.x), 2) > 4 && pow((location.getY() - foodLocation.position.y), 2) > 4) {
                Vector getFood = new Vector(foodLocation.position.x - location.getX(), foodLocation.position.y - location.getY());

                location.add(getFood.normalize());
                position.x = (int) round(location.getX());
                position.y = (int) round(location.getY());

                limit();
            }//idk

            while (pow((location.getX() - settlement.position.x), 2) > 25 && pow((location.getY() - settlement.position.y), 2) > 25) {
                Vector returnVelocity = new Vector(settlement.position.x - location.getX(), settlement.position.y - location.getY());

                location.add(returnVelocity.normalize());
                position.x = (int) round(location.getX());
                position.y = (int) round(location.getY());

                limit();
            }//powrot do osady
            settlement.getOwnedNourishment(foodLocation.nourishment);
        }

        var buildingMaterialsLocation = buildingMaterialsLocationList.stream()
                .filter(buildingMaterials -> buildingMaterials.position.equals(position)).findAny().orElse(null);//hm?
        if (buildingMaterialsLocation != null) {
            while (pow((location.getX() - buildingMaterialsLocation.position.x), 2) > 4 && pow((location.getY() - buildingMaterialsLocation.position.y), 2) > 4) {
                Vector getFood = new Vector(buildingMaterialsLocation.position.x - location.getX(), buildingMaterialsLocation.position.y - location.getY());

                location.add(getFood.normalize());
                position.x = (int) round(location.getX());
                position.y = (int) round(location.getY());

                limit();
            }
            isMoving = true;
            stoppedFor = buildingMaterialsLocation.extractionTime;
            lastStopTimestamp = System.currentTimeMillis();
            if (buildingMaterialsLocation != null) {
                while (pow((location.getX() - settlement.position.x), 2) > 25 && pow((location.getY() - settlement.position.y), 2) > 25) {
                    Vector returnVelocity = new Vector(settlement.position.x - location.getX(), settlement.position.y - location.getY());

                    location.add(returnVelocity.normalize());
                    position.x = (int) round(location.getX());
                    position.y = (int) round(location.getY());

                    limit();
                }
                settlement.getOwnedBuildingMaterials(buildingMaterialsLocation.name);
            }
        }
        position.x = (int) round(location.getX());
        position.y = (int) round(location.getY());
    }


    private void limit() {
        if (position.x >= MapCreation.size.x) position.x = 1;
        if (position.x <= 0) position.x = MapCreation.size.x - 1;
        if (position.y >= MapCreation.size.y) position.y = 1;
        if (position.y <= 0) position.y = MapCreation.size.y - 1;

    }

}
