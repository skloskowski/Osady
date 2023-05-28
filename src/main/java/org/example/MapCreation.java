package org.example;

import java.util.List;
import java.util.Random;

public class MapCreation {
    static Coordinates size = new Coordinates(0,0);

    static public void CreateMap(List<BuildingMaterialsLocation> buildList, List<FoodLocation> foodList, List<Settlement> settlementList, List<Settler> settlerList){


    }
    static public void CreateSettlements(int numberSettlements, List<Settlement> list, List<Coordinates> occupiedSpace){

        Random rand = new Random();
        Coordinates randCords = Coordinates.RandomCoordinates();

        for (int i = 0; i < numberSettlements;i++){

            while(randCords.alreadyOccupied(occupiedSpace)) randCords = Coordinates.RandomCoordinates();

            Settlement settlement = new Settlement(
                    3,
                    rand.nextFloat(9.0f) + 1.0f,
                    0,
                    randCords
            );

            list.add(settlement);
            occupiedSpace.add(settlement.position);
        }
    }

    static public void CreateFoodLocations(int numberFood, List<FoodLocation> list, List<Coordinates> occupiedSpace){
        Coordinates randCords = Coordinates.RandomCoordinates();

        for (int i = 0; i < numberFood; i++){

            while(randCords.alreadyOccupied(occupiedSpace)) randCords = Coordinates.RandomCoordinates();

            if ( i % 2 == 0){
                FoodLocation foodLocation = new FoodLocation(
                        "Vegetables",
                        5,
                        randCords
                );
            }else{
                FoodLocation foodLocation = new FoodLocation(
                        "Meat",
                        8,
                        randCords
                );
            }
        }
    }

    static public void CreateBuildingMaterialsLocations(int numberBuildingMaterials, List<BuildingMaterialsLocation> list, List<Coordinates> occupiedSpace){
        Coordinates randCords = Coordinates.RandomCoordinates();

        for (int i = 0; i< numberBuildingMaterials; i++){

            while(randCords.alreadyOccupied(occupiedSpace)) randCords = Coordinates.RandomCoordinates();

            if (i % 3 == 0){
                BuildingMaterialsLocation buildingMaterialsLocation = new BuildingMaterialsLocation(
                        "Stone",
                        50,
                        25,
                        randCords
                );
            }else if (i % 3 == 1){
                BuildingMaterialsLocation buildingMaterialsLocation = new BuildingMaterialsLocation(
                        "Wood",
                        30,
                        10,
                        randCords
                );
            }else{
                BuildingMaterialsLocation buildingMaterialsLocation = new BuildingMaterialsLocation(
                        "Clay",
                        70,
                        50,
                        randCords
                );
            }
        }
    }

}
