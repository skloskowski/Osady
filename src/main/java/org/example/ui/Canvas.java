package org.example.ui;

import org.example.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;


public class Canvas extends JPanel {

    List<Settlement>settlementsList;
    List<Settler>settlerList;
    List<BuildingMaterialsLocation>buildingMaterialsLocation;
    List<FoodLocation>foodLocationList;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        var graphics = (Graphics2D) g;
        if (settlementsList == null || settlerList == null || buildingMaterialsLocation == null || foodLocationList == null) return;
        drawSettlements(graphics, settlementsList);
        drawSettlers(graphics,settlerList);
        drawFood(graphics,foodLocationList);
        drawBuildingMaterials(graphics,buildingMaterialsLocation);
    }
    private void drawSettlements(Graphics2D g, List<Settlement>settlementsList) {
        settlementsList.forEach(x -> {
            g.setColor(x.getColor());
            g.fillRect(x.position.getX(), x.position.getY(), 16, 16);
        });
    }
    private void drawSettlers(Graphics2D g, List<Settler>settlerList){
        settlerList.forEach(x -> {
            g.setColor(x.getColor());
            g.fillRect(x.getPosition().getX(), x.getPosition().getY(), 8, 8);
        });
    }
    private void drawBuildingMaterials(Graphics2D g, List<BuildingMaterialsLocation>buildingMaterialsLocation){
       buildingMaterialsLocation.forEach(x -> {
           g.setColor(x.getColor());
           g.fillOval(x.getPosition().getX(), x.getPosition().getY(), 6,6);
       });
    }
    private void drawFood(Graphics2D g, List<FoodLocation>foodLocationList){
        foodLocationList.forEach(x -> {
            g.setColor(x.getColor());
            g.fillOval(x.getPosition().getX(), x.getPosition().getY(), 6,6);
        });
    }

    public void setValues(List<Settlement> settlementsList, List<Settler> settlerList, List<BuildingMaterialsLocation> buildingMaterialsLocation, List<FoodLocation> foodLocationList) {
        this.settlementsList = settlementsList;
        this.settlerList = settlerList;
        this.buildingMaterialsLocation = buildingMaterialsLocation;
        this.foodLocationList = foodLocationList;
        repaint();
    }
}
