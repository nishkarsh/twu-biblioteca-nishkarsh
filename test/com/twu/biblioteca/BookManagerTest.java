package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BookManagerTest {

    private BookManager bookManager;
    private String bookName;

    @Before
    public void setUp() {
        bookManager = new BookManager();
        bookName = "Head First Java";
    }

    @Test
    public void checkIfSuccessfulCheckout() {
        assertTrue(bookManager.isAvailable(bookName));
        assertFalse(bookManager.isCheckedout(bookName));
        assertTrue(bookManager.checkOut(bookName));
        assertTrue(bookManager.isCheckedout(bookName));
        assertFalse(bookManager.isAvailable(bookName));
    }

    @Test
    public void checkIfUnsuccessfulCheckoutWhenNotAvailable() {
        assertFalse(bookManager.isAvailable("randomBook"));
        assertFalse(bookManager.isCheckedout("randomBook"));
        assertFalse(bookManager.checkOut("randomBook"));
    }

    @Test
    public void checkIfUnsuccessfulCheckoutWhenAlreadyCheckedOut() {
        assertTrue(bookManager.checkOut(bookName));
        assertFalse(bookManager.isAvailable(bookName));
        assertTrue(bookManager.isCheckedout(bookName));
        assertFalse(bookManager.checkOut(bookName));
    }

    @Test
    public void checkIfSuccessfulReturn() {
        assertTrue(bookManager.checkOut(bookName));
        assertFalse(bookManager.isAvailable(bookName));
        assertTrue(bookManager.isCheckedout(bookName));
        assertTrue(bookManager.returnBook(bookName));
        assertTrue(bookManager.isAvailable(bookName));
    }

    @Test
    public void checkIfUnsuccessfulReturn() {
        assertFalse(bookManager.isCheckedout("Head First Java"));
        assertFalse(bookManager.returnBook("Random Book"));
    }
}
