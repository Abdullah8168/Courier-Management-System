package com.example.demo4.controller;

import com.example.demo4.model.InventoryItem;
import com.example.demo4.service.InventoryService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import com.example.demo4.util.NavigationUtil;

import java.sql.SQLException;

public class InventoryManagementController {

    @FXML
    private TableView<InventoryItem> inventoryTable;
    @FXML
    private TextField nameField, quantityField, locationField, descriptionField;
    @FXML
    private Button back;

    private InventoryService inventoryService;

    public InventoryManagementController() {
        this.inventoryService = new InventoryService();
    }

    @FXML
    private void initialize() {
        loadInventoryItems();
    }

    private void loadInventoryItems() {
        try {
            ObservableList<InventoryItem> items = FXCollections.observableArrayList(inventoryService.getAllInventoryItems());
            inventoryTable.setItems(items);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void handleAddItem() {
        try {
            InventoryItem newItem = new InventoryItem(0, nameField.getText(),
                    Integer.parseInt(quantityField.getText()), locationField.getText(),
                    descriptionField.getText());
            inventoryService.addInventoryItem(newItem);
            loadInventoryItems();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void handleUpdateItem() {
        InventoryItem selectedItem = inventoryTable.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            selectedItem.setName(nameField.getText());
            selectedItem.setQuantity(Integer.parseInt(quantityField.getText()));
            selectedItem.setLocation(locationField.getText());
            selectedItem.setDescription(descriptionField.getText());
            try {
                inventoryService.updateInventoryItem(selectedItem);
                loadInventoryItems();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @FXML
    private void Goback() throws Exception {
        NavigationUtil.changeScene(back, "/com/example/demo4/admin_dashboard.fxml");
    }

    @FXML
    private void handleDeleteItem() {
        InventoryItem selectedItem = inventoryTable.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            try {
                inventoryService.deleteInventoryItem(selectedItem.getItemId());
                loadInventoryItems();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
