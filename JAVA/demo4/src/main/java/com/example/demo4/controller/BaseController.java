package com.example.demo4.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class BaseController {

    protected void navigateTo(ActionEvent event, String fxmlFile) throws Exception {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void handleLogout(ActionEvent event) throws Exception {
        navigateTo(event, "/com/example/demo4/main.fxml");
    }

    @FXML
    public void handleBack(ActionEvent event, String backScreenFxml) throws Exception {
        navigateTo(event, backScreenFxml);
    }
}
