package com.twu.biblioteca;

import java.util.ArrayList;

public class BooksManager {
    private ArrayList<Book> availableBooks = new ArrayList<Book>();
    private ArrayList<Book> checkedOutBooks = new ArrayList<Book>();

    public BooksManager() {
        availableBooks.add(new Book("Head First Java", "Bert Bates, Kathy Sierra", "January 1, 2004"));
        availableBooks.add(new Book("My Story", "Nishkarsh Sharma", "January 30, 2006"));
    }

    public String getBooksList() {
        StringBuilder bookList = new StringBuilder();

        for (Book book : availableBooks) {
            bookList.append(book.getDetails());
        }

        return bookList.toString();
    }

    public String checkOut(String bookName) {
        if(isAvailable(bookName)) {
            checkedOutBooks.add(getAvailableBookByName(bookName));
            availableBooks.remove(getAvailableBookByName(bookName));
            return "Thank you! Enjoy the book.\n";
        } else {
            return "That book is not available!\n";
        }
    }

    public String returnBook(String bookName) {
        if(isCheckedout(bookName)) {
            availableBooks.add(getCheckedoutBookByName(bookName));
            checkedOutBooks.remove(getCheckedoutBookByName(bookName));
            return "Thank you for returning the book.\n";
        } else {
            return "That is not a valid book to return.\n";
        }
    }

    private boolean isAvailable(String bookName) {
        return getAvailableBookByName(bookName) != null;
    }

    private boolean isCheckedout(String bookName) {
        return getCheckedoutBookByName(bookName) != null;
    }

    private Book getAvailableBookByName(String bookName) {
        for (Book book : availableBooks) {
            if(book.getDetails().contains(bookName))
                return book;
        }
        return null;
    }

    private Book getCheckedoutBookByName(String bookName) {
        for (Book book : checkedOutBooks) {
            if(book.getDetails().contains(bookName))
                return book;
        }
        return null;
    }
}
