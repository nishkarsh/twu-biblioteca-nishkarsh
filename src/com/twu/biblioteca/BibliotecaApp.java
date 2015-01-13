package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;

public class BibliotecaApp {

    public static void welcomeMessage(PrintStream stream) {
        stream.println("Welcome to Biblioteca!");
    }

    public static void main(String[] args) {

        welcomeMessage(System.out);

        HashMap<Integer, MenuItem> menuItemsMap = new HashMap<Integer, MenuItem>();
        menuItemsMap.put(1, MenuItem.LIST_BOOKS);
        menuItemsMap.put(2, MenuItem.CHECKOUT_BOOK);
        menuItemsMap.put(3, MenuItem.RETURN_BOOK);
        menuItemsMap.put(4, MenuItem.QUIT);
        MenuItemsMap itemsMap = new MenuItemsMap(menuItemsMap);

        Scanner inputScanner = new Scanner(System.in);

        while(true) {
            System.out.println("Main Menu:\n");
            System.out.println("1. List Books");
            System.out.println("2. Checkout Book");
            System.out.println("3. Return Book");
            System.out.println("4. Quit");
            System.out.print("Your Choice: ");

            int option = inputScanner.nextInt();
            if(itemsMap.isValid(option))
                itemsMap.getMenuItem(option).select();
            else
                System.out.println("Select a valid option!");
        }
    }
}
