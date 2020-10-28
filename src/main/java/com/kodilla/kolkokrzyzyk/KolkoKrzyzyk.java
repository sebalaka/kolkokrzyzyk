package com.kodilla.kolkokrzyzyk;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class KolkoKrzyzyk extends Application {
    private boolean turnX = true;
    private boolean turnO = true;
//    private Image imageback = new Image("file:src/main/resources/table.png");
//    private Image xImg = new Image("file:src/main/resources/x.png");
//
//    Label playerScoreLabel = new Label();
//    Label computerScoreLabel = new Label();
//    Button test [][] = new Button[2][2];
//    Button startbtn = new Button();
//    Button x = new Button();
//    Button x2 = new Button();


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
//        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
//        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
//        Background background = new Background(backgroundImage);


//
//        playerScoreLabel.setText("Wynik gracza:");
//        playerScoreLabel.setFont(new Font("Arial", 20));
//        playerScoreLabel.setTextFill(Color.web("d5d645"));
//        computerScoreLabel.setText("Wynik komputera:");
//        computerScoreLabel.setFont(new Font("Arial", 20));
//        computerScoreLabel.setTextFill(Color.web("d5d645"));
//        startbtn.setText("Rozpocznij nowa rozgrywke");
//        startbtn.setFont(new Font("Arial", 20));

//        x.setText("X");
//        x2.setBackground(xImg);
//        x2.setMaxSize(20,20);
//        x.setPrefSize(40,40);

//        GridPane grid = new GridPane();

//        for (int i = 0; i < 10; i++) {
//            RowConstraints row = new RowConstraints(50);
//            grid.getRowConstraints().add(row);
//        }
//
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                Button test = new Button();
//                test.setTranslateX(j * 200);
//                test.setTranslateY(i * 200);
//
//                grid.getChildren().add(test);
//            }
//        }
//        for(int i=0; i<3; i++){
//            for(int j=0; j<3; j++){
//                gridpane.add
//            }
        //zagniezdzenie obiektow
//        grid.setBackground(background);

//        grid.add(startbtn, 1, 1);
////        grid.add(x, 2, 4);
////        grid.add(x2, 3,5);
////        grid.add(test, 2, 4);
////        grid.add(sc)
//
//        grid.add(playerScoreLabel,1,2);
//        grid.add(computerScoreLabel,1,3);
//
//        Scene scene = new Scene(grid, 500, 500, Color.BLACK);
//
//        primaryStage.setTitle("KolkoKrzyzyk");
//        primaryStage.setScene(scene);
//        primaryStage.show();


        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        int numRows = 3;
        int numColumns = 3;

        for (int row = 0; row < numRows; row++) {
            RowConstraints rc = new RowConstraints();
            rc.setFillHeight(true);
//            rc.setVgrow(Priority.ALWAYS);
            rc.setPercentHeight(33);
            grid.getRowConstraints().add(rc);
        }
        for (int col = 0; col < numColumns; col++) {
            ColumnConstraints cc = new ColumnConstraints();
            cc.setFillWidth(true);
//            cc.setHgrow(Priority.ALWAYS);
            cc.setPercentWidth(33.0);
            grid.getColumnConstraints().add(cc);
        }

        for (int i = 0; i < 9; i++) {
            Button button = createButton();
            grid.add(button, i % 3, i / 3);
        }

        Scene scene = new Scene(grid, 500, 500, Color.BLACK);
        primaryStage.fullScreenProperty();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Button createButton() {
        Button button = new Button();
        button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        button.setFont(Font.font("Roboto",70.0));
        button.setStyle("-fx-padding: 30");
        button.setOnMouseClicked(event -> {
            if (button.getText() == null || button.getText().equals("")) {
                if (event.getButton() == MouseButton.PRIMARY) {
                    if(!turnX) return;
                    button.setText("X");
                    turnX = false;
                    turnO = true;
                 }
                else if (event.getButton() == MouseButton.SECONDARY) {
                    if(!turnO) return;
                    button.setText("O");
                    turnX = true;
                    turnO = false;
                }
            }
        });
        return button;
    }
//padding
    //logike
}


// plansza buttonow rowconstraint columncst

//petla

//logika