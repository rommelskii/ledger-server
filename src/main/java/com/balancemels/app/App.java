package com.balancemels.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.balancemels.app.handlers.Request;

public class App 
{
    public static void main( String[] args ) {
        try {
            User u = Request.getUser("http://localhost:3000/pos_users", "manager_beta");
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
