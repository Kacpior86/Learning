package com.mybank.services;

import com.mybank.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class UserService {

    private final List<User> users = new CopyOnWriteArrayList<>();

    public User findById(String id){
        for (User user : users) {
            if (user.getId().equalsIgnoreCase(id)) {
                return user;
            }
        }
        return null;
    }

    public User findByName(String name){
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(name)) {
                return user;
            }
        }
        return null;
    }

    public void create(String name){
        users.add(new User(name));
    }

    public List<User> listAll(){
        return this.users;
    }
}
