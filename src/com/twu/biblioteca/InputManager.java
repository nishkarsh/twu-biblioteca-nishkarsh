package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputManager {
    public static String getBookName(InputStream inputStream) {
        String bookName = new String();
        BufferedReader nameReader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            bookName = nameReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bookName;
    }
}
