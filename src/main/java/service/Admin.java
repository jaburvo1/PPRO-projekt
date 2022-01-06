package service;

import com.example.pproprojekt.entity.Employee;
import org.springframework.stereotype.Service;
import repozitory.EmploeeyRepository;
import repozitory.EmploeeyRepositoryOracle;

import java.util.ArrayList;
import java.util.List;

@Service
public class Admin {

    private Employee employee;
    private List<Employee> listEmployee;
    private EmploeeyRepository emploeeyRepo =new EmploeeyRepositoryOracle();

    public Admin() {
    }

    public Admin(EmploeeyRepository emploeeyRepo) {
        this.emploeeyRepo = emploeeyRepo;
    }

    public Object addUser(String userName, String firstName, String lastName, String telefon, String email, String password, int newRole) {

        System.out.println("login:"+userName+"email: "+email);
        //uložení do db
        Employee pomEmployee = findUserByEmail(email);
        if(pomEmployee!=null)
        {
            employee = new Employee(userName, firstName,lastName,telefon,email,password,newRole);
            emploeeyRepo.save(employee);
        }
        else {
            System.out.println("email už je v databázi");
        }


        return employee;
    }

    private Employee findUserByEmail(String email) {
        listEmployee=new ArrayList<>();
        listEmployee = emploeeyRepo.findAll();

        for(Employee em: listEmployee)
            if(em.getEmail().equals(email)){
                return em;
            }

        return null;
    }
    private Employee findUserByUseName(String userName)
    {
        listEmployee=new ArrayList<>();
        listEmployee = emploeeyRepo.findAll();

        for(Employee em: listEmployee){
            if(em.getEmail().equals(userName)){
                return em;
            }
            else {
                return null;
            }
        }
        return null;
    }

    public Object editUserRole(String userName, int newRole) {

        System.out.println("login: "+userName+"role: "+newRole);

        employee = findUserByUseName(userName);
       if(employee!=null) {
           emploeeyRepo.delete(employee);
           employee.setRole(newRole);
           emploeeyRepo.save(employee);
       }
       else {
           System.out.println("chybne user name");
       }
        return employee;
    }

    public Object editPassword(String userName, String password) {
        System.out.println("lgin: "+userName+"heslo: "+ password);

        employee = findUserByUseName(userName);
        if(employee!=null) {
            emploeeyRepo.delete(employee);
            employee.setPassword(password);
            emploeeyRepo.save(employee);
        }
        else {
            System.out.println("chybne user name");
        }

        return employee;
    }
}
