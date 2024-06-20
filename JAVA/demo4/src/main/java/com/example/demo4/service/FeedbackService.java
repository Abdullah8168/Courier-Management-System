package com.example.demo4.service;

import com.example.demo4.DatabaseConnection;
import com.example.demo4.dao.FeedbackDAO;
import com.example.demo4.model.Feedback;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class FeedbackService {

    private FeedbackDAO feedbackDAO;

    public FeedbackService() {
        this.feedbackDAO = new FeedbackDAO(DatabaseConnection.getConnection());
    }

    public void submitFeedback(int userId, int rating, String comments) throws SQLException {
        if (!isValidFeedback(rating, comments)) {
            throw new IllegalArgumentException("Invalid feedback data");
        }
        Feedback feedback = new Feedback(0, userId, rating, comments, new Date());
        feedbackDAO.addFeedback(feedback);
    }

    public List<Feedback> getFeedbackByUser(int userId) throws SQLException {
        return feedbackDAO.getFeedbackByUserId(userId);
    }

    public boolean isValidFeedback(int rating, String comments) {
        return (rating >= 1 && rating <= 5) && (comments != null && !comments.trim().isEmpty());
    }

    // Example method to calculate average rating
    public double calculateAverageRating(List<Feedback> feedbacks) {
        if (feedbacks.isEmpty()) {
            return 0.0;
        }
        return feedbacks.stream().mapToInt(Feedback::getRating).average().orElse(0.0);
    }
}
