package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class AppLauncher {

    public static void main(String[] args) {

        BooksManager booksManager = new BooksManager();
        BibliotecaApp bibliotecaApp = new BibliotecaApp(booksManager);

        bibliotecaApp.welcomeMessage(System.out);

        Book headFirstJava = new Book("Head First Java", "Bert Bates, Kathy Sierra", "January 1, 2004");
        Book myStory = new Book("My Story", "Nishkarsh Sharma", "January 30, 2006");

        booksManager.addBook(headFirstJava);
        booksManager.addBook(myStory);

        ArrayList<String> menuItems = new ArrayList<String>();
        menuItems.add("List Books");
        menuItems.add("Checkout Book");
        menuItems.add("Return Book");
        menuItems.add("Quit");
        Menu mainMenu = new Menu(menuItems);

        Scanner inputScanner = new Scanner(System.in);

        BufferedReader nameReader = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            System.out.println("Main Menu:\n"+mainMenu.getMenuItemsList());
            System.out.print("Your Choice: ");

            int option = inputScanner.nextInt();
            switch (option) {

                case 1:
                    System.out.println("Books List:\n"+bibliotecaApp.getBooksList());
                    break;

                case 2:
                    System.out.println("Enter Book Name to Checkout: ");
                    try {
                        String bookName = nameReader.readLine();
                        System.out.println(bibliotecaApp.checkoutBook(bookName));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;

                case 3:
                    System.out.println("Enter Book Name to Return: ");
                    try {
                        String bookName = nameReader.readLine();
                        System.out.println(bibliotecaApp.returnBook(bookName));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;

                case 4:
                    System.exit(0);

                default:
                    System.out.println("Select a valid option!");
            }
        }
    }
}
