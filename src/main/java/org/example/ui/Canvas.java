package org.example.ui;

import org.example.Main;
import org.example.Settlement;
import org.example.Settler;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Canvas extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        var graphics = (Graphics2D) g;
//        drawSettlements(graphics);
    }
    private void drawSettlements(Graphics2D g, List<Settlement>settlementsList, Color color) {
        settlementsList.forEach(x -> {
            g.setColor(color);
            g.fillRect(x.position.getX(), x.position.getY(), 5, 2);
        });
    }
    private void drawSettlers(Graphics2D g, List<Settler>settlerList, Color color){

    }

}
