package com.nichi.nifty50frontend;

import com.nichi.nifty50frontend.database.utils.HibernateUtils;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Font.loadFont(getClass().getResource("/fonts/Roboto-Italic-VariableFont_wdth,wght.ttf").toExternalForm(), 10);
        Font.loadFont(getClass().getResource("/fonts/Roboto-VariableFont_wdth,wght.ttf").toExternalForm(), 10);

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 580);
        scene.getStylesheets().add(getClass().getResource("/css/stylesheet.css").toExternalForm());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        HibernateUtils.connectToDatabase();
        launch();
    }
}