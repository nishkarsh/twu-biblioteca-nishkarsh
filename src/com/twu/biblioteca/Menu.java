package com.twu.biblioteca;

import java.util.ArrayList;

public class Menu {

    ArrayList<String> menuItems;

    public Menu(ArrayList<String> menuItems) {
        this.menuItems = menuItems;
    }

    public void addOption(String option) {
        menuItems.add(option);
    }

    public String getMenuItemsList() {
        String menuItemsList = new String();
        int menuItemNumber = 1;

        for (String menuItem : menuItems) {
            menuItemsList += menuItemNumber +". "+ menuItem +"\n";
            menuItemNumber ++;
        }

        return menuItemsList;
    }
}
