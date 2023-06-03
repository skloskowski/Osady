package org.example;

import java.util.List;
import java.util.Random;

public class MapCreation {
    static Coordinates size = new Coordinates(500,500);

    /***
     * grouping of all createX methods
     * @param buildList
     * @param foodList
     * @param settlementList
     * @param settlerList
     * @param occupiedSpace
     * @param numberSettlements
     * @param numberFood
     * @param numberBuildingMaterials
     * @param startingSettlers
     */
    static public void CreateMap(List<BuildingMaterialsLocation> buildList, List<FoodLocation> foodList, List<Settlement> settlementList, List<Settler> settlerList, List<Coordinates> occupiedSpace , int numberSettlements, int numberFood, int numberBuildingMaterials, int startingSettlers){

        CreateSettlements(numberSettlements, settlementList, occupiedSpace, startingSettlers);
        CreateFoodLocations(numberFood, foodList, occupiedSpace);
        CreateBuildingMaterialsLocations(numberBuildingMaterials, buildList, occupiedSpace);
        CreateStartSettlers(startingSettlers, settlerList, settlementList);
    }

    /***
     * creates numberSettlements settlements and adds them to list
     * @param numberSettlements number of settlements to create
     * @param list list of all settlements
     * @param occupiedSpace list of occupied spaces
     * @param numberStartingSettlers number of starting settlers for each settlement
     */
    static public void CreateSettlements(int numberSettlements, List<Settlement> list, List<Coordinates> occupiedSpace, int numberStartingSettlers){

        Random rand = new Random();
        Coordinates randCords = Coordinates.randomCoordinates();

        for (int i = 0; i < numberSettlements;i++){

            while(randCords.alreadyOccupied(occupiedSpace)) randCords = Coordinates.randomCoordinates();

            Settlement settlement = new Settlement(
                    numberStartingSettlers,
                    rand.nextFloat(9.0f) + 1.0f,
                    0,
                    randCords
            );

            list.add(settlement);
            occupiedSpace.add(settlement.getPosition());
        }
    }

    /***
     * creates numberFood locations and adds them to list
     * @param numberFood number of all foodLocations to create
     * @param list list of all FoodLocations
     * @param occupiedSpace list of occupied spaces
     */
    static public void CreateFoodLocations(int numberFood, List<FoodLocation> list, List<Coordinates> occupiedSpace){
        Coordinates randCords = Coordinates.randomCoordinates();

        for (int i = 0; i < numberFood; i++){

            while(randCords.alreadyOccupied(occupiedSpace)) randCords = Coordinates.randomCoordinates();

            FoodLocation foodLocation;
            if ( i % 2 == 0){
                foodLocation = new FoodLocation(
                        "Vegetables",
                        5,
                        randCords
                );

            }else{
                foodLocation = new FoodLocation(
                        "Meat",
                        8,
                        randCords
                );
            }

            list.add(foodLocation);
            occupiedSpace.add(foodLocation.getPosition());
        }
    }

    /***
     * creates numberBuildingMaterials locations adds them to list
     * @param numberBuildingMaterials number of all BuildingMaterialsLocation to create
     * @param list list of all BuildingMaterialsLocations
     * @param occupiedSpace list of occupied spaces
     */
    static public void CreateBuildingMaterialsLocations(int numberBuildingMaterials, List<BuildingMaterialsLocation> list, List<Coordinates> occupiedSpace){
        Coordinates randCords = Coordinates.randomCoordinates();

        for (int i = 0; i< numberBuildingMaterials; i++){

            while(randCords.alreadyOccupied(occupiedSpace)) randCords = Coordinates.randomCoordinates();

            if (i % 3 == 0){
                BuildingMaterialsLocation buildingMaterialsLocation = new BuildingMaterialsLocation(
                        "Stone",
                        50,
                        25,
                        randCords
                );

                list.add(buildingMaterialsLocation);
                occupiedSpace.add(buildingMaterialsLocation.getPosition());

            }else if (i % 3 == 1){
                BuildingMaterialsLocation buildingMaterialsLocation = new BuildingMaterialsLocation(
                        "Wood",
                        30,
                        10,
                        randCords
                );

                list.add(buildingMaterialsLocation);
                occupiedSpace.add(buildingMaterialsLocation.getPosition());

            }
        }
    }

    /***
     * creates startingSettlers number of settlers to corresponding settlements and and them to settlerList
     * @param startingSettlers number of starting settlers
     * @param settlerList list of all settlers
     * @param settlementList list of all settlements
     */
    static public void CreateStartSettlers(int startingSettlers, List<Settler> settlerList, List<Settlement> settlementList){

        for (int j = 0; j < settlementList.size(); j++){
            for (int i = 0; i < startingSettlers; i++){

                Settler settler = new Settler(settlementList.get(j).getPosition(), settlementList.get(j));

                settlerList.add(settler);
            }
        }
    }


}
