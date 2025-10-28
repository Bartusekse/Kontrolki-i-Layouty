module com.example.kontrolki {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.kontrolki to javafx.fxml;
    exports com.example.kontrolki;
}