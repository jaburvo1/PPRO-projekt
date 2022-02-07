package com.example.pproprojekt.service;

import com.example.pproprojekt.entity.Employee;
import com.example.pproprojekt.repozitory.EmploeeyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Login {
    private int idUser;
    private int role;
    private String userEmail;
    private String password;
    private Employee employee;
    @Autowired
    private EmploeeyRepository emploeeyRepo;

   // private EntityManager entityManager;
    private List<Employee> listEmployee;


    public Login(String userEmail, String password) {
        this.userEmail = userEmail;
        this.password = password;



    }

    public Login() {
    }


    public Employee login(String email, String password) {
        listEmployee = new ArrayList<>();
        ///this.employee=null;
        Employee employeePom=null;
        listEmployee = emploeeyRepo.findByEmailAndPassword(email, password);
        for (Employee em: listEmployee) {
            if ((email.equals(em.getEmail())) && (password.equals(em.getPassword()))) {
                employeePom = em;
            }
        }
        return employeePom;
    }
}


