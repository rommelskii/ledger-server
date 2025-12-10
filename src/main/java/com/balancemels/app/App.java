package com.balancemels.app;

import com.fasterxml.jackson.databind.ObjectMapper;

public class App 
{
    public static void main( String[] args ) {
        ObjectMapper mapper = new ObjectMapper();
        User u = new User();
        String json = """
        {
        "username": "balancemels",
        "password": "Passw0rd$$",
        "running_balance": "220.12321"
        }
        """; 
        try {
            u = mapper.readValue(json, User.class);
        } catch (Exception e) {
            System.err.println(e);
        }

        System.out.println(u.getPassword() + " " + u.getUsername() + " " + u.getRunningBalance());

        System.out.println("Done");
    }
}
