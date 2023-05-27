package org.example;

import java.util.Scanner;

public class Input {
    Coordinates size;
    int numberSettlements;
    int numberFood;
    int numberBuildingMaterials;

    /*
    public Input(Coordinates size, int numberSettlements, int numberFood, int numberBuildingMaterials){
        this.size = size;
        this.numberSettlements = numberSettlements;
        this.numberFood = numberFood;
        this. numberBuildingMaterials = numberBuildingMaterials;
    } */

    public void askSize(){
        System.out.println("Enter map size:");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        MapCreation.size.x = size;
        MapCreation.size.y = size;
    }
    public void askSettlements(){
        System.out.println("Enter number of settlements:");
        Scanner scanner = new Scanner(System.in);
        numberSettlements = scanner.nextInt();
    }
    public void askFood(){
        System.out.println("Enter number of food locations:");
        Scanner scanner = new Scanner(System.in);
        numberFood = scanner.nextInt();
    }
    public void numberBuildingMaterials(){
        System.out.println("Enter number of food locations:");
        Scanner scanner = new Scanner(System.in);
        numberBuildingMaterials = scanner.nextInt();
    }
    public Coordinates getSize(){
        return size;
    }
}
