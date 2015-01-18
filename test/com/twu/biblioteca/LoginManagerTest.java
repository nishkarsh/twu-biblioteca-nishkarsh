package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class LoginManagerTest {

    @Before
    public void setUp() {
        User nishkarsh = new User("537-1253", "something", "Nishkarsh Sharma", "nishkarsh4@gmail.com", "9545655244");
        User amit = new User("123-4567", "everything", "Amit Singh", "amit55@gmail.com", "9123456775");
        HashMap<String, User> userList = new HashMap<String, User>();
        userList.put(nishkarsh.getLibraryNumber(), nishkarsh);
        userList.put(amit.getLibraryNumber(), amit);
        LoginManager.initialize(userList);
    }

//    @Test
//    public void testIfLoginUnsuccessful() {
//        assertFalse(LoginManager.validateSession());
//    }
//
//    @Test
//    public void testIfLoginSuccessful() {
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        IOManager.setInputStream(new ByteArrayInputStream("537-1253\nsomething".getBytes()));
//        IOManager.setPrintStream(new PrintStream(outputStream));
//        assertTrue(LoginManager.validateSession());
//    }

}
