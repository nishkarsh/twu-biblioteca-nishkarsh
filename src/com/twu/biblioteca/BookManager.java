package com.twu.biblioteca;

import java.util.HashMap;

public class BookManager extends ItemManager {

    public BookManager(HashMap<Item, Boolean> bookList) {
        super(bookList);
    }

    @Override
    public String getHeaders() {
        return String.format("%-30s %-30s %-30s", "Name", "Author", "Date Published");
    }

    @Override
    public String itemType() { return "Book"; }
}
