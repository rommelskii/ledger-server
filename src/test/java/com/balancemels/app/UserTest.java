package com.balancemels.app;

import junit.framework.TestCase;
import junit.framework.TestSuite;

public class UserTest extends TestCase {
    public UserTest(String testName) {
        super(testName);
    } 

    protected void setup() throws Exception {
        super.setUp();
    }

    //Test cases
    public void testUserInitialization() {
        User u = new User.Builder().build();
        assertNotNull("Tests if an uninitialized User object is not null", u);
    }

    public void testUsername() {
        String USERNAME = "123bonglefoobar!@#";
        User u = new User.Builder().setUsername(USERNAME).build();
        assertEquals("Tests if a set user's username is the same as the one set", u.getUsername(), USERNAME);
    }

    public void testPassword() {
        String PASSWORD = "123bonglefoobar!@#";
        User u = new User.Builder().setPassword(PASSWORD).build();
        assertEquals("Tests if a set user's password is the same as the one set", u.getPassword(), PASSWORD);
    }


    public void overallUserInitialization() {
        String USERNAME = "123FooBarBongle!@#";
        String PASSWORD = "P@ssw0rd$$";
        double RUNNING_BALANCE = 192168.200148;

        User u = new User.Builder()
                                .setUsername(USERNAME)
                                .setPassword(PASSWORD)
                                .build();

        assertEquals(u.getUsername(), USERNAME);
        assertEquals(u.getPassword(), PASSWORD);
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public static junit.framework.Test suite() {
        return new TestSuite(UserTest.class);
    }
}
