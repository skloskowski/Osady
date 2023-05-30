package org.example;

import org.example.ui.Canvas;
import org.w3c.dom.ls.LSOutput;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // launch(args);

        /*
        List<Coordinates> occupiedSpace = new ArrayList<>();
        List<Settlement> settlementList = new ArrayList<>();
        List<Settler> settlerList = new ArrayList<>();
        List<FoodLocation> foodLocationList = new ArrayList<>();
        List<BuildingMaterialsLocation> buildingMaterialsLocationList = new ArrayList<>();

        // Input input = new Input();
        // input.askInitialValues();

        MapCreation.CreateMap(buildingMaterialsLocationList, foodLocationList, settlementList, settlerList, occupiedSpace, 5, 5, 5, 3);

        // MapCreation.CreateMap(buildingMaterialsLocationList, foodLocationList, settlementList, settlerList, occupiedSpace, input.numberSettlements, input.numberFood, input.numberBuildingMaterials, input.numberStartingSettlers);
        //movement

        System.out.println(occupiedSpace.size());
        System.out.println(settlementList.size());
        System.out.println(settlerList.size());

        int days = 0;
        int movesPerDay;
        while(days < 10) {//waruenk2
            movesPerDay = 0;
            while (movesPerDay < 40) {//warunek

                moveSettlers(settlerList, foodLocationList, buildingMaterialsLocationList);
                System.out.println("lokalizacja  = " + settlerList.get(0).position.x + " " + settlerList.get(0).position.y);
                movesPerDay++;
            }
            for (Settlement settlement : settlementList) {
                addSettlers(settlerList,settlement);
            }
            days++;
            System.out.println("ilosc = " + settlerList.size());
            System.out.println("wartosc nourishment = " + settlementList.get(0).ownedNourishment);
        }


         */
    }
    static public void moveSettlers(List<Settler> settlerList, List<FoodLocation>foodLocationList, List<BuildingMaterialsLocation>buildingMaterialsLocationList){
        for (Settler settler : settlerList) {
            settler.movement(foodLocationList, buildingMaterialsLocationList);
        }
    }
    static public void addSettlers(List<Settler> settlerList, Settlement settlement){
        if(0 < settlement.changePopulation()){
            for(int i = 0; i < settlement.changePopulation(); i++){
                Settler settler = new Settler(settlement.position, settlement);
                settlerList.add(settler);
                settlement.population++;
            }
        }

        if(0 > settlement.changePopulation()) {
            for (int i = 0; i < settlement.changePopulation() * (-1); i++) {
                for (Settler x : settlerList) {
                    if (x.settlement.equals(settlement)) {
                        settlerList.remove(x);
                        settlement.population--;
                        break;
                    }
                }
            }
        }
    }
    /*
    @Override
    public void start(Stage primaryStage) {

    }

     */
}