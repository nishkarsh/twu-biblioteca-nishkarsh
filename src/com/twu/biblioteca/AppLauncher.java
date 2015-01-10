package com.twu.biblioteca;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class AppLauncher {

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();

        bibliotecaApp.welcomeMessage(System.out);

        Book headFirstJava = new Book("Head First Java", "Bert Bates, Kathy Sierra", "January 1, 2004");
        Book myStory = new Book("My Story", "Nishkarsh Sharma", "January 30, 2006");

        bibliotecaApp.addBook(headFirstJava);
        bibliotecaApp.addBook(myStory);

        System.out.print(bibliotecaApp.getBookList());
    }
}
