package com.example.pproprojekt.service;

import com.example.pproprojekt.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.pproprojekt.repozitory.EmploeeyRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class Admin {



    private Employee employee = new Employee();
    private List<Employee> listEmployee;
    @Autowired
    private EmploeeyRepository emploeeyRepo;


    public Admin(EmploeeyRepository emploeeyRepo) {
        this.emploeeyRepo = emploeeyRepo;
    }

    public Object addUser(String userName, String firstName, String lastName, String telefon, String email, String password, int newRole) {

        System.out.println("login:"+userName+"email: "+email);
        //uložení do db
        Employee pomEmployee = findUserByEmail(email);
        if(pomEmployee==null)
        {
            employee = new Employee(userName, firstName,lastName,telefon,email,password,newRole);
            emploeeyRepo.save(employee);
        }
        else {
            System.out.println("email už je v databázi");
        }


        return employee;
    }

    public Employee findUserByEmail(String email){
        listEmployee=new ArrayList<>();
        listEmployee = emploeeyRepo.findAll();
        Employee employee=null;


        for(Employee em: listEmployee){
            if(em.getEmail().equals(email)){
                System.out.println(em.getUserName());
            employee=em;

            }
        }
        return employee;
    }

    public Object editUserRole(String email, int newRole) {

        System.out.println("login: "+email+"role: "+newRole);

        employee = findUserByEmail(email);
        System.out.println(employee.getUserName());
        if(employee!=null) {
            //emploeeyRepo.delete(employee);
            employee.setRole(newRole);
            emploeeyRepo.save(employee);//aktualizae user

        }
        else {
            System.out.println("chybne user name");
        }
        return employee;
    }

    public Object editPassword(String email, String password) {


        employee = findUserByEmail(email);
        System.out.println(employee.getUserName());
        if(employee!=null) {
            //emploeeyRepo.delete(employee);
            employee.setPassword(password);
            emploeeyRepo.save(employee);//aktualizae user

        }
        else {
            System.out.println("chybne user name");
        }
        return employee;
    }

    public List<Employee> findAll() {
        listEmployee =new ArrayList<>();
        listEmployee = emploeeyRepo.findAll();
        return listEmployee;
    }
}