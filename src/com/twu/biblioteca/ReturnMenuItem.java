package com.twu.biblioteca;

public class ReturnMenuItem extends MenuItem {

    private ItemManager itemManager;

    public ReturnMenuItem(ItemManager itemManager) {
        this.itemManager = itemManager;
    }

    @Override
    public void select() {
        if(!LoginManager.validateSession())
            return;
        String itemName = IOManager.getItemName();
        Item item = itemManager.getItemByName(itemName);
        boolean returnSuccess = itemManager.returnItem(item);
        IOManager.displayReturnMessage(returnSuccess, itemManager.itemType());
    }
}
