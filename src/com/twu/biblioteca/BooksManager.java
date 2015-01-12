package com.twu.biblioteca;

import java.util.ArrayList;

public class BooksManager {
    private ArrayList<Book> availableBooks = new ArrayList<Book>();
    private ArrayList<Book> checkedOutBooks = new ArrayList<Book>();

    public String getBooksList() {
        StringBuilder bookList = new StringBuilder();

        for (Book book : availableBooks) {
            bookList.append(book.getDetails());
        }

        return bookList.toString();
    }

    public void addBook(Book book) {
        availableBooks.add(book);
    }

    public String checkOut(String bookName) {
        if(isAvailable(bookName)) {
            checkedOutBooks.add(getBookByName(bookName));
            availableBooks.remove(getBookByName(bookName));
            return "Thank you! Enjoy the book.\n";
        } else {
            return "That book is not available!\n";
        }
    }

    private boolean isAvailable(String bookName) {
        return getBookByName(bookName) != null ? true : false;
    }

    public Book getBookByName(String bookName) {
        for (Book book : availableBooks) {
            if(book.getDetails().contains(bookName))
                return book;
        }
        return null;
    }
}
