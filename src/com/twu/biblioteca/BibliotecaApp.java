package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BibliotecaApp {



    public static void main(String[] args) {

        IOManager.welcomeMessage(System.out);

        Book headFirstJava = new Book("Head First Java", "Bert Bates, Kathy Sierra", "January 1, 2004");
        Book myStory = new Book("My Story", "Nishkarsh Sharma", "January 30, 2006");
        ArrayList<Book> bookList= new ArrayList<Book>();
        bookList.add(headFirstJava);
        bookList.add(myStory);
        ItemManager bookManager = new BookManager(bookList, new ArrayList<Book>());
        
        Movie tpoh = new Movie("The Pursuit of HappYness", "2006", "Gabriele Muccino", "7.9");
        Movie castAway = new Movie("Cast Away", "2000", "Robert Zemeckis", "Unrated");
        ArrayList<Movie> movieList= new ArrayList<Movie>();
        movieList.add(tpoh);
        movieList.add(castAway);
        ItemManager movieManager = new MovieManager(movieList, new ArrayList<Movie>());
        
        HashMap<Integer, MenuItemSelector> menuItemsMap = new HashMap<Integer, MenuItemSelector>();
        menuItemsMap.put(1, new ListMenuItem(bookManager));
        menuItemsMap.put(2, new CheckoutMenuItem(bookManager));
        menuItemsMap.put(3, new ReturnMenuItem(bookManager));
        menuItemsMap.put(4, new ListMenuItem(movieManager));
        menuItemsMap.put(5, new CheckoutMenuItem(movieManager));
        menuItemsMap.put(6, new ReturnMenuItem(movieManager));
        menuItemsMap.put(7, new QuitMenuItem());
        MenuItemsMap itemsMap = new MenuItemsMap(menuItemsMap);

        Scanner inputScanner = new Scanner(System.in);

        while(true) {
            System.out.println("Main Menu:\n");
            System.out.println("1. List Books");
            System.out.println("2. Checkout Book");
            System.out.println("3. Return Book");
            System.out.println("4. List Movies");
            System.out.println("5. Checkout Movie");
            System.out.println("6. Return Movie");
            System.out.println("7. Quit");
            System.out.print("Your Choice: ");

            int option = inputScanner.nextInt();
            if(itemsMap.isValid(option))
                itemsMap.getMenuItem(option).select();
            else
                System.out.println("Select a valid option!");
        }
    }
}
