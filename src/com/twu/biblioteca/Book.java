package com.twu.biblioteca;

public class Book extends Item{
    private String name;
    private String author;
    private String datePublished;

    public Book(String name, String author, String datePublished) {
        this.name = name;
        this.author = author;
        this.datePublished = datePublished;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getDatePublished() {
        return datePublished;
    }

    @Override
    public String toString() {
        return String.format("%-30s %-30s %-30s", name, author, datePublished);
    }
}
