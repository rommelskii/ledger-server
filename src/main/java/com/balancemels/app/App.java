package com.balancemels.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.balancemels.app.handlers.Request;

public class App 
{
    public static void main( String[] args ) {
        try {
            User u = Request.getUser("http://localhost:8000/api/users");
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
