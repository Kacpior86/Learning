package com.mybank.context;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mybank.services.TransactionService;
import com.mybank.services.UserService;


public class Application {
    public static final UserService userService = new UserService();
    public static final TransactionService transactionService = new TransactionService(userService);
    public static final ObjectMapper objectMapper = new ObjectMapper();
}
