package com.example.pproprojekt;

import com.example.pproprojekt.entity.Complaint;
import com.example.pproprojekt.entity.Depot;
import com.example.pproprojekt.entity.Employee;
import org.apache.xerces.xs.XSAttributeUse;
import org.json.JSONObject;
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
    private int role=0;
    @Autowired
    private Admin admin;
    @Autowired
    private DepotService depot;
    @Autowired
    private ComplaintService complaint;
    private ModelAndView modelAndView;
    private List<Complaint> complaintListAccepted = new ArrayList<>();
    private List<Complaint> complaintListSettled = new ArrayList<>();
    private List<Complaint> complaintListRejected = new ArrayList<>();


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
        if(employee==null){
            userId=-1;
        }
        else {
            userId = Math.round(employee.getIDEmployee());
            role = employee.getRole();
        }
        //role=2;
        //role=3;
        //role=0;

        if (userId!=-1) {
            ModelAndView modelAndView = new ModelAndView();
            switch (role) {
                case 1:
// sesion + map map /admin
                    //nevyt aret instance
                    //modelAndView = adminView();
                    modelAndView.setViewName("/admin.xhtml");


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
        }
            else{
            ModelAndView modelAndView = new ModelAndView();
                //modelAndView.setViewName("/login.xhtml");
            modelAndView.setViewName("/login.xhtml");
            this.modelAndView = modelAndView;

            }
            return modelAndView;
        }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(Model model) {
        role=0;
        userId=-1;
        modelAndView.setViewName("index.xhtml");
        return modelAndView;
    }


    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView adminView() {

        return modelAndView;
    }

    /*@RequestMapping(value = "/reklamace", method = RequestMethod.GET)
    public List<Complaint> complaintView(/*@RequestParam("stav") int stav*//*) {

        complaintListAccepted = complaint.getAllComplaint(1);
        complaintListSettled = complaint.getAllComplaint(2);
        complaintListRejected = complaint.getAllComplaint(3);
int stav=1;

        List<Complaint> complaints = new ArrayList<>();
        switch (stav) {
            case 1:
                complaints = complaintListAccepted;
                break;
            case 2:
                complaints = complaintListSettled;
                break;
            case 3:
                complaints = complaintListRejected;
                break;
        }
        return complaints;
    }
*/

    @RequestMapping(value = "/reklamaceA", method = RequestMethod.GET)
    public List<Complaint> complaintAccepted() {
        complaintListAccepted = new ArrayList<>();
        complaintListAccepted = complaint.getComplaintAccepted();
        return complaintListAccepted;
    }

    @RequestMapping(value = "/reklamaceS", method = RequestMethod.GET)
    public List<Complaint> complaintSettled() {
        complaintListSettled = new ArrayList<>();
        complaintListSettled = complaint.getComplaintSettled();
        return complaintListSettled;
    }

    @RequestMapping(value = "/reklamaceR", method = RequestMethod.GET)
    public List<Complaint> complaintRejected() {
        complaintListRejected = new ArrayList<>();
        complaintListRejected = complaint.getComplaintRejected();
        return complaintListRejected;
    }



    @RequestMapping(value = "/sklad", method = RequestMethod.GET)
    public List<Depot> depotView() {
        List<Depot> partList=new ArrayList<>();
        partList = depot.getAllPart();
        return partList;
    }

    @RequestMapping(value = "/novyUzivatel", method = RequestMethod.POST)
    public int /*ModelAndView*/ /*String*/ addUser(Model model, @RequestParam("userName") String userName,
                                @RequestParam("password") String password,
                                @RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName,
                                @RequestParam("telefon") String telefon,
                                @RequestParam("email") String email, @RequestParam("role") int newRole) {
       /* System.out.println("jemeno: " + firstName + "primeno: " + lastName);
        model.addAttribute("addUser", admin.addUser(userName, firstName, lastName, telefon, email, password, newRole));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin.xhtml");*/
        Employee employee =(Employee) admin.addUser(userName, firstName, lastName, telefon, email, password, newRole);
        //String status = "";
        int status=0;
        if(employee!=null){
            status=500;
        }
        else{
            status=200;
        }

        //return modelAndView;
        return status;
        //System.out.println(status);
        //return status;
    }

    @RequestMapping(value = "/editUserRole", method = RequestMethod.POST)
    public ModelAndView editUserRole(Model model, @RequestParam("userName") String userName, @RequestParam("role") int newRole) {

        model.addAttribute("editUserRole", admin.editUserRole(userName, newRole));

        return modelAndView;
    }

    @RequestMapping(value = "/editPassword", method = RequestMethod.POST)
    public ModelAndView editPassword(Model model, @RequestParam("userName") String userName, @RequestParam("password") String password) {
        model.addAttribute("editPassword", admin.editPassword(userName, password));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin.xhtml");
        return modelAndView;
    }

    @RequestMapping(value = "/novaRekalamace", method = RequestMethod.POST)
    public ModelAndView addComplaint(Model model, @RequestParam("kodReklamace") String codeComplaint, @RequestParam("popisReklamace") String description,
                                     @RequestParam("datumVytvorení") String criateDate, @RequestParam("client") int client, @RequestParam("stavReklamace") int stav
    ) {

        model.addAttribute("addReklamace", complaint.add(codeComplaint, description, criateDate, client, stav, userId));
        //modelAndView.setViewName("/reklamace.xhtml");
        //complaintView();
        return modelAndView;
    }

    @RequestMapping(value = "/editRekalamace", method = RequestMethod.PATCH)
    public ModelAndView ediComplaint(Model model, @RequestParam("kodReklamace") String codeComplaint, @RequestParam("infoReklamace") String infoCmoplaint,
                                     @RequestParam("datumVyreseni") String settlementDate, @RequestParam("stavReklamace") int stav
    ) {
        System.out.println("kodReklamace: "+codeComplaint);

        model.addAttribute("editReklamace", complaint.edit(codeComplaint,stav, userId, infoCmoplaint, settlementDate));

        //complaintView();
        return modelAndView;
    }

    @RequestMapping(value = "/addItem", method = RequestMethod.POST)
    public ModelAndView addItem(Model model, @RequestParam("druhDilu") String typePart, @RequestParam("typDilu") String subtypePart,
                                @RequestParam("nazevdilu") String namePart, @RequestParam("parametryDilu") String parametrsPart, @RequestParam("vyrobceDilu") String manufacturePart,
                                @RequestParam("pocetKusu") int countPart) {

        model.addAttribute("addDil", depot.addPart(namePart, typePart, subtypePart, parametrsPart, manufacturePart, countPart));

        //modelAndView = depotView();
        return modelAndView;

    }

    @RequestMapping(value = "/addItemPiece", method = RequestMethod.PATCH)
    public ModelAndView addItemPiece(Model model, @RequestParam("nazevdilu") String namePart, @RequestParam("pocetKusu") int countPart
    ) {

        model.addAttribute("addkusDilu", depot.addPiecePart(namePart, countPart));

        //modelAndView = depotView();
        return modelAndView;

    }

    @RequestMapping(value = "/removeItemPiece", method = RequestMethod.PATCH)
    public ModelAndView removeItemPiece(Model model, @RequestParam("nazevdilu") String namePart, @RequestParam("pocetKusu") int countPart) {

        System.out.println("nazevDilu: "+namePart);
        model.addAttribute("removekusDilu", depot.removePiecePart(namePart, countPart));

       // modelAndView = depotView();
        return modelAndView;

    }

}
