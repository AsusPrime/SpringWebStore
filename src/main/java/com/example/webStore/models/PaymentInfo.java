package com.example.webStore.models;

import lombok.Builder;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Builder
public class PaymentInfo {
    @Id
    private int id;
    private String cardNumber;
    private int cvv;
    private Date adjectiveTerm;
    private String name;
    private String lastName;
    private String address;
    private int pin;


    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        // Удаление пробелов из номера карты, если они есть
        cardNumber = cardNumber.replaceAll("\\s", "");

        // Проверка наличия 16 цифр в номере карты
        if (cardNumber.length() != 16) {
            throw new IllegalArgumentException("Сard number must have 16 digits");
        }

        // Проверка, что все символы номера карты являются цифрами
        for (int i = 0; i < cardNumber.length(); i++) {
            if (!Character.isDigit(cardNumber.charAt(i))) {
                throw new IllegalArgumentException("Сard number must contain only numbers");
            }
        }

        this.cardNumber = cardNumber;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        // Проверка наличия 4 цифр в CVV
        String cvv_s = String.valueOf(cvv);
        if (cvv_s.length() != 4) {
            throw new IllegalArgumentException("CVV must have 4 digits");
        }

        // Проверка, что все символы CVV являются цифрами
        for (int i = 0; i < cvv_s.length(); i++) {
            if (!Character.isDigit(cvv_s.charAt(i))) {
                throw new IllegalArgumentException("CVV must contain only numbers");
            }
        }

        this.cvv = cvv;
    }

    public Date getAdjectiveTerm() {
        return adjectiveTerm;
    }

    public void setAdjectiveTerm(Date adjectiveTerm) {
        this.adjectiveTerm = adjectiveTerm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        // Проверка наличия 4 цифр в PIN
        String pin_s = String.valueOf(pin);
        if (pin_s.length() != 4) {
            throw new IllegalArgumentException("PIN must have 4 digits");
        }

        // Проверка, что все символы PIN являются цифрами
        for (int i = 0; i < pin_s.length(); i++) {
            if (!Character.isDigit(pin_s.charAt(i))) {
                throw new IllegalArgumentException("CVV must contain only numbers");
            }
        }

        this.pin = pin;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
