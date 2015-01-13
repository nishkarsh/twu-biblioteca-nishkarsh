package com.twu.biblioteca;

import java.io.*;


public enum MenuItem {
    LIST_BOOKS(){
        @Override
        public void select(InputStream inputStream, PrintStream printStream) {
            printStream.println("Books List:\n");
            for (Book book : booksManager.getBooksList()) {
                printStream.println(String.format("%-30s %-30s %-30s", book.getName(), book.getAuthor(), book.getDatePublished()));
            }
        }
    },
    CHECKOUT_BOOK() {
        @Override
        public void select(InputStream inputStream, PrintStream printStream) {
            BufferedReader nameReader = new BufferedReader(new InputStreamReader(inputStream));
            printStream.println("Enter Book Name to Checkout: ");
            try {
                String bookName = nameReader.readLine();

                if(booksManager.checkOut(bookName)) {
                    printStream.println("Thank you! Enjoy the book");
                } else {
                    printStream.println("That book is not available.");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    },
    RETURN_BOOK() {
        @Override
        public void select(InputStream inputStream, PrintStream printStream) {
            BufferedReader nameReader = new BufferedReader(new InputStreamReader(inputStream));
            printStream.println("Enter Book Name to Return: ");
            try {
                String bookName = nameReader.readLine();

                if(booksManager.returnBook(bookName)) {
                    printStream.println("Thank you for returning the book.");
                } else {
                    printStream.println("That is not a valid book to return.");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    },
    QUIT() {
        @Override
        public void select(InputStream inputStream, PrintStream printStream) {
            System.exit(0);
        }
    };

    private static BooksManager booksManager = new BooksManager();

    abstract public void select(InputStream inputStream, PrintStream printStream);
}
