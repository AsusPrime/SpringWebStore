package com.example.webStore.models;

import com.example.webStore.exceptions.OutOfBoundsException;

public class Assessment {
    private int rating;

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        if(rating > 5 || rating < 0)
            throw new OutOfBoundsException();
        this.rating = rating;
    }
}
