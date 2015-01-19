package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {

    @Test
    public void testWelcomeMessage() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        IOManager.setPrintStream(new PrintStream(byteArrayOutputStream));
        IOManager.welcomeMessage();
        assertEquals("Welcome to Biblioteca!\n", byteArrayOutputStream.toString());
    }

}
