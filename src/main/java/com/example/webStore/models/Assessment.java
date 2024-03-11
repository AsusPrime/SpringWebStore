package com.example.webStore.models;

import java.util.ArrayList;
import java.util.List;

public class Assessment {
    private double rating;
    private List<Integer> allRatings = new ArrayList<Integer>();

    public double getRating() {
        return rating;
    }

    public void addRating(int rating) {
        if(rating > 5 || rating < 0)
            throw new IllegalArgumentException("Rating is out of range");
        allRatings.add(rating);
        calcRating();
    }

    private void calcRating()
    {
        double sum = 0;
        for(int i : allRatings)
        {
            sum += i;
        }
        rating = sum / allRatings.size();
    }
}
