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

    private static boolean userLogin() {
        String libraryNumber = IOManager.getLibraryNumber();
        String password = IOManager.getPassword();

        boolean auth = users.containsKey(libraryNumber) && users.get(libraryNumber).getPassword().equals(password);
        IOManager.displayLoginMessage(auth);
        currentUser = auth ? users.get(libraryNumber) : null;
        return auth;
    }

    public static User getCurrentUser() {
        return currentUser;
    }
}
