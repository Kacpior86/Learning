package com.mybank.services;

import com.mybank.model.User;

import java.util.ArrayList;

public class UserService {

    private final ArrayList<User> users = new ArrayList<>();

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

    public ArrayList<User> listAll(){
        return this.users;
    }
}
