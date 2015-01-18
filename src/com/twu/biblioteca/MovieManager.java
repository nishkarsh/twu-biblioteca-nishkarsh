package com.twu.biblioteca;

import java.util.HashMap;

public class MovieManager extends ItemManager {
    public MovieManager(HashMap<Item, Boolean> movieList) {
        super(movieList);
    }

    @Override
    public String getHeaders() {
        return String.format("%-30s %-30s %-30s %-30s", "Name", "Year", "Director", "Rating");
    }

    @Override
    public String itemType() { return "Movie"; }
}
