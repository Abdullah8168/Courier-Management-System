package com.example.demo4.dao;

import com.example.demo4.DatabaseConnection;
import com.example.demo4.model.Parcel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ParcelDAO {
    private Connection connection;

    public ParcelDAO(Connection connection) {
        this.connection = connection;
    }

    // Retrieve parcels based on sender or receiver ID
    public List<Parcel> getParcelsByUserId(int userId) {
        List<Parcel> parcels = new ArrayList<>();
        String sql = "SELECT * FROM parcels WHERE sender_id = ? OR receiver_id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            statement.setInt(2, userId);
            ResultSet rs = statement.executeQuery();

            // Check if result set is empty
            if (!rs.isBeforeFirst()) {
                System.out.println("No data found");
            } else {
                while (rs.next()) {
                    Parcel parcel = new Parcel(
                            rs.getInt("parcel_id"),
                            rs.getString("status"),
                            rs.getString("destination"),
                            rs.getInt("sender_id"),
                            rs.getInt("receiver_id"),
                            rs.getDate("dispatch_date"),
                            rs.getDate("arrival_date")
                    );
                    parcels.add(parcel);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return parcels;
    }

    public List<Parcel> searchParcels(String criteria) {
        List<Parcel> parcels = new ArrayList<>();
        String sql = "SELECT * FROM parcels WHERE destination LIKE ? OR status LIKE ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, "%" + criteria + "%");
            statement.setString(2, "%" + criteria + "%");
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                parcels.add(new Parcel(
                        rs.getInt("parcel_id"),
                        rs.getString("status"),
                        rs.getString("destination"),
                        rs.getInt("sender_id"),
                        rs.getInt("receiver_id"),
                        rs.getDate("dispatch_date"),
                        rs.getDate("arrival_date")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return parcels;
    }

    public void updateParcelStatus(int parcelId, String newStatus) {
        String sql = "UPDATE parcels SET status = ? WHERE parcel_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, newStatus);
            statement.setInt(2, parcelId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
