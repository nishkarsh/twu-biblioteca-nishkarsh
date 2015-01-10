package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BibliotecaTest {

    public BibliotecaApp bibliotecaApp;

    @Before
    public void setUp() {
        bibliotecaApp = new BibliotecaApp();
        Book headFirstJava = new Book("Head First Java", "Bert Bates, Kathy Sierra", "January 1, 2004");
        Book myStory = new Book("My Story", "Nishkarsh Sharma", "January 30, 2006");
        bibliotecaApp.addBook(headFirstJava);
        bibliotecaApp.addBook(myStory);
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
        assertEquals("Head First Java\t" +
                "Bert Bates, Kathy Sierra\t" +
                "January 1, 2004\n", headFirstJava.getDetails());
    }

    @Test
    public void checkIfBookListingCorrect() {
        String books = "Head First Java\tBert Bates, Kathy Sierra\tJanuary 1, 2004\n"+
                "My Story\tNishkarsh Sharma\tJanuary 30, 2006\n";

        assertEquals(books, bibliotecaApp.getBookList());
    }
}
