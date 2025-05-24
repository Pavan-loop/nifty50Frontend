package com.nichi.nifty50frontend.controller;

import com.nichi.nifty50frontend.model.TableTL;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class TLViewController {

    @FXML
    private TableView<TableTL> tableTL;
    @FXML
    private TableColumn<TableTL, String> colStocks;
    @FXML
    private TableColumn<TableTL, String> colName;
    @FXML
    private TableColumn<TableTL, Integer> colPosition;
    @FXML
    private TableColumn<TableTL, Integer> colPrePosition;
    @FXML
    private TableColumn<TableTL, Integer> colTradePrice;
    @FXML
    private TableColumn<TableTL, Integer> colCashflow;
    @FXML
    private TableColumn<TableTL, Integer> colPrice;
    @FXML
    private TableColumn<TableTL, Integer> colPrePrice;
    @FXML
    private TableColumn<TableTL, Double> colPerChange;
    @FXML
    private TableColumn<TableTL, Integer> colPL;
    @FXML
    private TableColumn<TableTL, Integer> colPricePL;
    @FXML
    private TableColumn<TableTL, Integer> colTradePL;

    @FXML
    public void initialize() {
        tableTL.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        colStocks.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getStocks()));
        colName.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getName()));
        colPosition.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getPosition()).asObject());
        colPrePosition.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getPrePosition()).asObject());
        colTradePrice.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getTradePrice()).asObject());
        colCashflow.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getCashFlow()).asObject());
        colPrice.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getPrice()).asObject());
        colPrePrice.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getPrePrice()).asObject());
        colPerChange.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getPerChange()).asObject());
        colPL.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getPl()).asObject());
        colPricePL.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getPricepl()).asObject());
        colTradePL.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getTradepl()).asObject());

        tableTL.setItems(FXCollections.observableArrayList(
                new TableTL("TATA", "TATAMOTORS", 99, 5, 4, 4, 3, 2, 8.9,34, 55, 32)
        ));
    }


}
