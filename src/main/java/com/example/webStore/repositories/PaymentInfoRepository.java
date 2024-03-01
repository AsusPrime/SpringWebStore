package com.example.webStore.repositories;

import com.example.webStore.models.PaymentInfo;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;

public interface PaymentInfoRepository extends CrudRepository<PaymentInfo, Long> {

    @Query("SELECT * FROM payment_info WHERE id = id")
    public PaymentInfo getPaymentInfoById(long id);

    @Query("INSERT INTO payment_info " +
            "(cardNumber, cvv, adjectiveTerm, name, lastName, adress, pin) " +
            "VALUES (:cardNumber, :cvv, :adjectiveTerm, :name, :lastName, :adress, :pin)")
    @Modifying
    public void addNewPaymentInfo(String cardNumber, int cvv, Date adjectiveTerm,
                                  String name, String lastName, String adress, int pin);
}
