package service;

import com.example.pproprojekt.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Admin {

    private Employee employee;
    private List<Employee> emploees = new ArrayList<>();

    public Object addUser(String userName, String firstName, String lastName, String telefon, String email, String password, int newRole) {

        //uložení do db


        return null;
    }

    private Employee findUser(String email) {
        for(Employee em: emploees)
            if(em.getEmail().equals(email)){
                return em;
            }

        return null;
    }

    public Object editUserRole(String userName, int newRole) {

        return null;
    }

    public Object editPassword(String userName, String password) {

        return null;
    }
}
