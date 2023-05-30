package org.example;


import java.util.List;

public class Output {

    public static void GetStats(List<Settlement> settlementList){
        //print resources and population of each Settlement

        Settlement bestSettlement = settlementList.get(0);
        int id = 0;

        for (int i = 0; i < settlementList.size(); i++){
            if (settlementList.get(i).ownedNourishment > bestSettlement.ownedNourishment){
                bestSettlement = settlementList.get(i);
                id = i;
            }
        }

        System.out.println("Settlement ID: " + id + " has gathered the most food: " + bestSettlement.ownedNourishment + " Color (RGB): " + bestSettlement.getColor().getRed() + " " + bestSettlement.getColor().getGreen() + " " + bestSettlement.getColor().getBlue());

        for (int i = 0; i < settlementList.size(); i++){
            if (settlementList.get(i).population > bestSettlement.population) {
                bestSettlement = settlementList.get(i);
                id = i;
            }
        }

        System.out.println("Settlement ID: " + id + " has gathered the most population: " + bestSettlement.population + " Color: " + bestSettlement.getColor().getRed() + " " + bestSettlement.getColor().getGreen() + " " + bestSettlement.getColor().getBlue());
    }

    public static void getFinalStats(List<Settlement> settlementList, List<Settler> settlerList){

        Settlement bestSettlement = settlementList.get(0);
        int id = 0;

        System.out.println("----- FINAL STATS ----");
        System.out.println("Amount of settlers on the map: " + settlerList.size());

        System.out.println("Settlement with most...");

        for (int i = 0; i < settlementList.size(); i++){
            if (settlementList.get(i).ownedNourishment > bestSettlement.ownedNourishment){
                bestSettlement = settlementList.get(i);
                id = i;
            }
        }

        System.out.println("Food: ID:" + id + " Color: " + bestSettlement.getColor().getRed() + " " + bestSettlement.getColor().getGreen() + " " + bestSettlement.getColor().getBlue() + " amount: " + bestSettlement.ownedNourishment);

        for (int i = 0; i < settlementList.size(); i++){
            if (settlementList.get(i).getWoodAmount() > bestSettlement.getWoodAmount()){
                bestSettlement = settlementList.get(i);
                id = i;
            }
        }

        System.out.println("Wood: ID:" + id + " Color: " + bestSettlement.getColor().getRed() + " " + bestSettlement.getColor().getGreen() + " " + bestSettlement.getColor().getBlue() + " amount: " + bestSettlement.getWoodAmount());

        for (int i = 0; i < settlementList.size(); i++){
            if (settlementList.get(i).getStoneAmount() > bestSettlement.getStoneAmount()){
                bestSettlement = settlementList.get(i);
                id = i;
            }
        }

        System.out.println("Stone: ID:" + id + " Color: " + bestSettlement.getColor().getRed() + " " + bestSettlement.getColor().getGreen() + " " + bestSettlement.getColor().getBlue() + " amount: " + bestSettlement.getStoneAmount());

        /*
        for (int i = 0; i < settlementList.size(); i++){
            if (settlementList.get(i).getClayAmount() > bestSettlement.getClayAmount()){
                bestSettlement = settlementList.get(i);
                id = i;
            }
        }

        System.out.println("Clay: ID:" + id + " Color: " + bestSettlement.getColor().getRed() + " " + bestSettlement.getColor().getGreen() + " " + bestSettlement.getColor().getBlue() + " amount: " + bestSettlement.getClayAmount());
        */

    }
}
