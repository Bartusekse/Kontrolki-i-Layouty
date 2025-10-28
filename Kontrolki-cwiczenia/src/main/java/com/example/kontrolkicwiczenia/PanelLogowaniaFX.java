package com.example.kontrolkicwiczenia;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class PanelLogowaniaFX extends Application {

    @Override
    public void start(Stage primaryStage) {
        // 1. Użycie BorderPane jako głównego kontenera
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10)); // Dodanie marginesu wokół całego interfejsu

        // --- SEKCJA TOP (GÓRA) ---
        Label topLabel = new Label("Panel Logowania");
        topLabel.setStyle("-fx-font-size: 18pt; -fx-font-weight: bold;"); // Styl dla lepszej widoczności
        BorderPane.setAlignment(topLabel, Pos.CENTER); // Wyśrodkowanie w sekcji TOP
        root.setTop(topLabel);

        // --- SEKCJA CENTER (ŚRODEK): GridPane dla formularza ---
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10); // Odstęp poziomy 10px
        gridPane.setVgap(10); // Odstęp pionowy 10px
        gridPane.setAlignment(Pos.CENTER); // Wyśrodkowanie GridPane na środku BorderPane

        // Pola formularza
        Label userLabel = new Label("Użytkownik:");
        TextField userField = new TextField();
        userField.setPromptText("Wprowadź nazwę użytkownika");

        Label passwordLabel = new Label("Hasło:");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Wprowadź hasło");

        // Dodawanie elementów do GridPane: add(węzeł, kolumna, wiersz)
        gridPane.add(userLabel, 0, 0); // (Kolumna 0, Wiersz 0)
        gridPane.add(userField, 1, 0); // (Kolumna 1, Wiersz 0)
        gridPane.add(passwordLabel, 0, 1); // (Kolumna 0, Wiersz 1)
        gridPane.add(passwordField, 1, 1); // (Kolumna 1, Wiersz 1)

        root.setCenter(gridPane);

        // --- SEKCJA BOTTOM (DÓŁ) ---
        Button loginButton = new Button("Zaloguj");
        loginButton.setPrefWidth(100); // Ustawienie stałej szerokości

        // Kontener pomocniczy HBox do wyśrodkowania przycisku w sekcji BOTTOM
        HBox bottomBox = new HBox(loginButton);
        bottomBox.setAlignment(Pos.CENTER); // Wyśrodkowanie zawartości HBox
        bottomBox.setPadding(new Insets(10, 0, 0, 0)); // Dodanie odstępu nad przyciskiem

        root.setBottom(bottomBox);


        Scene scene = new Scene(root, 400, 300);
        primaryStage.setTitle("JavaFX - Panel Logowania");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}