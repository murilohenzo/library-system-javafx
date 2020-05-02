package com.murilo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {

    private Stage window;
    private Scene sceneBooks;
    private Scene sceneAuthors;
    private Scene scenePublishers;
    private Scene scenePrimary;

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        createScenePrimary();
        createSceneBooks();
        createScenePublishers();
        createSceneAuthors();

        window.setScene(scenePrimary);
        window.setResizable(false);
        window.setTitle("Library System");
        window.show();

    }

    public void createScenePrimary() throws IOException {

        Button buttonAuthors = new Button("Go to Authors");
        Button buttonPublishers = new Button("Go to Publishers");
        Button buttonBooks = new Button("Go to Books");
        Button buttonExit = new Button("Exit");

        Label labelWelcome = new Label("Welcome Library System");
        labelWelcome.getStyleClass().add("welcome");

        VBox boxPrimary = new VBox();
        buttonAuthors.setOnAction(actionEvent -> {
            window.setScene(sceneAuthors);
            window.setResizable(false);
            window.setTitle("Authors");
        });

        buttonBooks.setOnAction(actionEvent -> {
            window.setScene(sceneBooks);
            window.setResizable(false);
            window.setTitle("Books");
        });

        buttonPublishers.setOnAction(actionEvent -> {
            window.setScene(scenePublishers);
            window.setResizable(false);
            window.setTitle("Publishers");
        });

        buttonExit.setOnAction(actionEvent -> {System.exit(0);});

        boxPrimary.setSpacing(10);
        boxPrimary.setAlignment(Pos.CENTER);
        boxPrimary.getChildren().addAll(labelWelcome, buttonAuthors, buttonPublishers, buttonBooks, buttonExit);

        scenePrimary = new Scene(boxPrimary, 400, 400);
        boxPrimary.getStylesheets().add(getClass().getResource("Pane.css").toExternalForm());
    }

    public void createSceneAuthors() throws IOException {
        Button buttonBack = new Button("Back");
        buttonBack.setOnAction(actionEvent -> {
            window.setScene(scenePrimary);
            window.setResizable(false);
            window.setTitle("Library System");
        });

        GridPane paneAuthors = FXMLLoader.load(getClass().getResource("Authors.fxml"));
        GridPane.setColumnIndex(buttonBack, 0);
        GridPane.setRowIndex(buttonBack, 7);

        paneAuthors.getChildren().addAll(buttonBack);
        sceneAuthors = new Scene(paneAuthors);
        sceneAuthors.getStylesheets().add(getClass().getResource("Pane.css").toExternalForm());
    }

    public void createScenePublishers() throws IOException {
        Button buttonBack = new Button("Back");
        buttonBack.setOnAction(actionEvent -> {
            window.setScene(scenePrimary);
            window.setResizable(false);
            window.setTitle("Library System");
        });

        GridPane panePublishers = FXMLLoader.load(getClass().getResource("Publishers.fxml"));
        GridPane.setColumnIndex(buttonBack, 0);
        GridPane.setRowIndex(buttonBack, 7);

        panePublishers.getChildren().add(buttonBack);
        scenePublishers = new Scene(panePublishers);
        scenePublishers.getStylesheets().add(getClass().getResource("Pane.css").toExternalForm());
    }

    public void createSceneBooks() throws IOException {
        Button buttonBack = new Button("Back");
        buttonBack.setOnAction(actionEvent -> {
            window.setScene(scenePrimary);
            window.setResizable(false);
            window.setTitle("Library System");
        });

        GridPane paneBooks = FXMLLoader.load(getClass().getResource("Books.fxml"));
        GridPane.setColumnIndex(buttonBack, 1);
        GridPane.setRowIndex(buttonBack, 13);

        paneBooks.getChildren().add(buttonBack);
        sceneBooks = new Scene(paneBooks);
        sceneBooks.getStylesheets().add(getClass().getResource("Pane.css").toExternalForm());
    }

    public static void main(String[] args) {launch(args); }
}
