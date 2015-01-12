package com.twu.biblioteca;

import java.io.PrintStream;

public class BibliotecaApp {

    private BooksManager booksManager;

    public BibliotecaApp(BooksManager booksManager) {
        this.booksManager = booksManager;
    }

    public void welcomeMessage(PrintStream printStream) {
        printStream.println("Welcome to Biblioteca!");
    }

    public String getBooksList() {
        return booksManager.getBooksList();
    }

    public String checkoutBook(String bookName) {
        return booksManager.checkOut(bookName);
    }
}
