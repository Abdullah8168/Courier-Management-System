package com.example.demo4.dao;

import com.example.demo4.model.InventoryItem;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InventoryItemDAO {
    private Connection connection;

    public InventoryItemDAO(Connection connection) {
        this.connection = connection;
    }

    public List<InventoryItem> getAllInventoryItems() throws SQLException {
        List<InventoryItem> items = new ArrayList<>();
        String sql = "SELECT * FROM inventory_items";
        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                items.add(new InventoryItem(
                        rs.getInt("item_id"),
                        rs.getString("name"),
                        rs.getInt("quantity"),
                        rs.getString("location"),
                        rs.getString("description")
                ));
            }
        }
        return items;
    }

    public void addInventoryItem(InventoryItem item) throws SQLException {
        String sql = "INSERT INTO inventory_items (name, quantity, location, description) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, item.getName());
            statement.setInt(2, item.getQuantity());
            statement.setString(3, item.getLocation());
            statement.setString(4, item.getDescription());
            statement.executeUpdate();
        }
    }

    public void updateInventoryItem(InventoryItem item) throws SQLException {
        String sql = "UPDATE inventory_items SET name = ?, quantity = ?, location = ?, description = ? WHERE item_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, item.getName());
            statement.setInt(2, item.getQuantity());
            statement.setString(3, item.getLocation());
            statement.setString(4, item.getDescription());
            statement.setInt(5, item.getItemId());
            statement.executeUpdate();
        }
    }

    public void deleteInventoryItem(int itemId) throws SQLException {
        String sql = "DELETE FROM inventory_items WHERE item_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, itemId);
            statement.executeUpdate();
        }
    }
}
