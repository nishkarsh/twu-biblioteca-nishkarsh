package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BibliotecaTest {

    private BooksManager booksManager;

    @Before
    public void setUp() {
        booksManager = new BooksManager();
    }

    @Test
    public void testWelcomeMessage() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        BibliotecaLauncher.welcomeMessage();
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

        String booksList = Book.putInColumns("Head First Java", "Bert Bates, Kathy Sierra", "January 1, 2004");
        booksList += Book.putInColumns("My Story", "Nishkarsh Sharma", "January 30, 2006");

        assertEquals(booksList, booksManager.getBooksList());
    }

    @Test
    public void checkIfSuccessfulCheckout() {
        assertEquals("Thank you! Enjoy the book.\n", booksManager.checkOut("Head First Java"));
    }

    @Test
    public void checkIfUnsuccessfulCheckout() {
        assertEquals("That book is not available!\n", booksManager.checkOut("randomBook"));
    }

    @Test
    public void checkIfSuccessfulReturn() {
        booksManager.checkOut("Head First Java");
        assertEquals("Thank you for returning the book.\n", booksManager.returnBook("Head First Java"));
    }

    @Test
    public void checkIfUnsuccessfulReturn() {
        assertEquals("That is not a valid book to return.\n", booksManager.returnBook("Random Book"));
    }

    @Test
    public void checkIfValidOption() {
        HashMap<Integer, MenuItem> menuItemsMap = new HashMap<Integer, MenuItem>();
        menuItemsMap.put(1, MenuItem.LIST_BOOKS);
        MenuItemsMap itemsMap = new MenuItemsMap(menuItemsMap);

        assertTrue(itemsMap.isValid(1));
    }

    @Test
    public void checkIfInvalidOption() {
        HashMap<Integer, MenuItem> menuItemsMap = new HashMap<Integer, MenuItem>();
        MenuItemsMap itemsMap = new MenuItemsMap(menuItemsMap);

        assertFalse(itemsMap.isValid(1));
    }
}
