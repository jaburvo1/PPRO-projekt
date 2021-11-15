package com.example.pproprojekt.entity;

import org.springframework.stereotype.Service;

@Service
public class Login {
    private int idUser;
    private int role;

    public Login(){

    }

    public void login(String email, String pssword) {


    }

    public int getUserID() {
        return idUser;
    }

    public int getRole() {
        return role;
    }
}
