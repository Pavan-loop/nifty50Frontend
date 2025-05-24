module com.nichi.nifty50frontend {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.nichi.nifty50frontend to javafx.fxml;
    opens com.nichi.nifty50frontend.controller to javafx.fxml;
    opens com.nichi.nifty50frontend.model to javafx.fxml;

    exports com.nichi.nifty50frontend;
    exports com.nichi.nifty50frontend.controller;
    exports com.nichi.nifty50frontend.model;
}