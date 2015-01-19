package com.twu.biblioteca;

import java.util.HashMap;

public class LoginManager {

    private static HashMap<String, User> users;
    private static User currentUser;

    public static void initialize(HashMap<String, User> userList) {
        users = userList;
    }

    public static boolean validateSession() {
        if(currentUser != null) {
            return true;
        }
        return userLogin();
    }

    public static boolean userLogin() {
        String libraryNumber = IOManager.getLibraryNumber();
        String password = IOManager.getPassword();

        boolean auth = isValid(libraryNumber, password);
        IOManager.displayLoginMessage(auth);
        currentUser = auth ? users.get(libraryNumber) : null;

        return auth;
    }

    private static boolean isValid(String libraryNumber, String password) {
        return users.containsKey(libraryNumber) && users.get(libraryNumber).getPassword().equals(password);
    }

    public static User getCurrentUser() {
        return currentUser;
    }
}
