package com.twu.biblioteca;

public class AppLauncher {

    public static void main(String[] args) {

        BooksManager booksManager = new BooksManager();
        BibliotecaApp bibliotecaApp = new BibliotecaApp(booksManager);

        bibliotecaApp.welcomeMessage(System.out);

        Book headFirstJava = new Book("Head First Java", "Bert Bates, Kathy Sierra", "January 1, 2004");
        Book myStory = new Book("My Story", "Nishkarsh Sharma", "January 30, 2006");

        booksManager.addBook(headFirstJava);
        booksManager.addBook(myStory);

        System.out.print(bibliotecaApp.getBooksList());
    }
}
