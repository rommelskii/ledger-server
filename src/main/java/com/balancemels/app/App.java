package com.balancemels.app;

import com.balancemels.app.handlers.Request;

public class App 
{
    public static void main( String[] args ) {
        /*
         * try {
         * User u = Request.getUser("http://localhost:3000/pos_users", "manager_beta");
         * } catch (Exception e) {
         * System.err.println(e);
         * }
         */
        User u = new User.Builder().setUsername("rommel")
                        .setPassword("Password")
                        .setRunningBalance(212.331)
                        .build();

        try {
            Request.createUser("http://localhost:3000/pos_users", u);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
