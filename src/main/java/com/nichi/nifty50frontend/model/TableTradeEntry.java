package com.nichi.nifty50frontend.model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class TableTradeEntry {
    private SimpleIntegerProperty tradeNo;
    private SimpleStringProperty code;
    private SimpleStringProperty name;
    private SimpleStringProperty tradeDate;
    private SimpleStringProperty side;
    private SimpleDoubleProperty tradePrice;
    private SimpleIntegerProperty quantity;

    private boolean modifiedTradePrice = false;
    private boolean modifiedQuantity = false;
    private boolean modifiedSide = false;
    private boolean modifiedTradeCode = false;

    public TableTradeEntry(Integer tradeNo, String code, String name, String tradeDate, String side, Double tradePrice, Integer quantity) {
        this.tradeNo = new SimpleIntegerProperty(tradeNo);
        this.code = new SimpleStringProperty(code);
        this.name = new SimpleStringProperty(name);
        this.tradeDate = new SimpleStringProperty(tradeDate);
        this.side = new SimpleStringProperty(side);
        this.tradePrice = new SimpleDoubleProperty(tradePrice);
        this.quantity = new SimpleIntegerProperty(quantity);
    }

    public Integer getTradeNo() {
        return tradeNo.get();
    }

    public SimpleIntegerProperty tradeNoProperty() {
        return tradeNo;
    }

    public String getCode() {
        return code.get();
    }

    public SimpleStringProperty codeProperty() {
        return code;
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public String getTradeDate() {
        return tradeDate.get();
    }

    public SimpleStringProperty tradeDateProperty() {
        return tradeDate;
    }

    public String getSide() {
        return side.get();
    }

    public SimpleStringProperty sideProperty() {
        return side;
    }

    public Double getTradePrice() {
        return tradePrice.get();
    }

    public SimpleDoubleProperty tradePriceProperty() {
        return tradePrice;
    }

    public Integer getQuantity() {
        return quantity.get();
    }

    public SimpleIntegerProperty quantityProperty() {
        return quantity;
    }

    public void setTradeNo(int tradeNo) {
        this.tradeNo.set(tradeNo);
    }

    public void setCode(String code) {
        this.code.set(code);
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setTradeDate(String tradeDate) {
        this.tradeDate.set(tradeDate);
    }

    public void setSide(String side) {
        this.side.set(side);
    }

    public void setTradePrice(double tradePrice) {
        this.tradePrice.set(tradePrice);
    }

    public void setQuantity(int quantity) {
        this.quantity.set(quantity);
    }

    public boolean isModifiedTradePrice() {
        return modifiedTradePrice;
    }

    public void setModifiedTradePrice(boolean modified) {
        this.modifiedTradePrice = modified;
    }

    public boolean isModifiedQuantity() {
        return modifiedQuantity;
    }

    public void setModifiedQuantity(boolean modifiedQuantity) {
        this.modifiedQuantity = modifiedQuantity;
    }

    public boolean isModifiedSide() {
        return modifiedSide;
    }

    public void setModifiedSide(boolean modifiedSide) {
        this.modifiedSide = modifiedSide;
    }

    public boolean isModifiedTradeCode() {
        return modifiedTradeCode;
    }

    public void setModifiedTradeCode(boolean modifiedTradeCode) {
        this.modifiedTradeCode = modifiedTradeCode;
    }

    @Override
    public String toString() {
        return "TableTradeEntry{" +
                "tradeNo=" + tradeNo +
                ", code=" + code +
                ", name=" + name +
                ", tradeDate=" + tradeDate +
                ", side=" + side +
                ", tradePrice=" + tradePrice +
                ", quantity=" + quantity +
                '}';
    }
}
