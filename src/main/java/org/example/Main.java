package org.example;

import javafx.application.Application;
import javafx.stage.Stage;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args) {

        Output output = new Output();
        output.main(args);


        List<Coordinates> occupiedSpace = new ArrayList<>();
        List<Settlement> settlementList = new ArrayList<>();
        List<Settler> settlerList = new ArrayList<>();
        List<FoodLocation> foodLocationList = new ArrayList<>();
        List<BuildingMaterialsLocation> buildingMaterialsLocationList = new ArrayList<>();

        // Input input = new Input();
        // input.askInitialValues();
        MapCreation mapCreation = new MapCreation();
        MapCreation.CreateMap(buildingMaterialsLocationList, foodLocationList, settlementList, settlerList, occupiedSpace, 5, 5, 5, 3);

        // MapCreation.CreateMap(buildingMaterialsLocationList, foodLocationList, settlementList, settlerList, occupiedSpace, input.numberSettlements, input.numberFood, input.numberBuildingMaterials, input.numberStartingSettlers);
        //movement
        int tickCount = 0;
        int day = 0;


        System.out.println(occupiedSpace.size());
        System.out.println(settlementList.size());
        System.out.println(settlerList.size());

        while(day < mapCreation.getMaxDays()) {//waruenk2
            while (tickCount < mapCreation.getTicksDaily()) {//warunek
                moveSettlers(settlerList, foodLocationList, buildingMaterialsLocationList);
                tickCount++;

                output.step();
            }
            for (Settlement settlement : settlementList) {
                addSettlers(settlerList,settlement);
            }
            day++;

            System.out.println("ilosc = " + settlerList.size());
            System.out.println("wartosc nourishment = " + settlementList.get(0).ownedNourishment);
        }

    }
    static public void moveSettlers(List<Settler> settlerList, List<FoodLocation>foodLocationList, List<BuildingMaterialsLocation>buildingMaterialsLocationList){
        for (Settler settler : settlerList) {
            settler.movement(foodLocationList, buildingMaterialsLocationList);
        }
    }
    static public void addSettlers(List<Settler> settlerList, Settlement settlement){
        if(0 < settlement.changePopulation()){
            for(int i = 0; i < settlement.changePopulation() - settlement.population; i++){
                Settler settler = new Settler(settlement.position, settlement);
                settlerList.add(settler);
            }
        }

        if(0 > settlement.changePopulation()) {
            for (int i = 0; i < settlement.changePopulation()*(-1); i++) {
                for (Settler x : settlerList) {
                    if (x.settlement.equals(settlement)) {
                        settlerList.remove(x);
                        break;
                    }
                }
            }
        }


    }

}