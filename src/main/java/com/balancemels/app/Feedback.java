package com.balancemels.app;

public abstract class Feedback implements Responsive {
    private boolean status = false;

    @Override 
    public void ReturnToClient() {
        //Implementation to be done soon
    }

    public Feedback(boolean status) {
        this.status = status;
    }

    public boolean getStatus(boolean status) {
        return this.status;
    }
}

