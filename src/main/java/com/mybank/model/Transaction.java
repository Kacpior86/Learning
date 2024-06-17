package com.mybank.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Transaction {
    private User user;
    private String id;
    private String amount;
    private LocalDateTime timeStamp;
    private String reference;

    public Transaction(User user, String amount, String reference) {
        this.user = user;
        this.id = UUID.randomUUID().toString();
        this.amount = amount;
        this.timeStamp = LocalDateTime.now();
        this.reference = reference;
    }
}
