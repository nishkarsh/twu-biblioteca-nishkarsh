package com.twu.biblioteca;

public class UserInformationMenuItem extends MenuItem{
    @Override
    public void select() {
        if(!LoginManager.validateSession())
            return;
        User currentUser = LoginManager.getCurrentUser();
        IOManager.printUserDetails(currentUser);
    }
}
