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
            checkedOutBooks.add(getAvailableBookByName(bookName));
            availableBooks.remove(getAvailableBookByName(bookName));
            return "Thank you! Enjoy the book.\n";
        } else {
            return "That book is not available!\n";
        }
    }

    private boolean isAvailable(String bookName) {
        return getAvailableBookByName(bookName) != null ? true : false;
    }

    private boolean isCheckedout(String bookName) {
        return getCheckeoutBookByName(bookName) != null ? true : false;
    }

    public Book getAvailableBookByName(String bookName) {
        for (Book book : availableBooks) {
            if(book.getDetails().contains(bookName))
                return book;
        }
        return null;
    }

    public Book getCheckeoutBookByName(String bookName) {
        for (Book book : checkedOutBooks) {
            if(book.getDetails().contains(bookName))
                return book;
        }
        return null;
    }

    public String returnBook(String bookName) {
        if(isCheckedout(bookName)) {
            availableBooks.add(getCheckeoutBookByName(bookName));
            checkedOutBooks.remove(getCheckeoutBookByName(bookName));
            return "Thank you for returning the book.\n";
        } else {
            return "That is not a valid book to return.\n";
        }
    }
}
