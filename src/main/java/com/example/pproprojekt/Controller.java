package com.example.pproprojekt;

import com.example.pproprojekt.entity.Complaint;
import com.example.pproprojekt.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.example.pproprojekt.service.Admin;
import com.example.pproprojekt.service.ComplaintService;
import com.example.pproprojekt.service.DepotService;
import com.example.pproprojekt.service.Login;

import java.util.ArrayList;
import java.util.List;


@RestController
public class Controller {
    @Autowired
    private Login login;
    private int userId = -1;
    private int role;
    @Autowired
    private Admin admin;
    @Autowired
    private DepotService depot;
    @Autowired
    private ComplaintService complaint;
    private ModelAndView modelAndView;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index.xhtml");
        this.modelAndView = modelAndView;

        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(Model model, @RequestParam("userEmail") String email,
                              @RequestParam("userPassword") String password) {

        System.out.println("ok");
        System.out.println(password);
        System.out.println(email);
        Employee employee =login.login(email, password);


        ///login(userEamil, userPassword);

        //userId = login.getUserID();
        // role = login.getRole();
        //test data
        userId = Math.round(employee.getIDEmployee());
        role = employee.getRole();
        //role=2;
        //role=3;
        //role=0;

        if (userId!=-1) {
            ModelAndView modelAndView = new ModelAndView();
            switch (role) {
                case 1:
// sesion + map map /admin
                    //nevyt aret instance
                    modelAndView = adminView();
                    //modelAndView.setViewName("/admin.xhtml");


                    break;
                case 2:

                    modelAndView.setViewName("/sklad.xhtml");

                    //modelAndView = complaintView();
                    break;
                case 3:

                    modelAndView.setViewName("/reklamace.xhtml");

                    //modelAndView = depotView();
                    break;
                default:
                    //response.getWriter().println("Chybana role uzivatele v db");
                    modelAndView.setViewName("/index.xhtml");

                    break;
            }
            this.modelAndView = modelAndView;

            return this.modelAndView;

        } else {
            //response.getWriter().println("Nexistujici uzivatel, nebo chybne prihlaseni");

        }

        return null;

    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView adminView() {
        // ModelAndView modelAndView = new ModelAndView()
        modelAndView.setViewName("admin.xhtml");

        //this.modelAndView=modelAndView;
        return modelAndView;
    }

    @RequestMapping(value = "/reklamace", method = RequestMethod.GET)
    public ModelAndView complaintView() {
        ModelAndView modelAndView = new ModelAndView();

        List<Complaint> complaintListAccepted=new ArrayList<>();
        complaintListAccepted =complaint.getAllComplaint(1);
        List<Complaint> complaintListSettled=new ArrayList<>();
        complaintListSettled =complaint.getAllComplaint(2);
        List<Complaint> complaintListRejected=new ArrayList<>();
        complaintListRejected =complaint.getAllComplaint(3);
    modelAndView.setViewName("reklamace.xhtml");
//vips do html??
        this.modelAndView = modelAndView;
        return modelAndView;
    }

    @RequestMapping(value = "/sklad", method = RequestMethod.GET)
    public ModelAndView depotView() {

        modelAndView.setViewName("sklad.xhtml");

        //this.modelAndView=modelAndView;
        return modelAndView;
    }

    @RequestMapping(value = "/novyUzivatel", method = RequestMethod.POST)
    public ModelAndView addUser(Model model, @RequestParam("userName") String userName,
                                @RequestParam("password") String password,
                                @RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName,
                                @RequestParam("telefon") String telefon,
                                @RequestParam("eamil") String email, @RequestParam("role") int newRole) {
        System.out.println("jemeno: " + firstName + "primeno: " + lastName);
        model.addAttribute("addUser", admin.addUser(userName, firstName, lastName, telefon, email, password, newRole));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin.xhtml");
        return modelAndView;
    }

    @RequestMapping(value = "/editUserRole", method = RequestMethod.PATCH)
    public ModelAndView editUserRole(Model model, @RequestParam("userName") String userName, @RequestParam("role") int newRole) {

        model.addAttribute("editUserRole", admin.editUserRole(userName, newRole));

        modelAndView = adminView();
        return modelAndView;
    }

    @RequestMapping(value = "/editPassword", method = RequestMethod.PATCH)
    public ModelAndView editPassword(Model model, @RequestParam("userName") String userName, @RequestParam("password") String password) {
        model.addAttribute("editPassword", admin.editPassword(userName, password));

        modelAndView = adminView();
        return modelAndView;
    }

    @RequestMapping(value = "/novaRekalamace", method = RequestMethod.POST)
    public ModelAndView addComplaint(Model model, @RequestParam("kodReklamace") String codeComplaint, @RequestParam("popisReklamace") String description,
                                     @RequestParam("datumVytvorení") String criateDate, @RequestParam("client") int client, @RequestParam("stavReklamace") int stav
    ) {

        model.addAttribute("addReklamace", complaint.add(codeComplaint, description, criateDate, client, stav, userId));
        //modelAndView.setViewName("/reklamace.xhtml");
        modelAndView = complaintView();
        return modelAndView;
    }

    @RequestMapping(value = "/editRekalamace", method = RequestMethod.PATCH)
    public ModelAndView ediComplaint(Model model, @RequestParam("kodReklamace") String codeComplaint, @RequestParam("infoReklamace") String infoCmoplaint,
                                     @RequestParam("datumVyreseni") String settlementDate, @RequestParam("stavReklamace") int stav
    ) {
        System.out.println("kodReklamace: "+codeComplaint);

        model.addAttribute("editReklamace", complaint.edit(codeComplaint,stav, userId, infoCmoplaint, settlementDate));

        modelAndView = complaintView();
        return modelAndView;
    }

    @RequestMapping(value = "/addItem", method = RequestMethod.POST)
    public ModelAndView addItem(Model model, @RequestParam("druhDilu") String typePart, @RequestParam("typDilu") String subtypePart,
                                @RequestParam("nazevdilu") String namePart, @RequestParam("parametryDilu") String parametrsPart, @RequestParam("vyrobceDilu") String manufacturePart,
                                @RequestParam("pocetKusu") int countPart) {

        model.addAttribute("addDil", depot.addPart(namePart, typePart, subtypePart, parametrsPart, manufacturePart, countPart));

        modelAndView = depotView();
        return modelAndView;

    }

    @RequestMapping(value = "/addItemPiece", method = RequestMethod.PATCH)
    public ModelAndView addItemPiece(Model model, @RequestParam("nazevdilu") String namePart, @RequestParam("pocetKusu") int countPart
    ) {

        model.addAttribute("addkusDilu", depot.addPiecePart(namePart, countPart));

        modelAndView = depotView();
        return modelAndView;

    }

    @RequestMapping(value = "/removeItemPiece", method = RequestMethod.PATCH)
    public ModelAndView removeItemPiece(Model model, @RequestParam("nazevdilu") String namePart, @RequestParam("pocetKusu") int countPart) {

        System.out.println("nazevDilu: "+namePart);
        model.addAttribute("removekusDilu", depot.removePiecePart(namePart, countPart));

        modelAndView = depotView();
        return modelAndView;

    }

}
