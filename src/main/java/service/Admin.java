package service;

import com.example.pproprojekt.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Admin {

    private Employee employee;

    private List<Employee> emploees = new ArrayList<>();
    public Object editUser(String userName, String firstName, String lastName, String telefon, String email, String password, int newRole, int akce) {

        switch (akce){
            case 1:
                 employee = new Employee(userName, firstName, lastName, telefon,email,password,newRole);
                emploees.add(employee);

                break;
            case 2:
                employee = findUser(email);
                emploees.remove(employee);
                employee.setPassword(password);
                emploees.add(employee);
                break;
            case 3:
                employee = findUser(email);
                emploees.remove(employee);
                employee.setRole(newRole);
                emploees.add(employee);
                break;
        }
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
}
