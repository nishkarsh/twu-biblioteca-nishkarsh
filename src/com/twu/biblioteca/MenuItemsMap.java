package com.twu.biblioteca;

import java.util.HashMap;

public class MenuItemsMap {
    private HashMap<Integer, MenuItemSelector> menuItemsMap = new HashMap<Integer, MenuItemSelector>();

    public MenuItemsMap(HashMap<Integer, MenuItemSelector> menuItemsMap) {
        this.menuItemsMap = menuItemsMap;
    }

    public MenuItemSelector getMenuItem(int number) {
        return menuItemsMap.get(number);
    }

    public boolean isValid(int option) {
        return menuItemsMap.containsKey(option);
    }
}
