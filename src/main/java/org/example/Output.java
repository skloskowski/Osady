package org.example;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;


public class Output extends Application {
    private Timeline timeline;
    int i;
    ArrayList<ArrayList<Rectangle>> rectangleList;
    int maxDays = 10;
    int ticksDaily = 1500;

    public Output(){
        this.timeline = new Timeline(new KeyFrame(Duration.millis(300), this::doStep));
        this.timeline.setCycleCount(maxDays * ticksDaily);
        this.rectangleList = new ArrayList<>(MapCreation.size.x);
        for (int i = 0; i < MapCreation.size.x; i++) rectangleList.add(new ArrayList<>());
        i = 0;
    }

    void doStep(ActionEvent actionEvent){
        step();
    }

    public void start(){this.timeline.play();}
    public void stop(){this.timeline.stop();}

    /*
    public void step(List<Settlement> settlementList, List<Settler> settlerList, List<FoodLocation> foodLocationList, List<BuildingMaterialsLocation> buildingMaterialsLocationList){

        ArrayList<ArrayList<Rectangle>> newRectangleList = this.rectangleList;

        for (int j = 0; j < MapCreation.size.x; j++){
            for (int i = 0; i < MapCreation.size.y; i++) {

                newRectangleList.get(j).get(i).setFill(Color.WHITE);

                for (Settler settler : settlerList)
                    if (settler.position.equals(new Coordinates(i, j)))
                        newRectangleList.get(j).get(i).setFill(Color.BLACK);

                for (Settlement settlement : settlementList)
                    if (settlement.position.equals(new Coordinates(i, j)))
                        newRectangleList.get(j).get(i).setFill(Color.PINK);

                for (FoodLocation foodLocation : foodLocationList)
                    if (foodLocation.position.equals(new Coordinates(i, j)))
                        newRectangleList.get(j).get(i).setFill(Color.RED);

                for (BuildingMaterialsLocation buildingMaterials : buildingMaterialsLocationList)
                    if (buildingMaterials.position.equals(new Coordinates(i, j)))
                        newRectangleList.get(j).get(i).setFill(Color.PINK);

            }
        }

        this.rectangleList = newRectangleList;
    }

     */

    public void step(){
        int newI = i;

        if (newI % 2 == 0){
            rectangleList.get(0).get(0).setFill(Color.BLACK);
        }else {
            rectangleList.get(0).get(0).setFill(Color.WHITE);
        }

    }

    @Override
    public void start(Stage stage) throws InterruptedException {

        Group root = new Group();
        Scene scene = new Scene(root, Color.MEDIUMAQUAMARINE);

        stage.setTitle("Osady");
        stage.setWidth(800);
        stage.setHeight(800);
        stage.setResizable(false);
        Text text = new Text(50, 50, "Osady");
        text.setFont(Font.font("Helvetica", 25));

        ArrayList<ArrayList<Rectangle>> rectangleList = new ArrayList<>(MapCreation.size.x);
        for (int i = 0; i < MapCreation.size.x; i++) rectangleList.add(new ArrayList<>());

        for (int j = 0; j < MapCreation.size.x; j++){
            for (int i = 0; i < MapCreation.size.y; i++){
                Rectangle rectangle = new Rectangle();
                rectangle.setX(100 + 6 * i);
                rectangle.setY(100 + 6 * j);
                rectangle.setWidth(4);
                rectangle.setHeight(4);
                rectangle.setFill(Color.WHITE);

                rectangleList.get(i).add(rectangle);
                root.getChildren().add(rectangle);
            }
        }

        root.getChildren().add(text);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}