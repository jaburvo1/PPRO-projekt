package com.example.pproprojekt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "DRUHY_DILU")
public class Depot {
    @javax.persistence.Id
    @Column(name = "DRUHY_DILU_ID", nullable = false)
    private int id;
    @Column(name = "NAZEV_DILU")
    private String namePart;
    @Column(name = "DRUH_DILU")
    private String typePart;
    @Column(name = "TYP_DILU")
    private String subtypePart;
    @Column(name = "PARAMETRY_DILU")
    private String parametrsPart;
    @Column(name = "VYROBCE_DILU")
    private String manufacturePart;
    @Column(name = "POCET_KUSU")
    private int countPart;
    @Column(name = "SKLAD_DILU_ID")
    private int idSkald= 7;
    public Depot() {
    }

    public Depot(String namePart, String typePart, String subtypePart, String parametrsPart, String manufacturePart, int countPart) {
        this.namePart = namePart;
        this.typePart = typePart;
        this.subtypePart = subtypePart;
        this.parametrsPart = parametrsPart;
        this.manufacturePart = manufacturePart;
        this.countPart = countPart;
        //idSkald=7;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamePart() {
        return namePart;
    }

    public void setNamePart(String namePart) {
        this.namePart = namePart;
    }

    public String getTypePart() {
        return typePart;
    }

    public void setTypePart(String typePart) {
        this.typePart = typePart;
    }

    public String getSubtypePart() {
        return subtypePart;
    }

    public void setSubtypePart(String subtypePart) {
        this.subtypePart = subtypePart;
    }

    public String getParametrsPart() {
        return parametrsPart;
    }

    public void setParametrsPart(String parametrsPart) {
        this.parametrsPart = parametrsPart;
    }

    public String getManufacturePart() {
        return manufacturePart;
    }

    public void setManufacturePart(String manufacturePart) {
        this.manufacturePart = manufacturePart;
    }

    public int getCountPart() {
        return countPart;
    }

    public void setCountPart(int countPart) {
        this.countPart = countPart;
    }

    public int getIdSkald() {
        return idSkald;
    }

    public void setIdSkald(int idSkald) {
        this.idSkald = idSkald;
    }
}
