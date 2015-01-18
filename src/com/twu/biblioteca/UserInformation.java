package com.twu.biblioteca;

public class UserInformation extends MenuItem{
    @Override
    public void select() {
        if(!LoginManager.validateSession())
            return;
        User currentUser = LoginManager.getCurrentUser();
        IOManager.printUserDetails(currentUser);
    }
}
