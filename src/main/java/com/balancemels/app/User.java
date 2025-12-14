package com.balancemels.app;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements Transactable, Responsive {
	// testing write up 
	@JsonProperty("username")
	private String username;
	@JsonProperty("password")
	private String password;

	public User () {}

	public User (Builder builder) {
		this.username = builder.username;
		this.password = builder.password;
	}

	@Override 
	public void ForwardRequest() {
		// TODO Auto-generated method stub
	}
	
	@Override 
	public void ReturnToClient() {
		// TODO Auto-generated method stub
	}

	public String getUsername() {
		return this.username;
	}

	public String getPassword() {
		return this.password;
	}

	public static class Builder {
		private String username;
		private String password;

		public Builder() {};

		public Builder setUsername(String username) {
			this.username = username;
			return this;
		}

		public Builder setPassword(String password) {
			this.password = password;
			return this;
		}

		public User build() {
			return new User(this);
		}
	}
}
