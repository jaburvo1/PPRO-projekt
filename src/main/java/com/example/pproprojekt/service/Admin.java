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

    private Employee findUserByEmail(String email) {
        listEmployee=new ArrayList<>();
        listEmployee = emploeeyRepo.findAll();

        for(Employee em: listEmployee)
            if(em.getEmail().equals(email)){
                return em;
            }

        return null;
    }
    private Employee findUserByUseName(String userName)
    {
        //zde nastava pravděpodobne chby
        listEmployee=new ArrayList<>();
        listEmployee = emploeeyRepo.findAll();

        for(Employee em: listEmployee){
            if(em.getUserName().equals(userName)){
                System.out.println(em.getUserName());

                return em;
            }
            else {
                return null;

            }
        }
        return null;
    }

    public Object editUserRole(String userName, int newRole) {

        System.out.println("login: "+userName+"role: "+newRole);

        employee = findUserByUseName(userName);
        System.out.println(employee.getUserName());
       if(employee!=null) {
           emploeeyRepo.delete(employee);
           employee.setRole(newRole);
           emploeeyRepo.save(employee);//aktualizae user

       }
       else {
           System.out.println("chybne user name");
       }
        return employee;
    }

    public Object editPassword(String userName, String password) {
        System.out.println("login: "+userName+"heslo: "+ password);

        employee = findUserByUseName(userName);
        System.out.println(employee.getUserName());
        if(employee!=null) {
            emploeeyRepo.delete(employee);
            employee.setPassword(password);
            emploeeyRepo.save(employee);
            //aktualizaci user
        }
        else {
            System.out.println("chybne user name");
        }

        return employee;
    }
}
