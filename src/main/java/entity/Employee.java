package entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;

@EntityScan
public class Employee {
    @Id
    private int IDEmployee;
}
