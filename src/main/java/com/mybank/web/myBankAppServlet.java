package com.mybank.web;

import com.mybank.context.Application;
import com.mybank.model.Transaction;
import com.mybank.model.User;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class myBankAppServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        if (request.getRequestURI().equalsIgnoreCase("/users")){
            if (request.getParameter("create").equals("1")){
                String name = request.getParameter("name");
                Application.userService.create(name);

                response.setContentType("application/json; charset=UTF-8");
                List<User> users = Application.userService.listAll();
                response.getWriter().print(Application.objectMapper.writeValueAsString(users));
            }
        }
        else if(request.getRequestURI().equalsIgnoreCase("/transactions")){
            if (request.getParameter("create").equals("1")){
                String amount = request.getParameter("amount");
                String userName = request.getParameter("user_name");
                String reference = request.getParameter("reference");
                Application.transactionService.create(new Transaction(Application.userService.findByName(userName), amount, reference));

                response.setContentType("application/json; charset=UTF-8");
                List<Transaction> transactions = Application.transactionService.listAll();
                response.getWriter().print(Application.objectMapper.writeValueAsString(transactions));
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
    if (request.getRequestURI().equalsIgnoreCase("/users")){
        response.setContentType("application/json; charset=UTF-8");
        List users = Application.userService.listAll();
        response.getWriter().print(Application.objectMapper.writeValueAsString(users));
    }
    else if (request.getRequestURI().equalsIgnoreCase("/transactions")){
        response.setContentType("application/json; charset=UTF-8");
        List transactions = Application.transactionService.listAll();
        response.getWriter().print(Application.objectMapper.writeValueAsString(transactions));
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
