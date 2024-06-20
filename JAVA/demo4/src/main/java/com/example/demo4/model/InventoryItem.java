package com.example.demo4.model;

import javafx.beans.property.*;

public class InventoryItem {
    private IntegerProperty itemId = new SimpleIntegerProperty();
    private StringProperty name = new SimpleStringProperty();
    private IntegerProperty quantity = new SimpleIntegerProperty();
    private StringProperty location = new SimpleStringProperty();
    private StringProperty description = new SimpleStringProperty();

    public InventoryItem(int itemId, String name, int quantity, String location, String description) {
        this.itemId.set(itemId);
        this.name.set(name);
        this.quantity.set(quantity);
        this.location.set(location);
        this.description.set(description);
    }

    public int getItemId() {
        return itemId.get();
    }

    public IntegerProperty itemIdProperty() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId.set(itemId);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public int getQuantity() {
        return quantity.get();
    }

    public IntegerProperty quantityProperty() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity.set(quantity);
    }

    public String getLocation() {
        return location.get();
    }

    public StringProperty locationProperty() {
        return location;
    }

    public void setLocation(String location) {
        this.location.set(location);
    }

    public String getDescription() {
        return description.get();
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }
}
