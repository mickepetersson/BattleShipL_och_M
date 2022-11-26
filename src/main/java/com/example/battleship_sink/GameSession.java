package com.example.battleship_sink;

/*
*
* Author: Lada Egolaeva
*
* Comment:
* This was the class we based much on the game on, especially when we were working more with the front-end
* focused game. Thus, it played an important role for much of the project, and has served as inspiration
* for several other methods in use throughout the project code.
*
*/

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameSession {

    private GameView gameView;
    private List<Node> shotCoordinates = new ArrayList<>();

    public GameSession(GameView gameView) {
        this.gameView = gameView;
    }

    public GameSession() {

    }

    public void startGame(Stage stage) {
        shootRandomShotAtEnemy();
        checkShotCoordinates();
    }

    //generates random coordinates and returns a node
    public Node getRandomNode (GridPane gridPane, int randRow, int randCol) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == randCol && GridPane.getRowIndex(node) == randRow) {
                return node;
            }
        }
        return null;
    }

    //testing method to shoot a random shot at an enemy board, as well as print the hit coordinates.
    //basis for shot-method in Turn class
    public void shootRandomShotAtEnemy() {
        List<String> rows = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J");
        List<Integer> columns = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        int randRow = (int)Math.floor(Math.random() * 10);
        int randCol = (int)Math.floor(Math.random() * 10);
        Node node = getRandomNode(gameView.enemyBoard, randRow, randCol);
        node.setStyle("-fx-background-color: black");
        int columnIndex = GridPane.getColumnIndex(node);
        int rowIndex = GridPane.getRowIndex(node);
        System.out.println("Player 1 shot their shot at " + rows.get(rowIndex) + columns.get(columnIndex));
    }

    //method to check which coordinates have already been shot, and are thus eliminated.
    //inspiration for several parts in ShipPlacer class, and eventually Checker class.
    public void checkShotCoordinates() {
        List<String> rows = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J");
        List<Integer> columns = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println("Shot coordinates: ");
        for (Node node : shotCoordinates) {
            int columnIndex = GridPane.getColumnIndex(node);
            int rowIndex = GridPane.getRowIndex(node);
            System.out.println(rows.get(rowIndex) + columns.get(columnIndex));
        }
    }
}
