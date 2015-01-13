package com.twu.biblioteca;

import java.util.HashMap;

public class MenuItemsMap {
    private HashMap<Integer, MenuItem> menuItemsMap = new HashMap<Integer, MenuItem>();

    public MenuItemsMap(HashMap<Integer, MenuItem> menuItemsMap) {
        this.menuItemsMap = menuItemsMap;
    }

    public MenuItem getMenuItem(int number) {
        return menuItemsMap.get(number);
    }

    public boolean isValid(int option) {
        return menuItemsMap.containsKey(option);
    }
}
