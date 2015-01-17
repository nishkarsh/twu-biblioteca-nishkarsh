package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class MenuItemTest {

    ItemManager bookManager;
    ItemManager movieManager;
    MenuItemsMap itemsMap;


    @Before
    public void setUp() {
        Book headFirstJava = new Book("Head First Java", "Bert Bates, Kathy Sierra", "January 1, 2004");
        Book myStory = new Book("My Story", "Nishkarsh Sharma", "January 30, 2006");
        ArrayList<Book> bookList= new ArrayList<Book>();
        bookList.add(headFirstJava);
        bookList.add(myStory);
        bookManager = new BookManager(bookList, new ArrayList<Book>());

        Movie tpoh = new Movie("The Pursuit of HappYness", "2006", "Gabriele Muccino", "7.9");
        Movie castAway = new Movie("Cast Away", "2000", "Robert Zemeckis", "Unrated");
        ArrayList<Movie> movieList= new ArrayList<Movie>();
        movieList.add(tpoh);
        movieList.add(castAway);
        movieManager = new MovieManager(movieList, new ArrayList<Movie>());

        HashMap<Integer, MenuItemSelector> menuItemsMap = new HashMap<Integer, MenuItemSelector>();
        menuItemsMap.put(1, new ListMenuItem(bookManager));
        menuItemsMap.put(2, new CheckoutMenuItem(bookManager));
        menuItemsMap.put(3, new ReturnMenuItem(bookManager));
        menuItemsMap.put(4, new ListMenuItem(movieManager));
        menuItemsMap.put(5, new CheckoutMenuItem(movieManager));
        menuItemsMap.put(6, new ReturnMenuItem(movieManager));
        menuItemsMap.put(7, new QuitMenuItem());
        itemsMap = new MenuItemsMap(menuItemsMap);
    }

    @Test
    public void checkIfValidOption() {
        HashMap<Integer, MenuItemSelector> menuItemsMap = new HashMap<Integer, MenuItemSelector>();
        menuItemsMap.put(1, new ListMenuItem(bookManager));
        MenuItemsMap itemsMap = new MenuItemsMap(menuItemsMap);

        assertTrue(itemsMap.isValid(1));
    }

    @Test
    public void checkIfInvalidOption() {
        HashMap<Integer, MenuItemSelector> menuItemsMap = new HashMap<Integer, MenuItemSelector>();
        MenuItemsMap itemsMap = new MenuItemsMap(menuItemsMap);

        assertFalse(itemsMap.isValid(1));
    }

    @Test
    public void testListBookMenuItem() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        itemsMap.getMenuItem(1).select();
        assertThat(outputStream.toString(), is(String.format("List:\n\n\n%-30s %-30s %-30s\n%-30s %-30s %-30s\n", "Head First Java", "Bert Bates, Kathy Sierra", "January 1, 2004","My Story", "Nishkarsh Sharma", "January 30, 2006")));
    }

    @Test
    public void testCheckoutMenuItemAgainstAvailableBook() {
        byte[] input = "Head First Java".getBytes();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        itemsMap.getMenuItem(2).select();
        assertThat(outputStream.toString(), is("Enter Book Name to Checkout: \n" +
                "Thank you! Enjoy the book\n"));
    }

    @Test
    public void testCheckoutMenuItemAgainstNotAvailableBook() {
        byte[] input = "Random Book".getBytes();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        itemsMap.getMenuItem(2).select();
        assertThat(outputStream.toString(), is("Enter Book Name to Checkout: \n" +
                "That book is not available.\n"));
    }

    @Test
    public void testReturnMenuItemForCheckedOutBook() {
        byte[] input = "Head First Java".getBytes();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        itemsMap.getMenuItem(2).select();
        inputStream = new ByteArrayInputStream(input);
        itemsMap.getMenuItem(3).select();
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
        itemsMap.getMenuItem(3).select();
        assertThat(outputStream.toString(), is("Enter Book Name to Return: \n" +
                "That is not a valid book to return.\n"));
    }
}
