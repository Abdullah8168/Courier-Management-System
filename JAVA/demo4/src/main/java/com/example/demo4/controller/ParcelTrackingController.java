package com.example.demo4.controller;

import com.example.demo4.DatabaseConnection;
import com.example.demo4.model.Parcel;
import com.example.demo4.service.ParcelService;
import com.example.demo4.util.NavigationUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Date;

public class ParcelTrackingController {

    public Button back;
    @FXML private TableView<Parcel> parcelTable;
    @FXML private TableColumn<Parcel, Integer> parcelIdColumn;
    @FXML private TableColumn<Parcel, String> statusColumn;
    @FXML private TableColumn<Parcel, String> destinationColumn;
    @FXML private TableColumn<Parcel, Date> dispatchDateColumn;
    @FXML private TableColumn<Parcel, Date> arrivalDateColumn;
    @FXML private TextField searchField;
    private ParcelService parcelService;

    public ParcelTrackingController() {
        parcelService = new ParcelService(DatabaseConnection.getConnection());
    }

    @FXML
    private void initialize() {
        // Setup cell value factories
        parcelIdColumn.setCellValueFactory(new PropertyValueFactory<>("parcelId"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        destinationColumn.setCellValueFactory(new PropertyValueFactory<>("destination"));
        dispatchDateColumn.setCellValueFactory(new PropertyValueFactory<>("dispatchDate"));
        arrivalDateColumn.setCellValueFactory(new PropertyValueFactory<>("arrivalDate"));

        // Load initial data and setup search
        loadParcels();
        searchField.textProperty().addListener((obs, oldVal, newVal) -> searchParcels(newVal));
    }

    private void loadParcels() {
        ObservableList<Parcel> parcels = FXCollections.observableArrayList(parcelService.getParcelsByUserId(1));  // Adjust ID as needed
        parcelTable.setItems(parcels);
        if (parcels.isEmpty()) {
            System.out.println("No parcels loaded.");
        } else {
            System.out.println("Parcels loaded successfully.");
        }
    }

    private void searchParcels(String criteria) {
        ObservableList<Parcel> parcels = FXCollections.observableArrayList(parcelService.searchParcels(criteria));
        parcelTable.setItems(parcels);
    }

    @FXML
    private void handleUpdateStatus() {
        Parcel selected = parcelTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            parcelService.updateParcelStatus(selected.getParcelId(), "Delivered");  // Example status update
            searchParcels(searchField.getText());  // Refresh list
        }
    }

    @FXML
    private void Goback() throws Exception {
        NavigationUtil.changeScene(back, "/com/example/demo4/customer_dashboard.fxml");
    }
}
