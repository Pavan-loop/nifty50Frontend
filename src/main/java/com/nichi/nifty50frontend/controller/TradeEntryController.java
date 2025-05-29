package com.nichi.nifty50frontend.controller;


import com.nichi.nifty50frontend.DTO.ComboDataDTO;
import com.nichi.nifty50frontend.database.dao.StockListDAO;
import com.nichi.nifty50frontend.database.dao.TradeEntryDAO;
import com.nichi.nifty50frontend.database.model.StocksList;
import com.nichi.nifty50frontend.database.model.TradeList;
import com.nichi.nifty50frontend.model.TableTradeEntry;
import javafx.application.Platform;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TradeEntryController {

    @FXML
    private TableView<TableTradeEntry> tableTradeEntry;
    @FXML
    private Button saveBtn;

    @FXML
    private TableColumn<TableTradeEntry, Integer> colTradeNo;
    @FXML
    private TableColumn<TableTradeEntry, String> colCode;
    @FXML
    private TableColumn<TableTradeEntry, String> colName;
    @FXML
    private TableColumn<TableTradeEntry, String> colTradeDate;
    @FXML
    private TableColumn<TableTradeEntry, String> colSide;
    @FXML
    private TableColumn<TableTradeEntry, Integer> colTradePrice;
    @FXML
    private TableColumn<TableTradeEntry, Integer> colQuantity;

    @FXML
    private ComboBox<String> filterComboBox;



    private final ObservableList<TableTradeEntry> tradeData = FXCollections.observableArrayList();
    private final FilteredList<TableTradeEntry> filteredData = new FilteredList<>(tradeData, p -> true);

    @FXML
    public void initialize() {
        OnClickLoad();
        tableTradeEntry.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableTradeEntry.setItems(filteredData);
        tableTradeEntry.setEditable(true);

        StockListDAO stockListDAO = new StockListDAO();
        List<StocksList> stocksLists = stockListDAO.getAllStockList();
        ObservableList<String> stocksCode = FXCollections.observableArrayList();
        ObservableList<String> filteredCodeData = FXCollections.observableArrayList();
        filteredCodeData.add("All");
        TradeEntryDAO tradeEntryDAO = new TradeEntryDAO();
        List<ComboDataDTO> combo = tradeEntryDAO.getCodeData();
        for (var stocks : combo) {
            filteredCodeData.add(stocks.getCode());
            System.out.println(stocks);
        }
        for (var stocks : stocksLists) {
            stocksCode.add(stocks.getCodeId());
        }

        Map<String, String> codeToName = stocksLists.stream()
                        .collect(Collectors.toMap(StocksList::getCodeId, StocksList::getName));

        filterComboBox.setItems(filteredCodeData);
        filterComboBox.valueProperty().addListener((obs, oldVal, newVal) -> {
            filteredData.setPredicate(entry -> {
                if (newVal == null || newVal.isEmpty() || newVal.equals("All")) {
                    return true;
                }
                return entry.getCode().equals(newVal);
            });
        });

        colTradeNo.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getTradeNo()).asObject());
        colTradeNo.setCellFactory(TextFieldTableCell.forTableColumn(new javafx.util.converter.IntegerStringConverter()));
        colTradeNo.setOnEditCommit(event -> event.getRowValue().setTradeNo(event.getNewValue()));

        colCode.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCode()));
        colCode.setCellFactory(ComboBoxTableCell.forTableColumn(stocksCode));
        colCode.setOnEditCommit(event -> {
            TableTradeEntry row = event.getRowValue();
            String selectedRow = event.getNewValue();

            row.setCode(selectedRow);

            String name = codeToName.getOrDefault(selectedRow, "");
            row.setName(name);

            tableTradeEntry.refresh();
        });

        colName.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getName()));
        colName.setCellFactory(TextFieldTableCell.forTableColumn());
        colName.setOnEditCommit(event -> event.getRowValue().setName(event.getNewValue()));

        colTradeDate.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTradeDate()));
        colTradeDate.setOnEditCommit(event -> event.getRowValue().setTradeDate(event.getNewValue()));

        colSide.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getSide()));
        colSide.setCellFactory(ComboBoxTableCell.forTableColumn("B","S"));
        colSide.setOnEditCommit(event -> event.getRowValue().setSide(event.getNewValue()));

        colTradePrice.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getTradePrice()).asObject());
        colTradePrice.setCellFactory(TextFieldTableCell.forTableColumn(new javafx.util.converter.IntegerStringConverter()));
        colTradePrice.setOnEditCommit(event -> {
            try {
                int newValue = Integer.parseInt(event.getNewValue().toString());
                event.getRowValue().setTradePrice(newValue);
            }catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Show only contain numbers");
                alert.show();
            }
        });

        colQuantity.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getQuantity()).asObject());
        colQuantity.setCellFactory(TextFieldTableCell.forTableColumn(new javafx.util.converter.IntegerStringConverter()));
        colQuantity.setOnEditCommit(event -> event.getRowValue().setQuantity(event.getNewValue()));

        tableTradeEntry.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode() == KeyCode.TAB) {
                TablePosition<?, ?> pos = tableTradeEntry.getFocusModel().getFocusedCell();
                if (pos != null) {
                    int colIndex = pos.getColumn();
                    int rowIndex = pos.getRow();
                    int totalCols = tableTradeEntry.getColumns().size();

                    int nextColIndex = (colIndex + 1) % totalCols;

                    tableTradeEntry.edit(rowIndex, tableTradeEntry.getColumns().get(nextColIndex));


                    Platform.runLater(() -> {
                        tableTradeEntry.getSelectionModel().select(rowIndex);
                        tableTradeEntry.getFocusModel().focus(rowIndex, tableTradeEntry.getColumns().get(nextColIndex));
                        tableTradeEntry.edit(rowIndex, tableTradeEntry.getColumns().get(nextColIndex));
                    });
                    event.consume();
                }
            }
        });

        ContextMenu contextMenu = new ContextMenu();

        MenuItem addItem = new MenuItem("Add");
        addItem.setOnAction(e -> {
            int maxTradeNo = tradeData.stream()
                    .mapToInt(TableTradeEntry::getTradeNo)
                    .max()
                    .orElse(0);
            int nextTradeNo = maxTradeNo + 1;

            TableTradeEntry newEntry = new TableTradeEntry(nextTradeNo, "", "", "", "", 0, 0);
            tradeData.add(newEntry);
            int newIndex = tradeData.size() - 1;
            tableTradeEntry.scrollTo(newIndex);
            tableTradeEntry.getSelectionModel().select(newIndex);
            tableTradeEntry.layout();
            tableTradeEntry.edit(newIndex, colTradeNo);

        });

        MenuItem deleteItem = new MenuItem("Delete");
        deleteItem.setOnAction(e -> {
            TableTradeEntry selected = tableTradeEntry.getSelectionModel().getSelectedItem();
            if (selected != null) {
                tradeData.remove(selected);
            }
        });

        contextMenu.getItems().addAll(addItem, deleteItem);

        tableTradeEntry.setContextMenu(contextMenu);

        tableTradeEntry.setRowFactory(tv -> {
            TableRow<TableTradeEntry> row = new TableRow<>();
            row.setOnContextMenuRequested(event -> {
                if (!row.isEmpty()) {
                    tableTradeEntry.getSelectionModel().select(row.getIndex());
                }
            });
            return row;
        });

        deleteItem.setOnAction(e -> {
            TableTradeEntry selected = tableTradeEntry.getSelectionModel().getSelectedItem();
            if (selected != null) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Deleted Selected row?", ButtonType.YES, ButtonType.NO);
                alert.showAndWait().ifPresent(response -> {
                    if (response == ButtonType.YES){
                        tradeEntryDAO.deleteTrade(selected.getTradeNo(), selected.getCode());
                        tradeData.remove(selected);
                    }
                });
            }
        });

        colTradeDate.setCellFactory(column -> new TableCell<TableTradeEntry, String>() {
            private final DatePicker datePicker = new DatePicker();
            {
                datePicker.setOnAction(event -> {
                    int row = getIndex();
                    TableTradeEntry item = getTableView().getItems().get(row);
                    String newDate = "";
                    try {
                        newDate = datePicker.getValue().format(java.time.format.DateTimeFormatter.ofPattern("yyyyMMdd"));
                    }catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    item.setTradeDate(newDate);
                    commitEdit(newDate);
                });
                setGraphic(datePicker);
                setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            }
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setGraphic(null);
                }else {
                    try {
                        datePicker.setValue(java.time.LocalDate.parse(item, java.time.format.DateTimeFormatter.ofPattern("yyyyMMdd")));
                    }catch (Exception e) {
                        datePicker.setValue(null);
                    }
                    setGraphic(datePicker);
                }
            }
            @Override
            public void startEdit() {
                super.startEdit();
                datePicker.requestFocus();
            }
        });
    }

    @FXML
    public void OnClickSave() {

        for (TableTradeEntry entry : tradeData) {
            if (!isValid(entry)){
                return;
            }
        }
        List<TradeList> trade = tradeData.stream()
                .map(entry -> new TradeList(
                        entry.getTradeNo(),
                        entry.getCode(),
                        entry.getName(),
                        entry.getTradeDate(),
                        entry.getSide(),
                        entry.getTradePrice(),
                        entry.getQuantity(),
                        "tradeentrytool",
                        getDateTime()
                ))
                .toList();

        TradeEntryDAO tradeEntryDAO = new TradeEntryDAO();
        tradeEntryDAO.saveAll(trade);

        for( var v : trade) {
            System.out.println(v);
        }
        OnClickLoad();
    }

    @FXML
    public void OnClickLoad() {
        TradeEntryDAO tradeEntryDAO = new TradeEntryDAO();
        List<TradeList> tradeLists = tradeEntryDAO.getAllTradeList();

        tradeData.clear();

        for (TradeList trade : tradeLists) {
            TableTradeEntry entry = new TableTradeEntry(
                    trade.getTradeNo(),
                    trade.getCode(),
                    trade.getName(),
                    trade.getTradeDate(),
                    trade.getSide(),
                    trade.getTradePrice(),
                    trade.getQuantity()
            );
            tradeData.add(entry);
        }
        filterComboBox.setValue("All");

        List<ComboDataDTO> value = tradeEntryDAO.getCodeData();
        for (var v : value) {
            System.out.println(v);
        }
    }

    private String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        return dateFormat.format(new Date()).toLowerCase();
    }

    private boolean isValid (TableTradeEntry entry) {
        StringBuilder error = new StringBuilder();

        if (entry.getCode() == null || entry.getCode().isEmpty()) {
            error.append("Code : code is required! \n");
        }
        if (entry.getSide() == null || (!entry.getSide().equals("B") && !entry.getSide().equals("S"))) {
            error.append("Side : Side must be B or S \n");
        }
        if (entry.getTradeDate() == null || entry.getTradeDate().isEmpty()) {
            error.append("Date : Date should be selected \n");
        }
        if (entry.getTradePrice() <= 0) {
            error.append("Trade Price : Enter a valid Trade price \n");
        }
        if (entry.getQuantity() <= 0) {
            error.append("Trade Quantity : Enter a valid Quantity \n");
        }
        if (!error.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Validation Error");
            alert.setHeaderText("Invalid Trade entry: Trade no: " + entry.getTradeNo());
            alert.setContentText(error.toString());
            alert.showAndWait();
            return false;
        }
        return true;
    }
}
