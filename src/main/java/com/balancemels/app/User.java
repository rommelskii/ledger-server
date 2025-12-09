package com.balancemels.app;

public class User implements Transactable, Responsive {
	private String username;
	private String password;
	private double running_balance;

	public User (Builder builder) {
		this.username = builder.username;
		this.password = builder.password;
		this.running_balance = builder.running_balance;
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

	public double getRunningBalance() {
		return this.running_balance;
	}

	public static class Builder {
		private String username;
		private String password;
		private double running_balance;

		public Builder() {};

		public Builder setUsername(String username) {
			this.username = username;
			return this;
		}

		public Builder setPassword(String password) {
			this.password = password;
			return this;
		}

		public Builder setRunningBalance(double running_balance) {
			this.running_balance = running_balance;
			return this;
		}

		public User build() {
			return new User(this);
		}
	}
}
