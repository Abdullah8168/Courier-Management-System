package com.example.demo4;

import com.example.demo4.util.NavigationUtil;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the initial FXML file (main screen)
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/demo4/main.fxml"));
        primaryStage.setTitle("Courier Management System");
        primaryStage.setScene(new Scene(root, 420, 700)); // Set the size of the window
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args); // Launch the JavaFX application
    }
}
