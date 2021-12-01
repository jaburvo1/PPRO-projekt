package com.example.pproprojekt;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.Admin;
import service.Login;


@RestController
//@RequestMapping("/")
public class Controller {
    private Login login = null;
    private int userId = 0;
    private int role = -1;
    private String userEamil;
    private String userPassword;
    private Admin admin;

    /*public Controller(Login login){
        this.login=login;
    }
*/

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index.xhtml");

        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(Model model,@RequestParam("userEmail") String email,
                              @RequestParam("userPassword") String password) {

        System.out.println("ok");
        System.out.println(password);


        //System.out.println(userEamil);
        ///login.getLogin(userEamil, userPassword);


        //login(email, password);

        //userId = login.getUserID();
       // role = login.getRole();
        //test data
        userId=1;
        role=1;
        //role=2;
        //role=3;
        //role=0;

        if (userId != -1) {
            ModelAndView modelAndView = new ModelAndView();
            switch (role) {
                case 1:
// sesion + map map /admin
                    admin = new Admin();
                    modelAndView.setViewName("/admin.xhtml");

                    break;
                case 2:
                    modelAndView.setViewName("/reklamace.xhtml");
                    break;
                case 3:
                    modelAndView.setViewName("/sklad.xhtml");
                    break;
                default:
                    //response.getWriter().println("Chybana role uzivatele v db");
                    modelAndView.setViewName("/index.xhtml");

                    break;
            }

            return modelAndView;

        } else {
            //response.getWriter().println("Nexistujici uzivatel, nebo chybne prihlaseni");

        }

        return null;

    }
    @RequestMapping(value = "",method = RequestMethod.POST)
    //@RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView editUser(Model model,@RequestParam("userName") String userName,
                                 @RequestParam("password") String password,
                                 @RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName,
                                 @RequestParam("telefon") String telefon,
                                 @RequestParam("eamil") String email, @RequestParam("role") int newRole, @RequestParam("akce") int akce) {
        System.out.println("jemeno: " + firstName + "primeno: " + lastName);
        model.addAttribute("editUser", admin.editUser(userName, firstName, lastName, telefon,email,password,newRole, akce));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin.xhtml");
        return modelAndView;
    }
    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
