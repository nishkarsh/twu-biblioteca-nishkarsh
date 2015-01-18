package com.twu.biblioteca;

import java.util.HashMap;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {

        IOManager.welcomeMessage(System.out);

        Book headFirstJava = new Book("Head First Java", "Bert Bates, Kathy Sierra", "January 1, 2004");
        Book myStory = new Book("My Story", "Nishkarsh Sharma", "January 30, 2006");
        HashMap<Item, Boolean> bookList= new HashMap<Item, Boolean>();
        bookList.put(headFirstJava, true);
        bookList.put(myStory, true);
        ItemManager bookManager = new BookManager(bookList);
        
        Movie tpoh = new Movie("The Pursuit of HappYness", "2006", "Gabriele Muccino", "7.9");
        Movie castAway = new Movie("Cast Away", "2000", "Robert Zemeckis", "Unrated");
        HashMap<Item, Boolean> movieList= new HashMap<Item, Boolean>();
        movieList.put(tpoh, true);
        movieList.put(castAway, true);
        ItemManager movieManager = new MovieManager(movieList);

        User nishkarsh = new User("537-1253", "something", "Nishkarsh Sharma", "nishkarsh4@gmail.com", "9545655244");
        User amit = new User("123-4567", "everything", "Amit Singh", "amit55@gmail.com", "9123456775");
        HashMap<String, User> userList = new HashMap<String, User>();
        userList.put(nishkarsh.getLibraryNumber(), nishkarsh);
        userList.put(amit.getLibraryNumber(), amit);
        LoginManager.initialize(userList);
        
        HashMap<Integer, MenuItem> menuItemsMap = new HashMap<Integer, MenuItem>();
        menuItemsMap.put(1, new ListMenuItem(bookManager));
        menuItemsMap.put(2, new CheckoutMenuItem(bookManager));
        menuItemsMap.put(3, new ReturnMenuItem(bookManager));
        menuItemsMap.put(4, new ListMenuItem(movieManager));
        menuItemsMap.put(5, new CheckoutMenuItem(movieManager));
        menuItemsMap.put(6, new ReturnMenuItem(movieManager));
        menuItemsMap.put(7, new UserInformation());
        menuItemsMap.put(8, new QuitMenuItem());
        MenuItemsMap itemsMap = new MenuItemsMap(menuItemsMap);

        Scanner inputScanner = new Scanner(System.in);

        while(true) {
            IOManager.displayMenu();
            int option = inputScanner.nextInt();
            if(itemsMap.isValid(option))
                itemsMap.getMenuItem(option).select();
            else
                System.out.println("Select a valid option!");
        }
    }
}
