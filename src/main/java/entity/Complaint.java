package entity;

import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

// reklamace entita
@Entity
@Table( "Reklamace")
public class Complaint {
    @Id
    private int id;
    @Column
    private String nameCmplaint;
    private String deiscription;
    private int stav;

    public String getNameCmplaint() {
        return nameCmplaint;
    }

    public void setNameCmplaint(String nameCmplaint) {
        this.nameCmplaint = nameCmplaint;
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
