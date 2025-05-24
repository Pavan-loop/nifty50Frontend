package com.nichi.nifty50frontend;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class HelloController {
    @FXML
    private Button buttonTL;
    @FXML
    private Button buttonTradeEntry;

    @FXML
    private AnchorPane contentArea;

    @FXML
    public void initialize() {
        handleTradeEntry();
    }

    @FXML
    private void handleTLClick() {
        loadView("/com/nichi/nifty50frontend/TLView.fxml");
        selectedButton(buttonTL, buttonTradeEntry);
    }

    @FXML
    private void handleTradeEntry() {
        loadView("/com/nichi/nifty50frontend/TradeEntryView.fxml");
        selectedButton(buttonTradeEntry, buttonTL);
    }


    private void selectedButton(Button selected, Button unSelected) {
        selected.getStyleClass().removeAll("un-selected");
        selected.getStyleClass().add("selected");

        unSelected.getStyleClass().removeAll("selected");
        unSelected.getStyleClass().add("un-selected");
    }

    private void loadView(String fxmlPath) {
        try {
            Node node = FXMLLoader.load(getClass().getResource(fxmlPath));
            contentArea.getChildren().setAll(node);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}