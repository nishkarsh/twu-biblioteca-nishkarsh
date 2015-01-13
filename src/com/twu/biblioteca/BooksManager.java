package com.twu.biblioteca;

import java.util.ArrayList;

public class BooksManager {
    private ArrayList<Book> availableBooks = new ArrayList<Book>();
    private ArrayList<Book> checkedOutBooks = new ArrayList<Book>();

    public BooksManager() {
        availableBooks.add(new Book("Head First Java", "Bert Bates, Kathy Sierra", "January 1, 2004"));
        availableBooks.add(new Book("My Story", "Nishkarsh Sharma", "January 30, 2006"));
    }

    public ArrayList<Book> getBooksList() {
        return availableBooks;
    }

    public boolean checkOut(String bookName) {
        if(isAvailable(bookName)) {
            checkedOutBooks.add(getAvailableBookByName(bookName));
            availableBooks.remove(getAvailableBookByName(bookName));
            return true;
        } else {
            return false;
        }
    }

    public boolean returnBook(String bookName) {
        if(isCheckedout(bookName)) {
            availableBooks.add(getCheckedoutBookByName(bookName));
            checkedOutBooks.remove(getCheckedoutBookByName(bookName));
            return true;
        } else {
            return false;
        }
    }

    public boolean isAvailable(String bookName) {
        return getAvailableBookByName(bookName) != null;
    }

    public boolean isCheckedout(String bookName) {
        return getCheckedoutBookByName(bookName) != null;
    }

    private Book getAvailableBookByName(String bookName) {
        for (Book book : availableBooks) {
            if(bookName.equals(book.getName()))
                return book;
        }
        return null;
    }

    private Book getCheckedoutBookByName(String bookName) {
        for (Book book : checkedOutBooks) {
            if(bookName.equals(book.getName()))
                return book;
        }
        return null;
    }
}
