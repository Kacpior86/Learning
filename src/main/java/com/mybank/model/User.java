package com.mybank.model;

import java.util.UUID;

public class User {
    private String id;
    private String Name;

    public User(String name) {
        this.id = UUID.randomUUID().toString();
        Name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
