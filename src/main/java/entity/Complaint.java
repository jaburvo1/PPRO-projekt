package entity;

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
