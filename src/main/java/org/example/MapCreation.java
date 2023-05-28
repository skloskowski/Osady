package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MapCreation {
    static Coordinates size = new Coordinates(0,0);
    int numberSettlements;
    int numberFood;
    int numberBuildingMaterials;

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

    static public void CreateFoodLocations(int numberFood, List<FoodLocation> list){

    }

    static public void CreateBuildingMaterialsLocations(int numberBuildingMaterials, List<BuildingMaterialsLocation> list){

    }

}
