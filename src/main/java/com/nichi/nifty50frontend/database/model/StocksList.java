package com.nichi.nifty50frontend.database.model;


import jakarta.persistence.*;

@Entity
@IdClass(StocksListId.class)
@Table(name = "StocksList")
public class StocksList {
    @Id
    @Column(name = "code_id")
    private String codeId;
    @Column(name = "name")
    private String name;
    @Id
    @Column(name = "maket")
    private String market;
    @Column(name = "updatesource")
    private String updateSource;
    @Column(name = "updatetime")
    private String updateTime;

    public StocksList() {
    }

    public StocksList(String codeId, String name, String market, String updateSource, String updateTime) {
        this.codeId = codeId;
        this.name = name;
        this.market = market;
        this.updateSource = updateSource;
        this.updateTime = updateTime;
    }

    public String getCodeId() {
        return codeId;
    }

    public void setCodeId(String codeId) {
        this.codeId = codeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
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
        return "StocksList{" +
                "codeName='" + codeId + '\'' +
                ", name='" + name + '\'' +
                ", market='" + market + '\'' +
                ", updateSource='" + updateSource + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}
