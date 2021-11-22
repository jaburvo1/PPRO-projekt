package com.example.pproprojekt.entity;

import ch.qos.logback.core.joran.action.Action;
import ch.qos.logback.core.joran.spi.ActionException;
import ch.qos.logback.core.joran.spi.InterpretationContext;
import org.springframework.stereotype.Service;
import org.xml.sax.Attributes;

@Service
public class Login extends Action {
    private int idUser;
    private int role;

    public Login(){
        System.out.println("ok");

    }

    @Override
    public void begin(InterpretationContext interpretationContext, String s, Attributes attributes) throws ActionException {

    }

    @Override
    public void end(InterpretationContext interpretationContext, String s) throws ActionException {

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
