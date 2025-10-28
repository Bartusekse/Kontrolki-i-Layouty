module com.example.kontrolkicwiczenia {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.kontrolkicwiczenia to javafx.fxml;
    exports com.example.kontrolkicwiczenia;
}