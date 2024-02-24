package com.example.webStore.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssessmentTest {

    @Test
    public void testGetRating() {
        Assessment assessment = new Assessment();
        assessment.setRating(3);
        assertEquals(3, assessment.getRating());
    }

    @Test
    public void testSetRating_OutOfBoundsException() {
        Assessment assessment = new Assessment();
        assertThrows(IllegalArgumentException.class, () -> {
            assessment.setRating(6); // Пытаемся установить рейтинг больше 5
        });
    }

    @Test
    public void testSetRating_NegativeValue_OutOfBoundsException() {
        Assessment assessment = new Assessment();
        assertThrows(IllegalArgumentException.class, () -> {
            assessment.setRating(-1); // Пытаемся установить отрицательный рейтинг
        });
    }
}
