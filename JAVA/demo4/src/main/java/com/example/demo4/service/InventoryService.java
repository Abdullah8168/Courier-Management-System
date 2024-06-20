package com.example.demo4.service;

import com.example.demo4.DatabaseConnection;
import com.example.demo4.dao.InventoryItemDAO;
import com.example.demo4.model.InventoryItem;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class InventoryService {

    private InventoryItemDAO inventoryItemDAO;

    public InventoryService() {
        this.inventoryItemDAO = new InventoryItemDAO(DatabaseConnection.getConnection());
    }

    public void addInventoryItem(InventoryItem item) throws SQLException {
        if (validateInventoryItem(item)) {
            inventoryItemDAO.addInventoryItem(item);
        } else {
            throw new IllegalArgumentException("Invalid inventory item data");
        }
    }

    public void updateInventoryItem(InventoryItem item) throws SQLException {
        if (validateInventoryItem(item)) {
            inventoryItemDAO.updateInventoryItem(item);
        } else {
            throw new IllegalArgumentException("Invalid inventory item data");
        }
    }

    public void deleteInventoryItem(int itemId) throws SQLException {
        inventoryItemDAO.deleteInventoryItem(itemId);
    }

    public List<InventoryItem> getAllInventoryItems() throws SQLException {
        return inventoryItemDAO.getAllInventoryItems();
    }

    public List<InventoryItem> searchInventoryItems(String query) throws SQLException {
        return inventoryItemDAO.getAllInventoryItems().stream()
                .filter(item -> item.getName().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
    }

    private boolean validateInventoryItem(InventoryItem item) {
        return item.getName() != null && !item.getName().trim().isEmpty() &&
                item.getQuantity() >= 0 &&
                item.getLocation() != null && !item.getLocation().trim().isEmpty();
    }
}
