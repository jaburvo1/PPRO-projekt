package service;

import com.example.pproprojekt.entity.Employee;
import org.springframework.stereotype.Service;
import repozitory.EmploeeyRepository;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.Persistence.createEntityManagerFactory;

@Service
public class Login {
    private EmploeeyRepository repozitoryEm;

    private int idUser;
    private int role;
    private String userEmail;
    private String password;
    private Employee employee;
    private EmploeeyRepository emploeeyDao;

    private EntityManager entityManager;
    private List<Employee> listEmployee;


    public Login(String userEmail, String password) {
        this.userEmail = userEmail;
        this.password = password;



    }

    public Login() {
    }

    public Login(EmploeeyRepository repozitoryEm) {
        this.repozitoryEm = repozitoryEm;
    }

    public Employee login(String email, String password) {
        listEmployee = new ArrayList<>();
        for (Employee em: listEmployee) {
            if ((email.equals(em.getEmail())) && (password.equals(em.getPassword()))) {
                employee = em;
            } else {
                System.out.println("chyne prihalsovaci udaje");
            }
        }
        return employee;
    }
}


