package com.balancemels.app;

import java.io.IOException;
import com.balancemels.app.handlers.UserHandler;

public class App 
{
    public static void main( String[] args )
    {
        Server s = new Server();

        try {
            s.start(8080);
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
