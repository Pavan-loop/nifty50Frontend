package com.nichi.nifty50frontend.database.model;

import java.io.Serializable;
import java.util.Objects;

public class TradeListId implements Serializable {
    private Integer tradeNo;
    private String code;

    public TradeListId() {
    }

    public TradeListId(Integer tradeNo, String code) {
        this.tradeNo = tradeNo;
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TradeListId)) return false;

        TradeListId that = (TradeListId) o;
        return Objects.equals(tradeNo, that.tradeNo) &&
                Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tradeNo, code);
    }
}
