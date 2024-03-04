package com.example.webStore.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PaymentInfoTest {
    @Test
    public void testSetCardNumber_ValidCardNumber() {
        PaymentInfo paymentInfo = new PaymentInfo();
        paymentInfo.setCardNumber("1234567890123456");
        assertEquals("1234567890123456", paymentInfo.getCardNumber());
    }

    @Test
    public void testSetCardNumber_WithSpaces() {
        PaymentInfo paymentInfo = new PaymentInfo();
        paymentInfo.setCardNumber("1234 5678 9012 3456");
        assertEquals("1234567890123456", paymentInfo.getCardNumber());
    }

    @Test
    public void testSetCardNumber_InvalidCardNumber_Length() {
        PaymentInfo paymentInfo = new PaymentInfo();
        assertThrows(IllegalArgumentException.class, () -> {
            paymentInfo.setCardNumber("12345678901234567");
        });
    }

    @Test
    public void testSetCardNumber_InvalidCardNumber_Format() {
        PaymentInfo paymentInfo = new PaymentInfo();
        assertThrows(IllegalArgumentException.class, () -> {
            paymentInfo.setCardNumber("123456789012345X");
        });
    }

    @Test
    public void testSetCvv_ValidCvv() {
        PaymentInfo paymentInfo = new PaymentInfo();
        paymentInfo.setCvv(1234);
        assertEquals(1234, paymentInfo.getCvv());
    }

    @Test
    public void testSetCvv_InvalidCvv_Length() {
        PaymentInfo paymentInfo = new PaymentInfo();
        assertThrows(IllegalArgumentException.class, () -> {
            paymentInfo.setCvv(123);
        });
    }


    @Test
    public void testSetPin_ValidPin() {
        PaymentInfo paymentInfo = new PaymentInfo();
        paymentInfo.setPin(1234);
        assertEquals(1234, paymentInfo.getPin());
    }

    @Test
    public void testSetPin_InvalidPin_Length() {
        PaymentInfo paymentInfo = new PaymentInfo();
        assertThrows(IllegalArgumentException.class, () -> {
            paymentInfo.setPin(123);
        });
    }
}
