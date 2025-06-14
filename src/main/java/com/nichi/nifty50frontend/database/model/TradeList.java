package com.nichi.nifty50frontend.database.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@IdClass(TradeListId.class)
@Table(name = "TradesList")
public class TradeList {

    @Id
    @Column(name = "tradeno")
    private Integer tradeNo;
    @Id
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;
    @Column(name = "tradedate")
    private String tradeDate;
    @Column(name = "side")
    private String side;
    @Column(name = "tradeprice")
    private Double tradePrice;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "updatesource")
    private String updateSource;
    @Column(name = "updatetime")
    private String updateTime;

    public TradeList() {
    }

    public TradeList(Integer tradeNo, String code, String name, String tradeDate, String side, Double tradePrice, Integer quantity, String updateSource, String updateTime) {
        this.tradeNo = tradeNo;
        this.code = code;
        this.name = name;
        this.tradeDate = tradeDate;
        this.side = side;
        this.tradePrice = tradePrice;
        this.quantity = quantity;
        this.updateSource = updateSource;
        this.updateTime = updateTime;
    }

    public Integer getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(Integer tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(String tradeDate) {
        this.tradeDate = tradeDate;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public Double getTradePrice() {
        return tradePrice;
    }

    public void setTradePrice(Double tradePrice) {
        this.tradePrice = tradePrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getUpdateSource() {
        return updateSource;
    }

    public void setUpdateSource(String updateSource) {
        this.updateSource = updateSource;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "TradeList{" +
                "tradeNo='" + tradeNo + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", tradeDate='" + tradeDate + '\'' +
                ", side='" + side + '\'' +
                ", tradePrice=" + tradePrice +
                ", quantity=" + quantity +
                ", updateSource='" + updateSource + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}
