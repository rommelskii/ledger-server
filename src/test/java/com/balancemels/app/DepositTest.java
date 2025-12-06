package com.balancemels.app;

import junit.framework.TestCase;
import junit.framework.TestSuite;

public class DepositTest extends TestCase {
    public DepositTest(String testName) {
        super(testName);
    }

    protected void setup() throws Exception {
        super.setUp();
    }

    public void testDepositInitialization() {
        assertNotNull(
            new Deposit.Builder()
                    .build()
        );
    }

    public void testValidAmount() {
        double testDouble = 220.0;

        Deposit d = new Deposit.Builder()
                    .setAmount(testDouble)
                    .build();
        
        assertEquals(d.getAmount(), testDouble);
    }

    public void testInvalidAmount() {
        double testDouble = -220.0;
        
        try {
            Deposit d = new Deposit.Builder()
                        .setAmount(testDouble)
                        .build();
            
            fail("Expected IllegalArgumentException. Received none.");
        } catch (IllegalArgumentException e) {
            assertTrue("Exception message should contain amount context.",
                    e.getMessage().contains("negative"));
        }
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public static junit.framework.Test suite() {
        return new TestSuite(DepositTest.class);
    }
}
