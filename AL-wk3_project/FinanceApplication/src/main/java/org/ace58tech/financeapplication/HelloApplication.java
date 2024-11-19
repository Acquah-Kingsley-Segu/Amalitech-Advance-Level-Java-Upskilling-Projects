package org.ace58tech.financeapplication;

import io.reactivex.rxjava3.schedulers.Schedulers;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private final StockService stockService = new StockService();
    private Label priceLabel;

    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();

        stage.setTitle("Stock Price Monitor");

        priceLabel = new Label("Fetching price...");
        VBox root = new VBox(10, new Label("AAPL Stock Price:"), priceLabel);

        // Subscribe to stock price updates
        stockService.getStockPriceStream("AAPL")
                .subscribeOn(Schedulers.io())  // Fetch data on a background thread
                .observeOn(Schedulers.from(Platform::runLater))  // Update UI on JavaFX thread
                .subscribe(
                        price -> priceLabel.setText("Price: $" + price),
                        error -> priceLabel.setText("Error fetching price")
                );

        stage.setScene(new Scene(root, 300, 200));
        stage.show();
        
    }

    public static void main(String[] args) {
        launch();
    }
}