package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public enum MenuItem {
    LIST_BOOKS(){
        @Override
        public void select() {
            System.out.println("Books List:\n");
            for (Book book : booksManager.getBooksList()) {
                System.out.println(String.format("%-30s %-30s %-30s", book.getName(), book.getAuthor(), book.getDatePublished()));
            }
        }
    },
    CHECKOUT_BOOK() {
        @Override
        public void select() {
            BufferedReader nameReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter Book Name to Checkout: ");
            try {
                String bookName = nameReader.readLine();

                if(booksManager.checkOut(bookName)) {
                    System.out.println("Thank you! Enjoy the book");
                } else {
                    System.out.println("That book is not available.");
                }

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

                if(booksManager.returnBook(bookName)) {
                    System.out.println("Thank you for returning the book.");
                } else {
                    System.out.println("That is not a valid book to return.");
                }

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
