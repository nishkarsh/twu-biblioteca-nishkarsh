package com.twu.biblioteca;

public class Book {
    private String name;
    private String author;
    private String datePublished;

    public Book(String name, String author, String datePublished) {
        this.name = name;
        this.author = author;
        this.datePublished = datePublished;
    }

    public String getDetails() {
        return putInColumns(this.name, this.author, this.datePublished);
    }

     public static String putInColumns(String name, String author, String datePublished) {
        return String.format("%-30s | %-30s | %-30s\n", name, author, datePublished);
    }
}
