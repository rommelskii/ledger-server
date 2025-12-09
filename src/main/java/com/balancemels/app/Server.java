package com.balancemels.app;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.balancemels.app.handlers.UserHandler;
import com.sun.net.httpserver.HttpServer;

public class Server {
    public void start(int port) throws IOException
    {
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        
        //begin routing table
        server.createContext("/api/users", new UserHandler());

        server.start();
        System.out.println("Server started on port: " + port);
    }
}
