package com.example.demo4.dao;

import com.example.demo4.model.Feedback;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FeedbackDAO {
    public Connection connection;

    public FeedbackDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Feedback> getFeedbackByUserId(int userId) {
        List<Feedback> feedbackList = new ArrayList<>();
        String sql = "SELECT * FROM feedback WHERE user_id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Feedback feedback = new Feedback(
                        rs.getInt("feedback_id"),
                        rs.getInt("user_id"),
                        rs.getInt("rating"),
                        rs.getString("comments"),
                        rs.getTimestamp("created_at")
                );
                feedbackList.add(feedback);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return feedbackList;
    }

    // Method to add new feedback
    public void addFeedback(Feedback feedback) {
        String sql = "INSERT INTO feedback (user_id, rating, comments) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, feedback.getUserId());
            statement.setInt(2, feedback.getRating());
            statement.setString(3, feedback.getComments());
            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating feedback failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    feedback.setFeedbackId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating feedback failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
