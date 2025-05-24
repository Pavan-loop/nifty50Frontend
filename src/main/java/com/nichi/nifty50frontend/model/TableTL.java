package com.nichi.nifty50frontend.model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class TableTL {
    private final SimpleStringProperty stocks;
    private final SimpleStringProperty name;
    private final SimpleIntegerProperty position;
    private final SimpleIntegerProperty prePosition;
    private final SimpleIntegerProperty tradePrice;
    private final SimpleIntegerProperty cashFlow;
    private final SimpleIntegerProperty price;
    private final SimpleIntegerProperty prePrice;
    private final SimpleDoubleProperty perChange;
    private final SimpleIntegerProperty pl;
    private final SimpleIntegerProperty pricepl;
    private final SimpleIntegerProperty tradepl;

    public TableTL(String stocks, String name, Integer position, Integer prePosition, Integer tradePrice, Integer cashFlow, Integer price, Integer prePrice, Double perChange, Integer pl, Integer pricepl, Integer tradepl) {
        this.stocks = new SimpleStringProperty(stocks);
        this.name = new SimpleStringProperty(name);
        this.position = new SimpleIntegerProperty(position);
        this.prePosition = new SimpleIntegerProperty(prePosition);
        this.tradePrice = new SimpleIntegerProperty(tradePrice);
        this.cashFlow = new SimpleIntegerProperty(cashFlow);
        this.price = new SimpleIntegerProperty(price);
        this.prePrice = new SimpleIntegerProperty(prePrice);
        this.perChange = new SimpleDoubleProperty(perChange);
        this.pl = new SimpleIntegerProperty(pl);
        this.pricepl = new SimpleIntegerProperty(pricepl);
        this.tradepl = new SimpleIntegerProperty(tradepl);
    }

    public String getStocks() {
        return stocks.get();
    }

    public String getName() {
        return name.get();
    }

    public Integer getPosition() {
        return position.get();
    }

    public Integer getPrePosition() {
        return prePosition.get();
    }

    public Integer getTradePrice() {
        return tradePrice.get();
    }

    public Integer getCashFlow() {
        return cashFlow.get();
    }

    public Integer getPrice() {
        return price.get();
    }

    public Integer getPrePrice() {
        return prePrice.get();
    }

    public Double getPerChange() {
        return perChange.get();
    }

    public Integer getPl() {
        return pl.get();
    }

    public Integer getPricepl() {
        return pricepl.get();
    }

    public Integer getTradepl() {
        return tradepl.get();
    }
}
