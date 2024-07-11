package com.mybank.web;

import com.mybank.model.Transaction;
import com.mybank.model.User;
import com.mybank.services.TransactionService;
import com.mybank.services.UserService;
import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Validated
public class MyBankController {

    private final TransactionService transactionService;
    private UserService userService;

    public MyBankController(TransactionService transactionService, UserService userService) {
        this.transactionService = transactionService;
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> listUsers() {
        return userService.listAll();
    }

    @GetMapping("/transactions")
    public List<Transaction> listTransactions() {
        return transactionService.listAll();
    }

    @GetMapping("/")
    public String welcomeMsg() {
        return "<html>\n" +
                "<body>\n" +
                "<h1>Welcome in The Best myBankApp <b>!!!</b></h1>\n" +
                "</body>\n" +
                "</html>";
    }

    @PostMapping("/users")
    public List<User> createUser(@RequestParam("create") @NotBlank String create, @RequestParam("name") String name) {
        if (create.equalsIgnoreCase("1")) {
            userService.create(name);
        }
        return userService.listAll();
    }

    @PostMapping("/transactions")
    public List<Transaction> createTransaction(@RequestParam("create") @NotBlank String create,
                                               @RequestParam("user_name") String userName,
                                               @RequestParam("amount") String amount,
                                               @RequestParam("reference") String reference) {
        if (create.equalsIgnoreCase("1")) {
            transactionService.create(new Transaction(userService.findByName(userName), amount, reference, transactionService.getSlogan()));
        }
        return transactionService.listAll();
    }
}
