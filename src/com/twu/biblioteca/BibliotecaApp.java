package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;

public class BibliotecaApp {

    private ArrayList<Book> books = new ArrayList<Book>();

    public void welcomeMessage(PrintStream printStream) {
        printStream.println("Welcome to Biblioteca!");
    }

    public String getBookList() {
        StringBuffer bookList = new StringBuffer();
        for (Book book : books) {
            bookList.append(book.getDetails());
        }
        return bookList.toString();
    }

    public void addBook(Book book) {
        books.add(book);
    }
}
