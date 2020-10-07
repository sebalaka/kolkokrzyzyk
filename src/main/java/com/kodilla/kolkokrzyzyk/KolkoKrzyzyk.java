package com.kodilla.kolkokrzyzyk;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;



public class KolkoKrzyzyk extends Application {

    private Image imageback = new Image("file:src/main/resources/table.png");
    private Image xImg = new Image("file:src/main/resources/x.png");

    Label playerScoreLabel = new Label();
    Label computerScoreLabel = new Label();
//    Button test [][] = new Button[2][2];
    Button startbtn = new Button();
    Button x = new Button();
    Button x2 = new Button();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        playerScoreLabel.setText("Wynik gracza:");
        playerScoreLabel.setFont(new Font("Arial", 20));
        playerScoreLabel.setTextFill(Color.web("d5d645"));
        computerScoreLabel.setText("Wynik komputera:");
        computerScoreLabel.setFont(new Font("Arial", 20));
        computerScoreLabel.setTextFill(Color.web("d5d645"));
        startbtn.setText("Rozpocznij nowa rozgrywke");
        startbtn.setFont(new Font("Arial", 20));

        x.setText("X");
        x2.setGraphic(new ImageView(xImg));

        GridPane grid = new GridPane();
        grid.setBackground(background);

        grid.add(startbtn, 1, 1);
        grid.add(x, 2, 4);
        grid.add(x2, 3,5);
//        grid.add(test, 2, 4);

        grid.add(playerScoreLabel,1,2);
        grid.add(computerScoreLabel,1,3);

        Scene scene = new Scene(grid, 500, 500, Color.BLACK);

        primaryStage.setTitle("KolkoKrzyzyk");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
