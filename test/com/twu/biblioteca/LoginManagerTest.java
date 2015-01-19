package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.HashMap;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@PrepareForTest(IOManager.class)
@RunWith(PowerMockRunner.class)

public class LoginManagerTest {

    @Before
    public void setUp() {
        User nishkarsh = new User("537-1253", "something", "Nishkarsh Sharma", "nishkarsh4@gmail.com", "9545655244");
        HashMap<String, User> userList = new HashMap<String, User>();
        userList.put(nishkarsh.getLibraryNumber(), nishkarsh);
        LoginManager.initialize(userList);
        PowerMockito.mockStatic(IOManager.class);
    }

    @Test
    public void testIfUserLoginSuccessful() {
        PowerMockito.when(IOManager.getLibraryNumber()).thenReturn("537-1253");
        PowerMockito.when(IOManager.getPassword()).thenReturn("something");

        assertTrue(LoginManager.userLogin());
    }

    @Test
    public void testIfUserLoginUnsuccessful() {
        PowerMockito.when(IOManager.getLibraryNumber()).thenReturn("537-1253");
        PowerMockito.when(IOManager.getPassword()).thenReturn("somethingElse");

        assertFalse(LoginManager.userLogin());
    }

    @Test
    public void testValidateSessionReturnsFalseIfNotLoggedIn() {
        assertFalse(LoginManager.validateSession());
    }

    @Test
    public void testValidateSessionReturnsTrueIfLoggedIn() {
        PowerMockito.when(IOManager.getLibraryNumber()).thenReturn("537-1253");
        PowerMockito.when(IOManager.getPassword()).thenReturn("something");
        LoginManager.userLogin();

        assertTrue(LoginManager.validateSession());
    }
}
