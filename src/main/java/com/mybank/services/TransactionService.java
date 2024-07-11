package com.mybank.services;

import com.mybank.model.Transaction;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class TransactionService {

    private final UserService userService;
    private final List<Transaction> transactions = new CopyOnWriteArrayList<>();
    private final String slogan;

    public TransactionService(UserService userService, @Value("${bank.slogan}") String slogan){
        this.userService = userService;
        this.slogan = slogan;
    }

    public void create(Transaction transaction){
        this.transactions.add(transaction);
    }

    public List<Transaction> listAll(){
        return this.transactions;
    }

    public String getSlogan() {
        return this.slogan;
    }
}
