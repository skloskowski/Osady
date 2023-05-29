package org.example.ui;

import org.example.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;


public class Canvas extends JPanel {

    List<Settlement>settlementsList;
    Color color;
    List<Settler>settlerList;
    List<BuildingMaterialsLocation>buildingMaterialsLocation;
    Color colorBuilding;
    List<FoodLocation>foodLocationList;
    Color color2;
    Color colorFood;
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        var graphics = (Graphics2D) g;
        drawSettlements(graphics, settlementsList);
        drawSettlers(graphics,settlerList);
        drawFood(graphics,foodLocationList);
        drawBuildingMaterials(graphics,buildingMaterialsLocation);
    }
    private void drawSettlements(Graphics2D g, List<Settlement>settlementsList) {
        settlementsList.forEach(x -> {
            g.setColor(x.getColor());
            g.fillRect(x.position.getX(), x.position.getY(), 8, 8);
        });
    }
    private void drawSettlers(Graphics2D g, List<Settler>settlerList){
        settlerList.forEach(x -> {
            g.setColor(x.getColor());
            g.fillRect(x.getPosition().getX(), x.getPosition().getY(), 4, 4);
        });
    }
    private void drawBuildingMaterials(Graphics2D g, List<BuildingMaterialsLocation>buildingMaterialsLocation){
       buildingMaterialsLocation.forEach(x -> {
           g.setColor(colorBuilding);
           g.fillOval(x.getPosition().getX(), x.getPosition().getY(), 3,3);
       });
    }
    private void drawFood(Graphics2D g, List<FoodLocation>foodLocationList){
        foodLocationList.forEach(x -> {
            g.setColor(colorFood);
            g.fillOval(x.getPosition().getX(), x.getPosition().getY(), 3,3);
        });
    }



    public void setValues(List<Settlement> settlementsList, List<Settler> settlerList, List<BuildingMaterialsLocation> buildingMaterialsLocation, List<FoodLocation> foodLocationList) {
        this.settlementsList = settlementsList;
        this.settlerList = settlerList;
        this.buildingMaterialsLocation = buildingMaterialsLocation;
        this.foodLocationList = foodLocationList;
    }
}
