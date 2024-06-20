package com.example.demo4.controller;

import com.example.demo4.model.Feedback;
import com.example.demo4.service.FeedbackService;
import com.example.demo4.util.NavigationUtil;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;

import java.util.List;

public class FeedbackController {
    @FXML
    private TextArea commentsTextArea;
    @FXML
    private ComboBox<Integer> ratingComboBox;
    @FXML
    private Button back; // Ensure this button's fx:id is correctly linked to the FXML
    @FXML
    private Label averageRatingLabel;

    private FeedbackService feedbackService;

    public FeedbackController() {
        this.feedbackService = new FeedbackService();
    }

    @FXML
    public void initialize() {
        ratingComboBox.setItems(FXCollections.observableArrayList(1, 2, 3, 4, 5));  // Initialize the ComboBox items
        updateAverageRating();
    }

    @FXML
    private void handleSubmitFeedback() {
        try {
            int rating = ratingComboBox.getValue();
            String comments = commentsTextArea.getText();
            feedbackService.submitFeedback(1, rating, comments);  // Assume userId is 1 for now
            commentsTextArea.clear();
            ratingComboBox.getSelectionModel().clearSelection();
            updateAverageRating();
        } catch (Exception e) {
            e.printStackTrace();  // Log or handle error properly
        }
    }

    @FXML
    private void Goback(ActionEvent event) throws Exception {
        // Use NavigationUtil to navigate back
        NavigationUtil.changeScene(back, "/com/example/demo4/customer_dashboard.fxml");
    }

    private void updateAverageRating() {
        try {
            List<Feedback> feedbacks = feedbackService.getFeedbackByUser(1);  // Assume userId is 1 for now
            double averageRating = feedbackService.calculateAverageRating(feedbacks);
            averageRatingLabel.setText("Average Rating: " + String.format("%.2f", averageRating));
        } catch (Exception e) {
            averageRatingLabel.setText("Error calculating average rating.");
        }
    }
}
