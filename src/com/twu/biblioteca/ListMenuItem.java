package com.twu.biblioteca;

import java.util.ArrayList;

public class ListMenuItem extends MenuItem {

    private ItemManager itemManager;

    public ListMenuItem(ItemManager itemManager) {
        this.itemManager = itemManager;
    }

    @Override
    public void select() {
        ArrayList<Item> itemList = itemManager.getItemList();
        IOManager.printItemList(itemList, itemManager.getHeaders());
    }
}
