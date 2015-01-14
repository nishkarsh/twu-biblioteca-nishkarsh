package com.twu.biblioteca;

import java.io.*;


public enum MenuItem {
    LIST_BOOKS(){
        @Override
        public void select(InputStream inputStream, PrintStream printStream) {
            printStream.println("Books List:\n");
            for (Book book : bookManager.getBooksList()) {
                printStream.println(String.format("%-30s %-30s %-30s", book.getName(), book.getAuthor(), book.getDatePublished()));
            }
        }
    },
    CHECKOUT_BOOK() {
        @Override
        public void select(InputStream inputStream, PrintStream printStream) {
            printStream.println("Enter Book Name to Checkout: ");
            String bookName = InputManager.getBookName(inputStream);
            if(bookManager.checkOut(bookName)) {
                printStream.println("Thank you! Enjoy the book");
            } else {
                printStream.println("That book is not available.");
            }
        }
    },
    RETURN_BOOK() {
        @Override
        public void select(InputStream inputStream, PrintStream printStream) {
            printStream.println("Enter Book Name to Return: ");
            String bookName = InputManager.getBookName(inputStream);
            if(bookManager.returnBook(bookName)) {
                printStream.println("Thank you for returning the book.");
            } else {
                printStream.println("That is not a valid book to return.");
            }
        }
    },
    QUIT() {
        @Override
        public void select(InputStream inputStream, PrintStream printStream) {
            System.exit(0);
        }
    };

    private static BookManager bookManager = new BookManager();

    abstract public void select(InputStream inputStream, PrintStream printStream);
}
