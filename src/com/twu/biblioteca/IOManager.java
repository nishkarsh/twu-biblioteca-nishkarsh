package com.twu.biblioteca;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class IOManager {

    private static PrintStream printStream = System.out;
    private static InputStream inputStream = System.in;

    public static String getItemName() {
        String itemName = new String();
        printStream.println("Enter the name: ");
        BufferedReader nameReader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            itemName = nameReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return itemName;
    }

    public static void welcomeMessage(PrintStream stream) {
        stream.println("Welcome to Biblioteca!");
    }

    public static void printSeparator() {
        char[] separator = new char[100];
        Arrays.fill(separator, '-');
        printStream.println(new String(separator));
    }

    public static void displayCheckoutMessage(boolean err) {
        if(!err) {
            printStream.println("Thank you! Enjoy the item");
        } else {
            printStream.println("That item is not available.");
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

    public static void displayReturnMessage(boolean err) {
        if(!err) {
            printStream.println("Thank you for returning the item.");
        } else {
            printStream.println("That is not a valid item to return.");
        }
    }
}
