package com.balancemels.app;

public abstract class Transaction implements Transactable {  
    protected String username;
    protected String source;
    protected double amount;

    public void ForwardRequest() {}

    public String getUsername() {
        return this.username;
    }

    public String getSource() {
        return this.source;
    }

    public double getAmount() {
        return this.amount;
    }
}

