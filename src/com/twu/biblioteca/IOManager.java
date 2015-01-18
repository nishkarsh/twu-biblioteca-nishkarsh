package com.twu.biblioteca;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class IOManager {

    private static PrintStream printStream = System.out;
    private static InputStream inputStream = System.in;

    public static void setInputStream(InputStream inputStream) {
        IOManager.inputStream = inputStream;
    }

    public static void setPrintStream(PrintStream printStream) {
        IOManager.printStream = printStream;
    }

    public static void welcomeMessage(PrintStream stream) {
        stream.println("Welcome to Biblioteca!");
    }

    public static void displayMenu() {
        printStream.println("Main Menu:\n");
        printStream.println("1. List Books");
        printStream.println("2. Checkout Book");
        printStream.println("3. Return Book");
        printStream.println("4. List Movies");
        printStream.println("5. Checkout Movie");
        printStream.println("6. Return Movie");
        printStream.println("7. User Information");
        printStream.println("8. Quit");
        printStream.print("Your Choice: ");
    }

    public static String getItemName() {
        printStream.println("Enter the name: ");
        return getString();
    }

    public static String getLibraryNumber() {
        printStream.println("Enter your library number: ");
        return getString();
    }

    public static String getPassword() {
        printStream.println("Enter password: ");
        return getString();
    }

    public static void printSeparator() {
        char[] separator = new char[100];
        Arrays.fill(separator, '-');
        printStream.println(new String(separator));
    }

    public static void displayCheckoutMessage(boolean checkoutSuccessful, String itemType) {
        if(checkoutSuccessful) {
            printStream.println("Thank you! Enjoy the " + itemType);
        } else {
            printStream.println("That " + itemType + " is not available.");
        }
    }

    public static void printItemList(ArrayList<Item> itemList, String headers) {
        printStream.println(headers);
        printSeparator();
        for (Item item : itemList) {
            printStream.println(item);
        }
        printSeparator();
    }

    public static void displayReturnMessage(boolean returnSuccessful, String itemType) {
        if(returnSuccessful) {
            printStream.println("Thank you for returning the " + itemType);
        } else {
            printStream.println("That is not a valid " + itemType +" to return.");
        }
    }

    public static void displayLoginMessage(boolean auth) {
        if(auth) {
            printStream.println("Successfull Login!");
        } else {
            printStream.println("Invalid Library number or Password!");
        }
    }

    public static void printUserDetails(User currentUser) {
        printStream.println(String.format("%-30s %-30s %-30s", "Name", "Email", "Phone Number"));
        printSeparator();
        printStream.println(currentUser);
        printSeparator();
    }

    private static String getString() {
        String str = new String();
        BufferedReader strReader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            str = strReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
