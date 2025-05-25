package com.nichi.nifty50frontend.database.model;

import java.io.Serializable;
import java.util.Objects;

public class StocksListId implements Serializable {
    private String codeId;
    private String market;

    public StocksListId() {}

    public StocksListId(String codeName, String market) {
        this.codeId = codeName;
        this.market = market;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StocksListId)) return false;
        StocksListId that = (StocksListId) o;
        return Objects.equals(codeId, that.codeId) &&
                Objects.equals(market, that.market);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeId, market);
    }
}
