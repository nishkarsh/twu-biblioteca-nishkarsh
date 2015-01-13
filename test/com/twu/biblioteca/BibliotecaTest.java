package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BibliotecaTest {

    @Test
    public void testWelcomeMessage() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BibliotecaApp.welcomeMessage(new PrintStream(byteArrayOutputStream));
        assertEquals("Welcome to Biblioteca!\n", byteArrayOutputStream.toString());
    }

}
