package com.example.pproprojekt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "KLIENTI")
public class Client {
    @Id
    @Column(name = "KLIENTI_ID", nullable = false)
    private int idClient;
    @Column(name = "PRIJMENI")
    private String lastName;
    @Column(name = "JMENO")
    private String firstName;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "TELEFON")
    private String telefon;
    @Column(name = "ADRESA_ID")
    private int adresaId =5;

    public int getId() {
        return idClient;
    }


    public int getIdClient() {
        return idClient;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefon() {
        return telefon;
    }

    public int getAdresaId() {
        return adresaId;
    }

    public Client() {
    }
}
