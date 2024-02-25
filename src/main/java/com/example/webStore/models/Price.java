package com.example.webStore.models;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

public class Price {
    private BigDecimal price;

    public double getPrice() {
        return price.doubleValue();
    }
    public void setPrice(BigDecimal price) {
        if(!isPriceLegal(price.toString())) { throw new IllegalArgumentException("Incorrectly entered price"); }
        this.price = price;
    }
    public void setPrice(double price) {
        Double d_price = price;
        if(!isPriceLegal(d_price.toString())) { throw new IllegalArgumentException("Incorrectly entered price"); }
        this.price = BigDecimal.valueOf(price);
    }
    public void setPrice(float price) {
        Float f_price = price;
        if(!isPriceLegal(f_price.toString())) { throw new IllegalArgumentException("Incorrectly entered price"); }
        this.price = BigDecimal.valueOf(price);
    }

    private boolean isPriceLegal(@NotNull String price)
    {
        int decimalIndex = price.indexOf('.');

        if (decimalIndex == -1) { return true; }
        else if(price.length() - decimalIndex - 1 <= 2) {
            return true;
        }
        return false;
    }
}
