package com.twu.biblioteca;

import junit.framework.TestCase;
import org.junit.Test;

import java.io.ByteArrayInputStream;

public class InputManagerTest extends TestCase {

    @Test
    public void testGetBookNameMethod() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("Head First Java".getBytes());
        assertEquals("Head First Java", InputManager.getBookName(inputStream));
    }

}