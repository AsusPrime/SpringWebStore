package com.example.webStore.models;

import org.springframework.data.annotation.Id;

public class Account {
    @Id
    private long id;
    private String name;
    private PaymentInfo paymentInfo = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PaymentInfo getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(PaymentInfo paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean hasAccountPaymentInfo()
    {
        return (paymentInfo != null);
    }
}
