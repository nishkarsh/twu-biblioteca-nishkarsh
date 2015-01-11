package com.twu.biblioteca;

import java.util.ArrayList;

public class BooksManager {
    private ArrayList<Book> books = new ArrayList<Book>();

    public String getBooksList() {
        StringBuilder bookList = new StringBuilder();

        for (Book book : books) {
            bookList.append(book.getDetails());
        }

        return bookList.toString();
    }

    public void addBook(Book book) {
        books.add(book);
    }
}
