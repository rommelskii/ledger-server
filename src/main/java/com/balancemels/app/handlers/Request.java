package com.balancemels.app.handlers;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;

import com.balancemels.app.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Request {
	private static final HttpClient client = HttpClient.newBuilder()
		.version(HttpClient.Version.HTTP_2)
		.connectTimeout(Duration.ofSeconds(5))
		.build();

	public static User getUser(String uri, String username) throws Exception {
		String final_uri = uri + "?username=" + username;
		//User u = new User();
		ObjectMapper mapper = new ObjectMapper();
		HttpRequest request = HttpRequest.newBuilder()
			.uri(URI.create(final_uri))
			.GET()
			.header("Accept", "application/json")
			.build();

		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		String body = response.body();

		if (body.isEmpty()) {
			throw new RuntimeException("Error: GET request body must not be empty");
		}
		System.out.println("REQUEST: received body " + body);   // logging purposes

		List<User> userList = mapper.readValue(body, 
			new TypeReference<List<User>>() {} // this is a reference to the List object
		);
		User u = userList.get(0);
		System.out.println("REQUEST: built user (" + u.getUsername() + ", " + u.getPassword() + ", " + u.getRunningBalance() + ")");

		return u;
	}

	public static void createUser(String uri, User u) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		String requestBody = mapper.writeValueAsString(u);

		HttpRequest request = HttpRequest.newBuilder()
			.uri(URI.create(uri))
			.POST(HttpRequest.BodyPublishers.ofString(requestBody))
			.header("Accept", "application/json")
			.build();

		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		String body = response.body();

        System.out.println("REQUEST: POST received body " + body);
	}
}
