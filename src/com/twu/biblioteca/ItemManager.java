package com.twu.biblioteca;

import java.util.ArrayList;

abstract public class ItemManager {

    ArrayList<Item> listAvailable = new ArrayList<Item>();
    ArrayList<Item> listCheckedOut = new ArrayList<Item>();

    public ItemManager(ArrayList<? extends Item> listAvailable, ArrayList<? extends Item> listCheckedOut) {
        this.listAvailable.addAll(listAvailable);
        this.listCheckedOut.addAll(listCheckedOut);
    }

    public ArrayList<Item> getItemList() {
        ArrayList<Item> itemsList = new ArrayList<Item>();
        for(Item item : listAvailable) {
                itemsList.add(item);
        }
        return itemsList;
    }

    public boolean isAvailable(Item item) {
        return listAvailable.contains(item);
    }

    public boolean isCheckedout(Item item) {
        return listCheckedOut.contains(item);
    }

    public boolean checkOut(Item item) {
        if(isAvailable(item)) {
            listCheckedOut.add(item);
            listAvailable.remove(item);
            return true;
        } else {
            return false;
        }
    }

    public boolean returnItem(Item item) {
        if(isCheckedout(item)) {
            listAvailable.add(item);
            listCheckedOut.remove(item);
            return true;
        } else {
            return false;
        }
    }

    public Item getAvailableItemByName(String itemName) {
        for (Item item : listAvailable) {
            if(itemName.equals(item.getName()))
                return item;
        }
        return null;
    }

    public Item getCheckedOutItemByName(String itemName) {
        for (Item item : listCheckedOut) {
            if(itemName.equals(item.getName()))
                return item;
        }
        return null;
    }


    abstract public String getHeaders();
}
