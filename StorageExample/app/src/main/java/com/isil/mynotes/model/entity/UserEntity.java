package com.isil.mynotes.model.entity;

import java.io.Serializable;

/**
 * Created by eduardomedina on 19/10/16.
 */
public class UserEntity implements Serializable {

    private int id;
    private String email;
    private String password;

    public UserEntity(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public UserEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
