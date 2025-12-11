package com.balancemels.app.handlers;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.time.Duration;

import com.balancemels.app.User;

public class Request {
  private static final HttpClient client = HttpClient.newBuilder()
                                                .version(HttpClient.Version.HTTP_2)
                                                .connectTimeout(Duration.ofSeconds(5))
                                                .build();
              
  public static User getUser(String uri) throws Exception {
    User u = new User();
    ObjectMapper mapper = new ObjectMapper();
    HttpRequest request = HttpRequest.newBuilder()
                              .uri(URI.create(uri))
                              .GET()
                              .build();

    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    String body = response.body();

    if (body.isEmpty()) {
      throw new RuntimeException("Error: GET request body must not be empty");
    }
    System.out.println("REQUEST: received body " + body);   // logging purposes
    
    u = mapper.readValue(body, User.class);
    System.out.println("REQUEST: built user (" + u.getUsername() + ", " + u.getPassword() + ", " + u.getRunningBalance() + ")");

    return u;
  }
}
