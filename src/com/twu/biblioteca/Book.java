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

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getDatePublished() {
        return datePublished;
    }
}
