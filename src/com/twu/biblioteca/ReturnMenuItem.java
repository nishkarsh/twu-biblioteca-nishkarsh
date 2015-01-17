package com.twu.biblioteca;

public class ReturnMenuItem extends MenuItemSelector {

    private ItemManager itemManager;

    public ReturnMenuItem(ItemManager itemManager) {
        this.itemManager = itemManager;
    }

    @Override
    public void select() {
        String itemName = IOManager.getItemName();
        Item item = itemManager.getCheckedOutItemByName(itemName);
        boolean err = itemManager.returnItem(item);
        IOManager.displayReturnMessage(err);
    }
}
