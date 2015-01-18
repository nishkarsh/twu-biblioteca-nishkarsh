package com.twu.biblioteca;

public class CheckoutMenuItem extends MenuItem {

    private ItemManager itemManager;

    public CheckoutMenuItem(ItemManager itemManager) {
        this.itemManager = itemManager;
    }

    @Override
    public void select() {
        if(!LoginManager.validateSession())
            return;
        String itemName = IOManager.getItemName();
        Item item = itemManager.getItemByName(itemName);
        boolean checkoutSuccess = itemManager.checkOut(item);
        IOManager.displayCheckoutMessage(checkoutSuccess, itemManager.itemType());
    }
}
