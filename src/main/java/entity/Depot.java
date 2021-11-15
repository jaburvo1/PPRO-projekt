package entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Depot {
    @Id
   private int idSklad;
    public Depot() {
    }
}
