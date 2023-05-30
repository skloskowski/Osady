package org.example;

import java.util.List;

public class Main {
    static public void moveSettlers(List<Settler> settlerList, List<FoodLocation>foodLocationList, List<BuildingMaterialsLocation>buildingMaterialsLocationList){
        for (Settler settler : settlerList) {
            settler.movement(foodLocationList, buildingMaterialsLocationList);
        }
    }
    static public void addSettlers(List<Settler> settlerList, Settlement settlement){
        if(0 < settlement.changePopulation()){
            for(int i = 0; i < settlement.changePopulation(); i++){
                Settler settler = new Settler(settlement.getPosition(), settlement);
                settlerList.add(settler);
                settlement.population++;
            }
        }

        if(0 > settlement.changePopulation()) {
            for (int i = 0; i < settlement.changePopulation() * (-1); i++) {
                for (Settler x : settlerList) {
                    if (x.getSettlement().equals(settlement)) {
                        settlerList.remove(x);
                        settlement.population--;
                        break;
                    }
                }
            }
        }
    }
}