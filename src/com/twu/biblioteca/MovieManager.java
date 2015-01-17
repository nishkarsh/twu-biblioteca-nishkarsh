package com.twu.biblioteca;

import java.util.ArrayList;

public class MovieManager extends ItemManager {
    public MovieManager(ArrayList<Movie> listAvailable, ArrayList<Movie> listCheckedOut) {
        super(listAvailable, listCheckedOut);
    }

    @Override
    public String getHeaders() {
        return String.format("%-30s %-30s %-30s %-30s", "Name", "Year", "Director", "Rating");
    }
}
