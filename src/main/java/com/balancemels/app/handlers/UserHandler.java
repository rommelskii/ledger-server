package com.balancemels.app.handlers;

import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class UserHandler implements HttpHandler {
    @Override public void handle(HttpExchange exchange) throws IOException  {
        String method = exchange.getRequestMethod();
        String response;
        switch(method) {
            case "GET":
                response = "GET request detected";
                break;
            case "POST":
                response = "POST request detected";
                break;
            default:
                response = "Error: invalid method detected";
                exchange.sendResponseHeaders(405, response.length());
                break;
        }
        exchange.sendResponseHeaders(200, response.length());
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(response.getBytes());
        }
    } 
}
