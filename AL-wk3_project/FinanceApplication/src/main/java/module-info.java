module org.ace58tech.financeapplication {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires io.reactivex.rxjava3;
    requires okhttp3;
    requires org.json;

    opens org.ace58tech.financeapplication to javafx.fxml;
    exports org.ace58tech.financeapplication;
}