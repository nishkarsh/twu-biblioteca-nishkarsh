package com.twu.biblioteca;

public class CheckoutMenuItem extends MenuItemSelector{

    private ItemManager itemManager;

    public CheckoutMenuItem(ItemManager itemManager) {
        this.itemManager = itemManager;
    }

    @Override
    public void select() {
        String itemName = IOManager.getItemName();
        Item item = itemManager.getAvailableItemByName(itemName);
        boolean err=itemManager.checkOut(item);
        IOManager.displayCheckoutMessage(err);
    }
}
