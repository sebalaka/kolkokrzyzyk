package com.kodilla.kolkokrzyzyk;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class KolkoKrzyzyk extends Application {
    private boolean turnX = true;
    private boolean turnO = true;

    GridPane grid = new GridPane();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        grid.setHgap(10);
        grid.setVgap(10);
        int numRows = 3;
        int numColumns = 3;

        for (int row = 0; row < numRows; row++) {
            RowConstraints rc = new RowConstraints();
            rc.setFillHeight(true);
//            rc.setVgrow(Priority.ALWAYS);
            rc.setPercentHeight(30);
            grid.getRowConstraints().add(rc);
        }
        for (int col = 0; col < numColumns; col++) {
            ColumnConstraints cc = new ColumnConstraints();
            cc.setFillWidth(true);
//            cc.setHgrow(Priority.ALWAYS);
            cc.setPercentWidth(30.0);
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
//    private void check(){
//
//        if (button.getText().equals("X") && button.getText().equals("X") && button.getText().equals("X") ){
//            GridPane.getRowIndex(button)
//        }
//    }


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
                    if(isWon("X")){
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Koniec gry");
                        alert.setHeaderText("Wygrał gracz");
                        alert.setContentText("X");
                        alert.showAndWait();
                    };
                 }
                else if (event.getButton() == MouseButton.SECONDARY) {
                    if(!turnO) return;
                    button.setText("O");
                    turnX = true;
                    turnO = false;
                    if(isWon("O")){
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Koniec gry");
                        alert.setHeaderText("Wygrał komputer");
                        alert.setContentText("O");
                        alert.showAndWait();
                    };
                }
            }
        }


        );

        Button reset = new Button();
        grid.add(reset, 0,3);
        reset.setText("RESTART");
        reset.setOnMouseClicked(mouseEvent -> {
            grid.getChildren().stream()
                    .filter(node -> node instanceof Button)
                    .map(node -> (Button) node)
                    .filter(b -> "X".equals(b.getText()) || "O".equals(b.getText()))
                    .forEach(b -> b.setText(""));
        });

        return button;
    }

    private boolean isAnyRowWon(String symbol) {
        Map<Integer, Integer> logicMap = new HashMap<>();
        List<Button> buttons = grid.getChildren().stream()
                .filter(node -> node instanceof Button)
                .map(node -> (Button) node)
                .filter(button -> symbol.equals(button.getText()))
                .collect(Collectors.toList());



        for (Button button:buttons){
            Integer rowIndex = GridPane.getRowIndex(button);
            if (logicMap.containsKey(rowIndex)) {
                logicMap.put(rowIndex, logicMap.get(rowIndex) + 1);
            } else {
                logicMap.put(rowIndex,1);
            }

        }
        return logicMap.values().stream().anyMatch(i -> i == 3);
        //kluczem nr wiersza wartoscia ilosc wystapien
    }

    private boolean isAnyColumnWon(String symbol) {
        Map<Integer, Integer> logicMap = new HashMap<>();
        List<Button> buttons = grid.getChildren().stream()
                .filter(node -> node instanceof Button)
                .map(node -> (Button) node)
                .filter(button -> symbol.equals(button.getText()))
                .collect(Collectors.toList());

        for (Button button:buttons){
            Integer columnIndex = GridPane.getColumnIndex(button);
            if (logicMap.containsKey(columnIndex)) {
                logicMap.put(columnIndex, logicMap.get(columnIndex) + 1);
            } else {
                logicMap.put(columnIndex,1);
            }
            //nr wiersza / ilosc wystapien
        }
        return logicMap.values().stream().anyMatch(i -> i == 3);
        //kluczem nr wiersza wartoscia ilosc wystapien
    }

    private boolean isAnyCrossWon(String symbol) {
        List<Button> buttons = grid.getChildren().stream()
                .filter(node -> node instanceof Button)
                .map(node -> (Button) node)
                .filter(button -> symbol.equals(button.getText()))
                .collect(Collectors.toList());

        int counter = 0;
        for (Button button:buttons){
            Integer columnIndex = GridPane.getColumnIndex(button);
            Integer rowIndex = GridPane.getRowIndex(button);



            if ((columnIndex == 0 && rowIndex == 0) ||
                    (columnIndex == 1 && rowIndex == 1) ||
                    (columnIndex == 2 && rowIndex == 2) )  {
                counter++;
            }
            //nr wiersza / ilosc wystapien
        }
        return counter==3;
        //kluczem nr wiersza wartoscia ilosc wystapien
    }

    private boolean isAnyCrossWon2(String symbol) {
        List<Button> buttons = grid.getChildren().stream()
                .filter(node -> node instanceof Button)
                .map(node -> (Button) node)
                .filter(button -> symbol.equals(button.getText()))
                .collect(Collectors.toList());

        int counter = 0;
        for (Button button:buttons){
            Integer columnIndex = GridPane.getColumnIndex(button);
            Integer rowIndex = GridPane.getRowIndex(button);



            if ((columnIndex == 0 && rowIndex == 2) ||
                    (columnIndex == 1 && rowIndex == 1) ||
                    (columnIndex == 2 && rowIndex == 0) )  {
                counter++;
            }
            //nr wiersza / ilosc wystapien
        }
        return counter==3;
        //kluczem nr wiersza wartoscia ilosc wystapien
    }

//    public boolean isAnyCrossWon (String symbol) {


//        Map<Integer, Integer> logicMap = new HashMap<>();
//        List<Button> buttons = grid.getChildren().stream()
//                .filter(node -> node instanceof Button)
//                .map(node -> (Button) node)
//                .filter(button -> symbol.equals(button.getText()))
//                .collect(Collectors.toList());
//
//        for (Button button:buttons) {
//            Integer columnIndex = GridPane.getColumnIndex(button);
//            Integer rowIndex = GridPane.getRowIndex(button);
//
//            if(GridPane.getRowIndex(button) == GridPane.getColumnIndex(button)){
//                logicMap.put(columnIndex, logicMap.get(columnIndex) + 1);
//                logicMap.put(rowIndex, logicMap.get(rowIndex) + 1);
//            } else {
//                logicMap.put(columnIndex,1);
//                logicMap.put(rowIndex,1);
//            }
//            }
//        return true;
//        }
////////////////////////////////
//        Map<Integer, Integer> logicMap = new HashMap<>();
//        List<Button> buttons = grid.getChildren().stream()
//                .filter(node -> node instanceof Button)
//                .map(node -> (Button) node)
//                .filter(button -> symbol.equals(button.getText()))
//                .collect(Collectors.toList());
//
//        for (Button button:buttons) {
//            Integer columnIndex = GridPane.getColumnIndex(button);
//            Integer rowIndex = GridPane.getRowIndex(button);
//
//            if(columnIndex == rowIndex){
//                logicMap.put(columnIndex, logicMap.get(columnIndex) + 1);
//                logicMap.put(rowIndex, logicMap.get(rowIndex) - 1);
//            } else {
//                logicMap.put(columnIndex,1);
//                logicMap.put(rowIndex,1);
//            }
//        }
//        return true;
//    }

//    public boolean isAnyCrossWon2 (String symbol) {
//
//
//        Map<Integer, Integer> logicMap = new HashMap<>();
//        List<Button> buttons = grid.getChildren().stream()
//                .filter(node -> node instanceof Button)
//                .map(node -> (Button) node)
//                .filter(button -> symbol.equals(button.getText()))
//                .collect(Collectors.toList());
//
//        for (Button button : buttons) {
//            Button button1 = buttons.get(1);
//            button1.setText("X");
//        }
//
//        return logicMap.values().stream().anyMatch(i -> i == 3);
//    }

    private void computer(){

    }





    private boolean isWon(String symbol){
        return isAnyRowWon(symbol) || isAnyColumnWon(symbol) || isAnyCrossWon(symbol) || isAnyCrossWon2(symbol);
    }

 //alert / dialog

    //metody dla kolumn(jak wiersze) i skosu (ifami)
    //dodac komputer, sprawdza puste pola, dodaje random ruch
    // ja sprawdzam czy po moim ruchu wygralem // komputer wygral
    //moj ruch powinien uruchamiac komputera (po sprawczeniu)
    //stowrzyc logike komputera i wywolac w metodzie "createbuttonO"
}