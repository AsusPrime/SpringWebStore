package com.example.webStore.models;

public class Assessment {
    private int rating;

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        if(rating > 5 || rating < 0)
            throw new IllegalArgumentException("Rating is out of range");
        this.rating = rating;
    }
}
