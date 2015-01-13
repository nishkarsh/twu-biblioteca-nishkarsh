package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public enum MenuItem {
    LIST_BOOKS(){
        @Override
        public void select() {
            System.out.println("Books List:\n" + booksManager.getBooksList());
        }
    },
    CHECKOUT_BOOK() {
        @Override
        public void select() {
            BufferedReader nameReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter Book Name to Checkout: ");
            try {
                String bookName = nameReader.readLine();
                System.out.println(booksManager.checkOut(bookName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    },
    RETURN_BOOK() {
        @Override
        public void select() {
            BufferedReader nameReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter Book Name to Return: ");
            try {
                String bookName = nameReader.readLine();
                System.out.println(booksManager.returnBook(bookName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    },
    QUIT() {
        @Override
        public void select() {
            System.exit(0);
        }
    };

    private static BooksManager booksManager = new BooksManager();

    abstract public void select();
}
