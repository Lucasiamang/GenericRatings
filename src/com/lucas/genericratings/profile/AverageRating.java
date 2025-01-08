package com.lucas.genericratings.profile;

import com.lucas.genericratings.details.Title;

public class AverageRating {

    private double sumRatings;
    private double average = 0;

    public double getSumRatings() {
        return sumRatings;
    }

    public double getAverage() {
        return average;
    }

    public void calcRat(Title r){
        sumRatings += r.getRating();
        average++;
    }



}
