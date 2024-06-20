module com.example.demo4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java; // Add this line


    opens com.example.demo4.controller to javafx.fxml;
    // Add opens statements for other packages if needed
    opens com.example.demo4.model to javafx.fxml, javafx.base; // if your FXML binds directly to model properties
    opens com.example.demo4.dao to javafx.base;
    exports com.example.demo4;
}
