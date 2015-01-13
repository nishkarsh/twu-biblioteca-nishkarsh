package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BookManagerTest {

    private BooksManager booksManager;
    private String bookName;

    @Before
    public void setUp() {
        booksManager = new BooksManager();
        bookName = "Head First Java";
    }

    @Test
    public void checkIfSuccessfulCheckout() {
        assertTrue(booksManager.isAvailable(bookName));
        assertFalse(booksManager.isCheckedout(bookName));
        assertTrue(booksManager.checkOut(bookName));
        assertTrue(booksManager.isCheckedout(bookName));
        assertFalse(booksManager.isAvailable(bookName));
    }

    @Test
    public void checkIfUnsuccessfulCheckoutWhenNotAvailable() {
        assertFalse(booksManager.isAvailable("randomBook"));
        assertFalse(booksManager.isCheckedout("randomBook"));
        assertFalse(booksManager.checkOut("randomBook"));
    }

    @Test
    public void checkIfUnsuccessfulCheckoutWhenAlreadyCheckedOut() {
        assertTrue(booksManager.checkOut(bookName));
        assertFalse(booksManager.isAvailable(bookName));
        assertTrue(booksManager.isCheckedout(bookName));
        assertFalse(booksManager.checkOut(bookName));
    }

    @Test
    public void checkIfSuccessfulReturn() {
        assertTrue(booksManager.checkOut(bookName));
        assertFalse(booksManager.isAvailable(bookName));
        assertTrue(booksManager.isCheckedout(bookName));
        assertTrue(booksManager.returnBook(bookName));
        assertTrue(booksManager.isAvailable(bookName));
    }

    @Test
    public void checkIfUnsuccessfulReturn() {
        assertFalse(booksManager.isCheckedout("Head First Java"));
        assertFalse(booksManager.returnBook("Random Book"));
    }
}
