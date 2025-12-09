package com.balancemels.app;

import junit.framework.TestCase;
import junit.framework.TestSuite;

public class WithdrawTest extends TestCase {
    public WithdrawTest(String testName) {
        super(testName);
    }

    protected void setup() throws Exception {
        super.setUp();
    }

    public void testWithdrawalInitialization() {
        assertNotNull(
            new Withdrawal.Builder()
                    .build()
        );
    }

    public void testValidAmount() {
        double testDouble = -220.0;

        Withdrawal w = new Withdrawal.Builder()
                    .setAmount(testDouble)
                    .build();
        
        assertEquals(w.getAmount(), testDouble);
    }

    public void testInvalidAmount() {
        double testDouble = 220.0;
        
        try {
            Withdrawal w = new Withdrawal.Builder()
                        .setAmount(testDouble)
                        .build();
            
            fail("Expected IllegalArgumentException. Received none.");
        } catch (IllegalArgumentException e) {
            assertTrue("Exception message should contain amount context.",
                    e.getMessage().contains("positive"));
        }
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public static junit.framework.Test suite() {
        return new TestSuite(WithdrawTest.class);
    }
}
