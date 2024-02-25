package com.example.webStore.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PriceTest {
    @Test
    public void testPriceValidWithInteger() {
        Price price = new Price();
        price.setPrice(123);
        assertEquals(123., price.getPrice());
    }
    @Test
    public void testPriceValidWithNoFractions() {
        Price price = new Price();
        price.setPrice(123.);
        assertEquals(123., price.getPrice());
    }
    @Test
    public void testPriceValidWithOneFraction() {
        Price price = new Price();
        price.setPrice(123.4);
        assertEquals(123.4, price.getPrice());
    }
    @Test
    public void testPriceValidWithTwoFractions() {
        Price price = new Price();
        price.setPrice(123.45);
        assertEquals(123.45, price.getPrice());
    }

    @Test
    public void testPriceValidWithThreeFractions() {
        Price price = new Price();
        assertThrows(IllegalArgumentException.class, () -> {
            price.setPrice(123.456);
        });
    }
}
