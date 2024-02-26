package com.example.webStore.models;

import java.math.BigDecimal;

public class Promotion {
    private int percent = 0;

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        if(!isPromotionLegal(percent)) { throw new IllegalArgumentException("Incorrectly entered promotion"); }
        this.percent = percent;
    }

    public double calcPriceWithPromotion(double price)
    {
        double new_price = price - price * ((double) percent / 100);
        return Math.round(new_price * 100.0) / 100.0;
    }

    private boolean isPromotionLegal(int promotion)
    {
        if(promotion < 0) { return false; }
        else if(promotion > 100) { return false; }
        return true;
    }
}
