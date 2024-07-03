package com.mybank.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mybank.context.myBankConfiguration;
import com.mybank.model.Transaction;
import com.mybank.model.User;
import com.mybank.services.TransactionService;
import com.mybank.services.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.util.List;

public class myBankAppServlet extends HttpServlet {

    private UserService userService;
    private TransactionService transactionService;
    private ObjectMapper objectMapper;

    @Override
    public void init() throws ServletException{
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(myBankConfiguration.class);

        this.userService = ctx.getBean(UserService.class);
        this.transactionService = ctx.getBean(TransactionService.class);
        this.objectMapper = ctx.getBean(ObjectMapper.class);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        if (request.getRequestURI().equalsIgnoreCase("/users")){
            if (request.getParameter("create").equals("1")){
                String name = request.getParameter("name");
                userService.create(name);

                response.setContentType("application/json; charset=UTF-8");
                List<User> users = userService.listAll();
                response.getWriter().print(objectMapper.writeValueAsString(users));
            }
        }
        else if(request.getRequestURI().equalsIgnoreCase("/transactions")){
            if (request.getParameter("create").equals("1")){
                String amount = request.getParameter("amount");
                String userName = request.getParameter("user_name");
                String reference = request.getParameter("reference");
                transactionService.create(new Transaction(userService.findByName(userName), amount, reference, transactionService.getSlogan()));

                response.setContentType("application/json; charset=UTF-8");
                List<Transaction> transactions = transactionService.listAll();
                response.getWriter().print(objectMapper.writeValueAsString(transactions));
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
    if (request.getRequestURI().equalsIgnoreCase("/users")){
        response.setContentType("application/json; charset=UTF-8");
        List users = userService.listAll();
        response.getWriter().print(objectMapper.writeValueAsString(users));
    }
    else if (request.getRequestURI().equalsIgnoreCase("/transactions")){
        response.setContentType("application/json; charset=UTF-8");
        List transactions = transactionService.listAll();
        response.getWriter().print(objectMapper.writeValueAsString(transactions));
    }
    else if(request.getRequestURI().equalsIgnoreCase("/")){
        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().print(
                "<html>\n" +
                        "<body>\n" +
                        "<h1>Welcome in The Best myBankApp <b>!!!</b></h1>\n" +
                        "</body>\n" +
                        "</html>");
    }
    }
}
