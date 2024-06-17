package com.mybank.model;

import java.time.LocalDateTime;

public class Transaction {
    private User user;
    private String id;
    private String amount;
    private LocalDateTime timeStamp;
    private String reference;

    public Transaction(User user, String id, String amount, String reference) {
        this.user = user;
        this.id = id;
        this.amount = amount;
        this.timeStamp = LocalDateTime.now();
        this.reference = reference;
    }
}
