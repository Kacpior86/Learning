package com.mybank.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Transaction {
    private User user;
    private String id;
    private String amount;
    private String timeStamp;
    private String reference;

    public Transaction(User user, String amount, String reference) {
        this.user = user;
        this.id = UUID.randomUUID().toString();
        this.amount = amount;
        this.timeStamp = LocalDateTime.now().toString();
        this.reference = reference;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp.toString();
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
