package service;

import com.example.pproprojekt.entity.Employee;
import org.springframework.stereotype.Service;
import repozitory.EmploeeyRepository;

import javax.persistence.*;

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


    public Login(String userEmail, String password) {
        this.userEmail = userEmail;
        this.password = password;



    }

    public Login() {
        repozitoryEm = new EmploeeyRepository();

    }
    public Employee getLogin(String email, String password) {
        this.userEmail=email;
        this.password=password;
        emploeeyDao = new EmploeeyRepository();

        Employee em = emploeeyDao.getEmploeeLogin(email, password) ;
        if(em!=null) {
            return em;
        }
        else {
            em.setIDEmployee(-1);
            return em;
        }
    }
}


