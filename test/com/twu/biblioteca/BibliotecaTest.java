package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class BibliotecaTest {

    private BibliotecaApp bibliotecaApp;
    private BooksManager booksManager;

    @Before
    public void setUp() {
        booksManager = new BooksManager();
        bibliotecaApp = new BibliotecaApp(booksManager);
    }

    @Test
    public void testWelcomeMessage() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        bibliotecaApp.welcomeMessage(printStream);
        assertEquals("Welcome to Biblioteca!\n", byteArrayOutputStream.toString());
    }

    @Test
    public void checkIfBookDetailsCorrect() {
        Book headFirstJava = new Book("Head First Java", "Bert Bates, Kathy Sierra", "January 1, 2004");
        assertEquals(String.format("%-30s | %-30s | %-30s\n",
                "Head First Java", "Bert Bates, Kathy Sierra", "January 1, 2004"), headFirstJava.getDetails());
    }

    @Test
    public void checkIfBookListingCorrect() {
        Book headFirstJava = new Book("Head First Java", "Bert Bates, Kathy Sierra", "January 1, 2004");
        Book myStory = new Book("My Story", "Nishkarsh Sharma", "January 30, 2006");

        booksManager.addBook(headFirstJava);
        booksManager.addBook(myStory);

        String booksList = Book.putInColumns("Head First Java", "Bert Bates, Kathy Sierra", "January 1, 2004");
        booksList += Book.putInColumns("My Story", "Nishkarsh Sharma", "January 30, 2006");

        assertEquals(booksList, bibliotecaApp.getBooksList());
    }

    @Test
    public void checkIfMenuCreated() {
        ArrayList<String> menuItems = new ArrayList<String>();
        menuItems.add("List Books");

        Menu mainMenu = new Menu(menuItems);
        assertEquals("1. List Books\n", mainMenu.getMenuItemsList());
    }

    @Test
    public void checkIfMenuOptionAdded() {
        ArrayList<String> menuItems = new ArrayList<String>();
        menuItems.add("List Books");

        Menu mainMenu = new Menu(menuItems);
        mainMenu.addOption("Quit");

        assertEquals("1. List Books\n2. Quit\n", mainMenu.getMenuItemsList());
    }

    @Test
    public void checkIfSuccessfulCheckout() {
        Book headFirstJava = new Book("Head First Java", "Bert Bates, Kathy Sierra", "January 1, 2004");
        Book myStory = new Book("My Story", "Nishkarsh Sharma", "January 30, 2006");

        booksManager.addBook(headFirstJava);
        booksManager.addBook(myStory);

        assertEquals("Thank you! Enjoy the book.\n", booksManager.checkOut("Head First Java"));
    }

    @Test
    public void checkIfUnsuccessfulCheckout() {
        Book headFirstJava = new Book("Head First Java", "Bert Bates, Kathy Sierra", "January 1, 2004");
        booksManager.addBook(headFirstJava);

        assertEquals("That book is not available!\n", booksManager.checkOut("randomBook"));
    }
}
