package com.mybank.services;

import com.mybank.model.Transaction;

import java.util.ArrayList;

public class TransactionService {

    private final UserService userService;
    private final ArrayList<Transaction> transactions = new ArrayList<>();

    public TransactionService(UserService userService){
        this.userService = userService;
    }

    public void create(Transaction transaction){
        this.transactions.add(transaction);
    }

    public String listAll(){
        return this.transactions.toString();
    }
}
