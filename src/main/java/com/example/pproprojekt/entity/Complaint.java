package com.example.pproprojekt.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


// reklamace entita
@EntityScan
@Table( "Reklamace")
public class Complaint {
    @Id
    private int id;
    @Column
    private String codeCmplaint;
    private String deiscription;
    private int client;
    private String criateDate;
    private int stav;
    private int employId;
    private String infoComplaint;
    private String settlementDate;

    public Complaint() {
    }

    public String getInfoComplaint() {
        return infoComplaint;
    }

    public void setInfoComplaint(String infoComplaint) {
        this.infoComplaint = infoComplaint;
    }

    public String getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(String settlementDate) {
        this.settlementDate = settlementDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClient() {
        return client;
    }

    public void setClient(int client) {
        this.client = client;
    }

    public String getCriateDate() {
        return criateDate;
    }

    public void setCriateDate(String criateDate) {
        this.criateDate = criateDate;
    }

    public int getEmployId() {
        return employId;
    }

    public void setEmployId(int employId) {
        this.employId = employId;
    }

    public String getCodeCmplaint() {
        return codeCmplaint;
    }

    public void setCodeCmplaint(String codeCmplaint) {
        this.codeCmplaint = codeCmplaint;
    }

    public String getDeiscription() {
        return deiscription;
    }

    public void setDeiscription(String deiscription) {
        this.deiscription = deiscription;
    }

    public int getStav() {
        return stav;
    }

    public void setStav(int stav) {
        this.stav = stav;
    }

    public int getId() {
        return id;
    }
}
