package com.example.webStore.models;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int isAuthor;
    private PaymentInfo paymentInfo = null;
    private boolean isAuthorB;

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

    public boolean isAuthor() {
        System.out.println(isAuthor);
        if(isAuthor == 0)
            isAuthorB = false;
        else
            isAuthorB = true;
        return isAuthorB;
    }

    public void setIsAuthor(int isAuthor) {
        this.isAuthor = isAuthor;
    }
}
