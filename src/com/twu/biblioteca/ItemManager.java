package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;

abstract public class ItemManager {

    private HashMap<Item, Boolean> items;
    private HashMap<String, Item> itemIndex;

    public ItemManager(HashMap<Item, Boolean> items) {
        this.items = items;

        itemIndex = new HashMap<String, Item>();
        for (Item item : items.keySet()) {
            itemIndex.put(item.getName(), item);
        }
    }

    public ArrayList<Item> getItemList() {
        ArrayList<Item> itemsList = new ArrayList<Item>();
        for(Item item : items.keySet()) {
            if(isAvailable(item))
                itemsList.add(item);
        }
        return itemsList;
    }

    public boolean checkOut(Item item) {
        if(isAvailable(item)) {
            items.put(item, false);
            return true;
        }
        return false;
    }

    public boolean returnItem(Item item) {
        if(isCheckedout(item)) {
            items.put(item, true);
            return true;
        }
        return false;
    }

    public Item getItemByName(String itemName) {
        return itemIndex.get(itemName);
    }

    public boolean isAvailable(Item item) {
        return items.containsKey(item) ? items.get(item) : false;
    }

    public boolean isCheckedout(Item item) {
        return items.containsKey(item) ? !items.get(item) : false;
    }

    abstract public String getHeaders();
    abstract public String itemType();
}
