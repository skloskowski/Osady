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


    }

    /*
    @Override
    public void start(Stage primaryStage) {

    }

     */
}