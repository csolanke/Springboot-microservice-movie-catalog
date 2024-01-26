package com.learnwithchandrakant.moviecatologservice.resource;

public class Movie {

    private String movieID;
    private String name;
    private String overview;

    public Movie(String movieID, String name, String overview) {
        this.movieID = movieID;
        this.name = name;
        this.overview=overview;
    }

    public String getMovieID() {
        return movieID;
    }

    public void setMovieID(String movieID) {
        this.movieID = movieID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }
}
