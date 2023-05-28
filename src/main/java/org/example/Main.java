package org.example;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class Main {
    public static void main(String[] args) {
        // launch(args);

        List<Coordinates> occupiedSpace = new ArrayList<>();
        List<Settlement> settlementList = new ArrayList<>();
        List<Settler> settlerList = new ArrayList<>();
        List<FoodLocation> foodLocationList = new ArrayList<>();
        List<BuildingMaterialsLocation> buildingMaterialsLocationList = new ArrayList<>();

        Input input = new Input();
        input.askInitialValues();

        MapCreation.CreateMap(buildingMaterialsLocationList, foodLocationList, settlementList, settlerList, occupiedSpace, input.numberSettlements, input.numberFood, input.numberBuildingMaterials, input.numberStartingSettlers);
        int movesPerDay = 0;
        int days = 0;
        while(days <= 10) {//waruenk2
            while (movesPerDay <= 20) {//warunek
                moveSettlers(settlerList, foodLocationList, buildingMaterialsLocationList);
                movesPerDay++;
            }
            for (Settlement settlement : settlementList) {
                settlement.changePopulation(settlement.population);
            }
            days++;
        }
    }
    static public void moveSettlers(List<Settler> settlerList, List<FoodLocation>foodLocationList, List<BuildingMaterialsLocation>buildingMaterialsLocationList){
        for (Settler settler : settlerList) {
            settler.movement(foodLocationList, buildingMaterialsLocationList);
        }
    }
    /*
    @Override
    public void start(Stage primaryStage) {

    }

     */
}