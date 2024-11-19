//package org.ace58tech;
//
//import io.reactivex.rxjava3.schedulers.Schedulers;
//import javafx.application.Application;
//import javafx.application.Platform;
//import javafx.scene.Scene;
//import javafx.scene.control.Label;
//import javafx.scene.layout.VBox;
//import javafx.stage.Stage;
//
//public class StockMonitorApp extends Application {
//    private final StockService stockService = new StockService();
//    private Label label;
//
//    @Override
//    public void start(Stage stage) throws Exception {
//        stage.setTitle("Stock Price Monitor");
//
//        label = new Label("Fetching price...");
//        VBox vbox = new VBox(10, new Label("AAPL Stock Price: "), label);
//
//        stockService.getStockPrice("AAPL")
//                .subscribeOn(Schedulers.io())
//                .observeOn(Schedulers.from(Platform::runLater))
//                .subscribe(
//                        price -> label.setText("Price: $" + price),
//                        error -> label.setText("Error: " + error.getMessage())
//                );
//
//        stage.setScene(new Scene(vbox, 300, 200));
//        stage.show();
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}
