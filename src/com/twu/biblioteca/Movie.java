package com.twu.biblioteca;

public class Movie extends Item {
    private String name;
    private String year;
    private String director;
    private String rating;

    public Movie(String name, String year, String director, String rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%-30s %-30s %-30s %-30s", name, year, director, rating);
    }
}
