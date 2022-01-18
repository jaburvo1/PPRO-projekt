package com.example.pproprojekt.service;

import com.example.pproprojekt.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.pproprojekt.repozitory.EmploeeyRepository;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.Persistence.createEntityManagerFactory;

@Service
public class Login {
    private int idUser;
    private int role;
    private String userEmail;
    private String password;
    private Employee employee;
    @Autowired
    private EmploeeyRepository emploeeyRepo;

    private EntityManager entityManager;
    private List<Employee> listEmployee;


    public Login(String userEmail, String password) {
        this.userEmail = userEmail;
        this.password = password;



    }

    public Login() {
    }


    public Employee login(String email, String password) {
        listEmployee = new ArrayList<>();
        listEmployee = emploeeyRepo.findByEmailAndPassword(email, password);
        for (Employee em: listEmployee) {
            if ((email.equals(em.getEmail())) && (password.equals(em.getPassword()))) {
                employee = em;
            } else {
                System.out.println("chyne prihalsovaci udaje");
            }
        }
        return employee;
    }
}


