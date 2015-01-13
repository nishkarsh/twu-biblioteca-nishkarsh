package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class MenuItemTest {

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

    @Test
    public void testListBookMenuItem() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        MenuItem.LIST_BOOKS.select(System.in, new PrintStream(outputStream));
        assertThat(outputStream.toString(), is(String.format("Books List:\n\n%-30s %-30s %-30s\n%-30s %-30s %-30s\n", "Head First Java", "Bert Bates, Kathy Sierra", "January 1, 2004","My Story", "Nishkarsh Sharma", "January 30, 2006")));
    }

    @Test
    public void testCheckoutMenuItemAgainstAvailableBook() {
        byte[] input = "Head First Java".getBytes();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        MenuItem.CHECKOUT_BOOK.select(inputStream, new PrintStream(outputStream));
        assertThat(outputStream.toString(), is("Enter Book Name to Checkout: \n" +
                "Thank you! Enjoy the book\n"));
    }

    @Test
    public void testCheckoutMenuItemAgainstNotAvailableBook() {
        byte[] input = "Random Book".getBytes();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        MenuItem.CHECKOUT_BOOK.select(inputStream, new PrintStream(outputStream));
        assertThat(outputStream.toString(), is("Enter Book Name to Checkout: \n" +
                "That book is not available.\n"));
    }

    @Test
    public void testReturnMenuItemForCheckedOutBook() {
        byte[] input = "Head First Java".getBytes();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        MenuItem.CHECKOUT_BOOK.select(inputStream, new PrintStream(outputStream));
        inputStream = new ByteArrayInputStream(input);
        MenuItem.RETURN_BOOK.select(inputStream, new PrintStream(outputStream));
        assertThat(outputStream.toString(), is("Enter Book Name to Checkout: \n" +
                "Thank you! Enjoy the book\n" +
                "Enter Book Name to Return: \n" +
                "Thank you for returning the book.\n"));
    }

    @Test
    public void testReturnMenuItemForInvalidBook() {
        byte[] input = "Random Book".getBytes();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        MenuItem.RETURN_BOOK.select(inputStream, new PrintStream(outputStream));
        assertThat(outputStream.toString(), is("Enter Book Name to Return: \n" +
                "That is not a valid book to return.\n"));
    }
}
