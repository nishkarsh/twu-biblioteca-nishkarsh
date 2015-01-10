package com.twu.biblioteca;

public class Book {
    private String name;
    private String author;
    private String date;

    public Book(String name, String author, String date) {
        this.name = name;
        this.author = author;
        this.date = date;
    }

    public String getDetails() {
        return String.format("%-30s | %-30s | %-30s\n", this.name, this.author, this.date);
    }
}
