package org.example;

import java.util.Scanner;

public class Input {
    private int numberSettlements;
    private int numberFood;
    private int numberBuildingMaterials;
    private int numberStartingSettlers;

    /***
     * ask user for map size and set map size
     */
    public void askSize(){
        System.out.println("Enter map size:");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        MapCreation.size.setX(size);
        MapCreation.size.setY(size);
    }

    /***
     * ask user for number of settlements at the start and set number of settlements
     */
    public void askSettlements(){
        System.out.println("Enter number of settlements:");
        Scanner scanner = new Scanner(System.in);
        numberSettlements = scanner.nextInt();
    }

    /***
     *
     * @return number of settlements at the start
     */
    public int getSettlements(){
        return numberSettlements;
    }

    /***
     * ask user for number of settlers of each settlement at the start and set number of settlers
     */
    public void askStartingSettlers(){
        System.out.println("Enter number of starting settlers of each settlement:");
        Scanner scanner = new Scanner(System.in);
        numberStartingSettlers = scanner.nextInt();
    }

    /***
     *
     * @return number of settlers of each settlement at the start
     */
    public int getStartingSettlers(){
        return numberStartingSettlers;
    }

    /***
     * ask user for number of FoodLocations and set number of FoodLocations
     */
    public void askFood(){
        System.out.println("Enter number of food locations:");
        Scanner scanner = new Scanner(System.in);
        numberFood = scanner.nextInt();
    }

    /***
     *
     * @return number of FoodLocations
     */
    public int getFood(){
        return numberFood;
    }

    /***
     * ask user for number of BuildingMaterialsLocation and set number of BuildingMaterialsLocation
     */
    public void askNumberBuildingMaterials(){
        System.out.println("Enter number of building materials locations:");
        Scanner scanner = new Scanner(System.in);
        numberBuildingMaterials = scanner.nextInt();
    }

    /***
     *
     * @return number of BuildingMaterialsLocation
     */
    public int getBuildingMaterials(){
        return numberBuildingMaterials;
    }

    /***
     * ask user and set all initial values i.e. size, numberSettlements, numberFoodLocations, numberBuildingMaterials, numberStartingSettlers
     */
    public void askInitialValues(){
        askSize();
        askSettlements();
        askFood();
        askNumberBuildingMaterials();
        askStartingSettlers();
    }
}
