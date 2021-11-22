package com.example.pproprojekt;

import com.example.pproprojekt.entity.Login;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class Controller {
    private Login login = null;
    private int userId = -1;
    private int role = -1;
/*
    @GetMapping("/")
    public void index(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("ok");
        System.out.println(request.getHeader("User-agent"));
        response.getWriter().println("ok");

    }
*/
    /*
@RequestMapping("/")
public ModelAndView index () {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("index");
    return modelAndView;
}*/

    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index.xhtml");
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request,
                              HttpServletResponse response) throws IOException {
        String email = request.getAttribute("email").toString();
        String password = request.getAttribute("password").toString();

        System.out.println(email + " " + password);
        login = new Login();
        //login(email, password);
        userId = login.getUserID();
        role = login.getRole();

        if (userId != -1) {
            ModelAndView modelAndView = new ModelAndView();
            switch (role) {
                case 1:
// sesion + map map /admin
                    modelAndView.setViewName("/admin");

                    break;
                case 2:
                    modelAndView.setViewName("/reklamace");
                    break;
                case 3:
                    modelAndView.setViewName("/salad");
                    break;
                default:
                    response.getWriter().println("Chybana role uzivatele v db");

                    break;
            }
            return modelAndView;

        } else {
            response.getWriter().println("Nexistujici uzivatel, nebo chybne prihlaseni");
        }

        return null;
    }
}
