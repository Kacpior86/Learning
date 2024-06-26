package com.mybank.services;

import com.mybank.model.Transaction;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TransactionService {

    private final UserService userService;
    private final List<Transaction> transactions = new CopyOnWriteArrayList<>();

    public TransactionService(UserService userService){
        this.userService = userService;
    }

    public void create(Transaction transaction){
        this.transactions.add(transaction);
    }

    public List listAll(){
        return this.transactions;
    }
}
