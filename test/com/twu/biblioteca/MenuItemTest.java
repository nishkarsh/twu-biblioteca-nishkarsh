package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


@PrepareForTest(LoginManager.class)
@RunWith(PowerMockRunner.class)

public class MenuItemTest {

    ItemManager bookManager;
    ItemManager movieManager;
    MenuItemsMap itemsMap;


    @Before
    public void setUp() {
        PowerMockito.mockStatic(LoginManager.class);
        PowerMockito.when(LoginManager.validateSession()).thenReturn(true);

        Book headFirstJava = new Book("Head First Java", "Bert Bates, Kathy Sierra", "January 1, 2004");
        Book myStory = new Book("My Story", "Nishkarsh Sharma", "January 30, 2006");
        HashMap<Item, Boolean> bookList= new HashMap<Item, Boolean>();
        bookList.put(headFirstJava, true);
        bookList.put(myStory, true);
        bookManager = new BookManager(bookList);

        HashMap<Integer, MenuItem> menuItemsMap = new HashMap<Integer, MenuItem>();
        menuItemsMap.put(1, new ListMenuItem(bookManager));
        menuItemsMap.put(2, new CheckoutMenuItem(bookManager));
        menuItemsMap.put(3, new ReturnMenuItem(bookManager));
        menuItemsMap.put(4, new ListMenuItem(movieManager));
        menuItemsMap.put(5, new CheckoutMenuItem(movieManager));
        menuItemsMap.put(6, new ReturnMenuItem(movieManager));
        menuItemsMap.put(7, new UserInformationMenuItem());
        menuItemsMap.put(8, new QuitMenuItem());
        itemsMap = new MenuItemsMap(menuItemsMap);
}

    @Test
    public void checkIfValidOption() {
        HashMap<Integer, MenuItem> menuItemsMap = new HashMap<Integer, MenuItem>();
        menuItemsMap.put(1, new ListMenuItem(bookManager));
        MenuItemsMap itemsMap = new MenuItemsMap(menuItemsMap);

        assertTrue(itemsMap.isValid(1));
    }

    @Test
    public void checkIfInvalidOption() {
        HashMap<Integer, MenuItem> menuItemsMap = new HashMap<Integer, MenuItem>();
        MenuItemsMap itemsMap = new MenuItemsMap(menuItemsMap);

        assertFalse(itemsMap.isValid(1));
    }

    @Test
    public void testListBookMenuItemForInvalidEntries() {
        IOManager.setInputStream(new ByteArrayInputStream("My Story".getBytes()));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        IOManager.setPrintStream(new PrintStream(outputStream));
        itemsMap.getMenuItem(2).select();
        itemsMap.getMenuItem(1).select();
        assertTrue(outputStream.toString().contains("Head First Java"));
        assertFalse(outputStream.toString().contains("My Story"));
    }

    @Test
    public void testListBookMenuItem() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        IOManager.setPrintStream(new PrintStream(outputStream));
        itemsMap.getMenuItem(1).select();
        assertTrue(outputStream.toString().contains("Head First Java"));
        assertTrue(outputStream.toString().contains("My Story"));
    }

    @Test
    public void testCheckoutMenuItemAgainstAvailableBook() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        IOManager.setInputStream(new ByteArrayInputStream("Head First Java".getBytes()));
        IOManager.setPrintStream(new PrintStream(outputStream));
        itemsMap.getMenuItem(2).select();
        assertThat(outputStream.toString(), is("Enter the name: \n" +
                "Thank you! Enjoy the Book\n"));
    }

    @Test
    public void testCheckoutMenuItemAgainstNotAvailableBook() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        IOManager.setInputStream(new ByteArrayInputStream("Random Book".getBytes()));
        IOManager.setPrintStream(new PrintStream(outputStream));
        itemsMap.getMenuItem(2).select();
        assertThat(outputStream.toString(), is("Enter the name: \n" +
                "That Book is not available.\n"));
    }

    @Test
    public void testReturnMenuItemForCheckedOutBook() {
        IOManager.setInputStream(new ByteArrayInputStream("Head First Java".getBytes()));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        IOManager.setPrintStream(new PrintStream(outputStream));
        itemsMap.getMenuItem(2).select();
        IOManager.setInputStream(new ByteArrayInputStream("Head First Java".getBytes()));
        itemsMap.getMenuItem(3).select();
        assertThat(outputStream.toString(), is("Enter the name: \n" +
                "Thank you! Enjoy the Book\n" +
                "Enter the name: \n" +
                "Thank you for returning the Book\n"));
    }

    @Test
    public void testReturnMenuItemForInvalidBook() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        IOManager.setInputStream(new ByteArrayInputStream("Random Book".getBytes()));
        IOManager.setPrintStream(new PrintStream(outputStream));
        itemsMap.getMenuItem(3).select();
        assertThat(outputStream.toString(), is("Enter the name: \n" +
                "That is not a valid Book to return.\n"));
    }

    @Test
    public void testUserInformationMenuItem() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        IOManager.setPrintStream(new PrintStream(outputStream));
        PowerMockito.when(LoginManager.getCurrentUser()).thenReturn(new User("123-4567","something","Nishkarsh Sharma", "nishkarsh4@gmail.com", "95445655244"));
        itemsMap.getMenuItem(7).select();
        assertTrue(outputStream.toString().contains("Nishkarsh"));
    }
}
