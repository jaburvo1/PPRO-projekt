package service;

import com.example.pproprojekt.entity.Employee;
import org.springframework.stereotype.Service;
import repozitory.EmployeeRepository;

import java.util.List;
import javax.persistence.*;

import static javax.persistence.Persistence.createEntityManagerFactory;

@Service
public class Login {
    private final EmployeeRepository repozitoryEm;

    private int idUser;
    private int role;
    private String userEmail;
    private String password;
    private Employee employee;

    private EntityManager entityManager;


    public Login(String userEmail, String password, EmployeeRepository repository) {
        this.userEmail = userEmail;
        this.password = password;
        this.repozitoryEm = repository;


    }



    private Employee getAllBy() {
        List<Employee> pom = repozitoryEm.findAll();
        for (Employee em : pom) {
            if ((em.getEmail().equals(userEmail)) && (em.getPassword().equals(password))) {
                return em;
            }

        }
        return null;
    }

    public Employee getLogin(String email, String password) {
        this.userEmail=email;
        this.password=password;

        Employee em = getAllBy();
        if(em!=null) {
            return em;
        }
        else {
            em.setIDEmployee(-1);
            return em;
        }
    }
}


