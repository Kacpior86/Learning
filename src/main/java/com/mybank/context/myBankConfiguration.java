package com.mybank.context;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mybank.services.TransactionService;
import com.mybank.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class myBankConfiguration {
    @Bean
    public UserService userService() {
        return new UserService();
    }

    @Bean
    public TransactionService transactionService(UserService userService){
        return new TransactionService(userService);
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
