package org.example;

import java.util.Scanner;

public class Input {
    private int numberSettlements;
    private int numberFood;
    private int numberBuildingMaterials;
    private int numberStartingSettlers;

    public void askSize(){
        System.out.println("Enter map size:");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        MapCreation.size.setX(size);
        MapCreation.size.setY(size);
    }
    public void askSettlements(){
        System.out.println("Enter number of settlements:");
        Scanner scanner = new Scanner(System.in);
        numberSettlements = scanner.nextInt();
    }
    public int getSettlements(){
        return numberSettlements;
    }

    public void askStartingSettlers(){
        System.out.println("Enter number of starting settlers of each settlement:");
        Scanner scanner = new Scanner(System.in);
        numberStartingSettlers = scanner.nextInt();
    }

    public int getStartingSettlers(){
        return numberStartingSettlers;
    }
    public void askFood(){
        System.out.println("Enter number of food locations:");
        Scanner scanner = new Scanner(System.in);
        numberFood = scanner.nextInt();
    }

    public int getFood(){
        return numberFood;
    }
    public void askNumberBuildingMaterials(){
        System.out.println("Enter number of building materials locations:");
        Scanner scanner = new Scanner(System.in);
        numberBuildingMaterials = scanner.nextInt();
    }

    public int getBuildingMaterials(){
        return numberBuildingMaterials;
    }

    public void askInitialValues(){
        askSize();
        askSettlements();
        askFood();
        askNumberBuildingMaterials();
        askStartingSettlers();
    }
}
