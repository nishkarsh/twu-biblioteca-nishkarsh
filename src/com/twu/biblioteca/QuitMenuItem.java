package com.twu.biblioteca;

public class QuitMenuItem extends MenuItem {
    @Override
    public void select() {
        System.exit(0);
    }
}
