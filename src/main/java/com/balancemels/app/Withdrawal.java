package com.balancemels.app;

public class Withdrawal extends Transaction {
    public Withdrawal(Builder builder) {
        this.username = builder.username;
        this.source = builder.source;
        this.amount = builder.amount;
    }

    public static class Builder {
        private String username = "";
        private String source = "";
        private double amount = 0;

        public Builder() {}

        public Builder setAmount(double amount) {
            if (amount >= 0) {
                throw new IllegalArgumentException(
                    "Transaction error: expected positive withdrawal amount"
                );
            }
            this.amount = amount;
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
        
        public Withdrawal build() {
            return new Withdrawal(this);
        }
    }
}