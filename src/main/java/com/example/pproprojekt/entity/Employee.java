package com.example.pproprojekt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="ZAMESTNANCI")
public class Employee {
    @javax.persistence.Id
    @Column(name = "ZAMESTNANCI_ID", nullable = false)
    private Long IDEmployee;;
    private String userName;
    private String lastName;
    private String firstName;
    private String email;
    private String password;
    private String telefon;
    private  int role;

    public Employee() {

    }



    public Employee(String userName, String firstName, String lastName, String telefon, String email, String password, int newRole) {
        this.userName=userName;
        this.firstName=firstName;
        this.lastName=lastName;
        this.telefon=telefon;
        this.email=email;
        this.password=password;
        this.role=newRole;
    }






    public void setIDEmployee(long IDEmployee) {
        this.IDEmployee = IDEmployee;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
