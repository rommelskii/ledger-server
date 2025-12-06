package com.balancemels.app;

public class Deposit extends Transaction {
    public Deposit(Builder builder) {
        this.username = builder.username;
        this.source = builder.source;
        this.amount = builder.amount;
    }

    public static class Builder {
        private String username;
        private String source;
        private double amount;

        public Builder() {}

        public Builder setAmount(double amount) {
            if (amount <= 0) {
                throw new IllegalArgumentException(
                    "Transaction error: expected negative withdrawal amount"
                );
            }
            return this;
        }

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setSource(String source) {
            this.source = source;
            return this;
        }
        
        public Deposit build() {
            return new Deposit(this);
        }
    }
}