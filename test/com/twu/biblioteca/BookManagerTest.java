package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BookManagerTest {

    private ItemManager bookManager;
    private String bookName;
    Book headFirstJava;
    Book myStory;

    @Before
    public void setUp() {
        headFirstJava = new Book("Head First Java", "Bert Bates, Kathy Sierra", "January 1, 2004");
        myStory = new Book("My Story", "Nishkarsh Sharma", "January 30, 2006");
        ArrayList<Book> bookList= new ArrayList<Book>();
        bookList.add(headFirstJava);
        bookList.add(myStory);
        bookManager = new BookManager(bookList, new ArrayList<Book>());
    }

    @Test
    public void checkIfSuccessfulCheckout() {
        assertTrue(bookManager.isAvailable(headFirstJava));
        assertFalse(bookManager.isCheckedout(headFirstJava));
        assertTrue(bookManager.checkOut(headFirstJava));
        assertTrue(bookManager.isCheckedout(headFirstJava));
        assertFalse(bookManager.isAvailable(headFirstJava));
    }

    @Test
    public void checkIfUnsuccessfulCheckoutWhenNotAvailable() {
        Book randomBook = new Book("", "", "");
        assertFalse(bookManager.isAvailable(randomBook));
        assertFalse(bookManager.isCheckedout(randomBook));
        assertFalse(bookManager.checkOut(randomBook));
    }

    @Test
    public void checkIfUnsuccessfulCheckoutWhenAlreadyCheckedOut() {
        assertTrue(bookManager.checkOut(headFirstJava));
        assertFalse(bookManager.isAvailable(headFirstJava));
        assertTrue(bookManager.isCheckedout(headFirstJava));
        assertFalse(bookManager.checkOut(headFirstJava));
    }

    @Test
    public void checkIfSuccessfulReturn() {
        assertTrue(bookManager.checkOut(headFirstJava));
        assertFalse(bookManager.isAvailable(headFirstJava));
        assertTrue(bookManager.isCheckedout(headFirstJava));
        assertTrue(bookManager.returnItem(headFirstJava));
        assertTrue(bookManager.isAvailable(headFirstJava));
    }

    @Test
    public void checkIfUnsuccessfulReturn() {
        assertFalse(bookManager.isCheckedout(headFirstJava));
        assertFalse(bookManager.returnItem(headFirstJava));
    }
}
