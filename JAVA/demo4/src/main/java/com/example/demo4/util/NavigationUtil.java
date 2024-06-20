package com.example.demo4.util;

import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class NavigationUtil {

    public static void changeScene(Node node, String fxml) throws IOException {
        if (node != null && node.getScene() != null) {
            Stage stage = (Stage) node.getScene().getWindow();
            Parent root = FXMLLoader.load(NavigationUtil.class.getResource(fxml));
            stage.setScene(new Scene(root));
            stage.show();
        } else {
            // Handle the case when the node or scene is null
            System.out.println("Error: Node or Scene is null.");
        }
    }
}
