package com.example.webStore.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PromotionTest {
    @Test
    public void testPromotionValidWithCorrectlyPercent() {
        Promotion promotion = new Promotion();
        promotion.setPercent(50);
        assertEquals(50, promotion.getPercent());
    }

    @Test
    public void testPromotionValidWithNegativePercent() {
        Promotion promotion = new Promotion();
        assertThrows(IllegalArgumentException.class, () -> {
            promotion.setPercent(-50);
        });
    }

    @Test
    public void testPromotionValidWithIncorrectPercent() {
        Promotion promotion = new Promotion();
        assertThrows(IllegalArgumentException.class, () -> {
            promotion.setPercent(150);
        });
    }
}
