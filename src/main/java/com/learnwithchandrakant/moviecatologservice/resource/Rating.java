package com.learnwithchandrakant.moviecatologservice.resource;

public class Rating {

    private String movidId;
    private String rating;

    public Rating(String movidId, String rating) {
        this.movidId = movidId;
        this.rating = rating;
    }

    public String getMovidId() {
        return movidId;
    }

    public void setMovidId(String movidId) {
        this.movidId = movidId;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
