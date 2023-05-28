package org.example;

import java.util.Scanner;

import java.util.Random;
import java.util.Scanner;

public class Input {
    Coordinates size;
    int numberSettlements;
    int numberFood;
    int numberBuildingMaterials;
    int numberStartingSettlers;

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

    public void askStartingSettlers(){
        System.out.println("Enter number of starting settlers of each settlement:");
        Scanner scanner = new Scanner(System.in);
        numberStartingSettlers = scanner.nextInt();
    }
    public void askFood(){
        System.out.println("Enter number of food locations:");
        Scanner scanner = new Scanner(System.in);
        numberFood = scanner.nextInt();
    }
    public void askNumberBuildingMaterials(){
        System.out.println("Enter number of building materials locations:");
        Scanner scanner = new Scanner(System.in);
        numberBuildingMaterials = scanner.nextInt();
    }

    public void askInitialValues(){
        askSize();
        askSettlements();
        askFood();
        askNumberBuildingMaterials();
        askStartingSettlers();
    }
    public Coordinates getSize(){
        return size;
    }
    //color randomization

}
