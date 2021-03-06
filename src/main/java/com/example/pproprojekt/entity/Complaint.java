package com.example.pproprojekt.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


// reklamace entita
@Entity
@Table(name = "REKLAMACE")
public class Complaint {
    @javax.persistence.Id
    @Column(name = "REKLAMACE_ID", nullable = false)
    private int id;
    @Column(name = "KOD_REKLAMACE")
    private String codeCmplaint;
    @Column(name = "POPIS_PROBLEMU")
    private String deiscription;
    @Column(name = "KLIENTI_ID")
    private int client;
    @Column(name = "DATUM_VYTVORENI")
    private String criateDate;
    @Column(name = "STAV_ID")
    private int stav;
    @Column(name = "ZAMESTNANCI_ID")
    private int employId;
    @Column(name = "INFORMACE_REKLAMACE")
    private String infoComplaint;
    @Column(name = "DATUM_VYRESENI")
    private String settlementDate;
    @Column(name = "SKLADDILU_ID")
    private Integer skladId=7;

    public Complaint() {
    }

    public int getSkladId() {
        return skladId;
    }

    public void setSkladId(int skladId) {
        this.skladId = skladId;
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

    public long getId() {
        return id;
    }
}
