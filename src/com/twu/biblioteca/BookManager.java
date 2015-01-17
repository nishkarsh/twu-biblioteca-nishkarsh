package com.twu.biblioteca;

import java.util.ArrayList;

public class BookManager extends ItemManager {

    public BookManager(ArrayList<Book> listAvailable, ArrayList<Book> listCheckedOut) {
        super(listAvailable, listCheckedOut);
    }

    @Override
    public String getHeaders() {
        return String.format("%-30s %-30s %-30s", "Name", "Author", "Date Published");
    }
}
