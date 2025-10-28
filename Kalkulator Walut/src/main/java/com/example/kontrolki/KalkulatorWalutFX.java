package com.example.kontrolki;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class KalkulatorWalutFX extends Application {

    @Override
    public void start(Stage primaryStage) {
        // 1. Projekt interfejsu za pomocą GridPane
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10); // Odstęp poziomy
        grid.setVgap(10); // Odstęp pionowy
        grid.setPadding(new Insets(25, 25, 25, 25));

        // --- Kontrolki ---

        // Waluty do ComboBox
        String[] waluty = {"PLN", "USD", "EUR", "GBP"};

        // 1. Label i TextField dla Kwoty
        Label amountLabel = new Label("Kwota:");
        grid.add(amountLabel, 0, 0); // Kolumna 0, Wiersz 0

        TextField amountField = new TextField();
        amountField.setPromptText("Wprowadź kwotę");
        grid.add(amountField, 1, 0); // Kolumna 1, Wiersz 0

        // 2. Label i ComboBox dla Waluty Źródłowej
        Label fromLabel = new Label("Z waluty:");
        grid.add(fromLabel, 0, 1); // Kolumna 0, Wiersz 1

        ComboBox<String> fromCurrency = new ComboBox<>(FXCollections.observableArrayList(waluty));
        fromCurrency.getSelectionModel().selectFirst(); // Wybranie pierwszego elementu
        fromCurrency.setPrefWidth(150); // Ustawienie szerokości
        grid.add(fromCurrency, 1, 1); // Kolumna 1, Wiersz 1

        // 3. Label i ComboBox dla Waluty Docelowej
        Label toLabel = new Label("Na walutę:");
        grid.add(toLabel, 0, 2); // Kolumna 0, Wiersz 2

        ComboBox<String> toCurrency = new ComboBox<>(FXCollections.observableArrayList(waluty));
        toCurrency.getSelectionModel().select("USD"); // Wybranie innego elementu domyślnego
        toCurrency.setPrefWidth(150); // Ustawienie szerokości
        grid.add(toCurrency, 1, 2); // Kolumna 1, Wiersz 2

        // 4. Przycisk "Przelicz"
        Button convertButton = new Button("Przelicz");
        convertButton.setPrefWidth(200);
        // Przycisk zajmuje dwie kolumny (0 i 1) w wierszu 3
        grid.add(convertButton, 0, 3, 2, 1); // span: kolumna 0, wiersz 3, rozciągnij na 2 kolumny, 1 wiersz

        // 5. Label dla Wyświetlenia Wyniku
        Label resultLabel = new Label("Wynik: Oczekuję na dane...");
        resultLabel.setStyle("-fx-font-weight: bold;");
        // Wynik zajmuje dwie kolumny (0 i 1) w wierszu 4
        grid.add(resultLabel, 0, 4, 2, 1); // span: kolumna 0, wiersz 4, rozciągnij na 2 kolumny, 1 wiersz

        // --- Obsługa Zdarzenia Przycisku ---
        convertButton.setOnAction(e -> {
            try {
                // Pobranie danych
                String amountStr = amountField.getText();
                String targetCurrency = toCurrency.getSelectionModel().getSelectedItem();

                // Walidacja prostego formatu liczbowego
                double amount = Double.parseDouble(amountStr);

                // Uproszczona logika przeliczenia (wymaganie zadania)
                resultLabel.setText("Wynik: Przeliczono na 100 " + targetCurrency);

            } catch (NumberFormatException ex) {
                // Obsługa błędu, jeśli wprowadzona kwota nie jest liczbą
                resultLabel.setText("BŁĄD: Kwota musi być liczbą!");
            } catch (NullPointerException ex) {
                // Obsługa błędu, jeśli nie wybrano walut
                resultLabel.setText("BŁĄD: Wybierz waluty!");
            }
        });

        Scene scene = new Scene(grid, 350, 300);
        primaryStage.setTitle("JavaFX - Kalkulator Walut");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}