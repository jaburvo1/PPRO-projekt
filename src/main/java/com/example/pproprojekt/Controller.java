package com.example.pproprojekt;

import com.example.pproprojekt.entity.Client;
import com.example.pproprojekt.entity.Complaint;
import com.example.pproprojekt.entity.Depot;
import com.example.pproprojekt.entity.Employee;
import com.example.pproprojekt.service.*;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
    @Autowired
    private ClientService client;
    private ModelAndView modelAndView;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        userId=-1;
        role=0;
        modelAndView.setViewName("index.xhtml");
        this.modelAndView = modelAndView;

        return modelAndView;
    }
    @RequestMapping(value = "/loginApp", method = RequestMethod.POST)
    public int login(@RequestParam("userEmail") String email, @RequestParam("userPassword") String password) {


        System.out.println("ok");
        System.out.println(password);
        System.out.println(email);
        Employee employee = login.login(email, password);
        if(employee!=null)
        {
            role = employee.getRole();
        }
        else {
            role =0;
        }
        return role;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(Model model, @RequestParam("userEmail") String email,
                              @RequestParam("userPassword") String password) {

        userId=-1;
        role=0;
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
     

        if (userId!=-1) {
            ModelAndView modelAndView = new ModelAndView();
            switch (role) {
                case 1:

                    modelAndView.setViewName("/admin.xhtml");


                    break;
                case 2:

                    modelAndView.setViewName("/sklad.xhtml");


                    break;
                case 3:

                    modelAndView.setViewName("/reklamace.xhtml");

                    break;
                default:

                    modelAndView.setViewName("/index.xhtml");

                    break;
            }

            this.modelAndView = modelAndView;
        }
            else{
            ModelAndView modelAndView = new ModelAndView();

            modelAndView.setViewName("/login.xhtml");
            this.modelAndView = modelAndView;

            }
            return modelAndView;
        }

    @RequestMapping(value = "/logoutApp", method = RequestMethod.GET)
    public int logout() {
        System.out.println("ok");
        role = 0;
        return role;
    }

        @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(Model model) {
        role=0;
        userId=-1;
        modelAndView.setViewName("index.xhtml");
        return modelAndView;
    }


    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public List<Employee> employeeView() {
        List<Employee> employees = new ArrayList<>();
        if(role==1) {
            employees = admin.findAll();
        }
        return employees;
    }



    @RequestMapping(value = "/reklamaceA", method = RequestMethod.GET)
    public List<Complaint> complaintAccepted() {
        List<Complaint>complaintListAccepted = new ArrayList<>();
        List<Complaint>complaintListPom;
        if(role==3){
            complaintListPom = complaint.getComplaintAccepted();
            for (int i=0; i<complaintListPom.size();i++){
                Complaint pomComplaint = complaintListPom.get(i);
                if(pomComplaint.getStav()==1){
                    complaintListAccepted.add(pomComplaint);
                    System.out.println(pomComplaint.getStav());
                }

            }
        }

        return complaintListAccepted;
    }

    @RequestMapping(value = "/reklamaceS", method = RequestMethod.GET)
    public List<Complaint> complaintSettled() {
        List<Complaint>complaintListSettled = new ArrayList<>();
        List<Complaint>complaintListPom;
            if(role==3) {
                complaintListPom = complaint.getComplaintSettled();
                for (int i=0; i<complaintListPom.size();i++){
                    Complaint pomComplaint = complaintListPom.get(i);
                    if(pomComplaint.getStav()==2){
                        complaintListSettled.add(pomComplaint);
                        System.out.println(pomComplaint.getStav());
                    }

                }
            }
        return complaintListSettled;
    }

    @RequestMapping(value = "/reklamaceR", method = RequestMethod.GET)
    public List<Complaint> complaintRejected() {
        List<Complaint>complaintListRejected = new ArrayList<>();
        List<Complaint>complaintListPom;
        if(role==3) {
            complaintListPom = complaint.getComplaintAccepted();
            for (int i=0; i<complaintListPom.size();i++){
                Complaint pomComplaint = complaintListPom.get(i);
                if(pomComplaint.getStav()==3){
                    complaintListRejected.add(pomComplaint);
                    System.out.println(pomComplaint.getStav());
                }

            }
        }
        return complaintListRejected;
    }



    @RequestMapping(value = "/sklad", method = RequestMethod.GET)
    public List<Depot> depotView() {
        List<Depot> partList=new ArrayList<>();
        if(role==2) {
            partList = depot.getAllPart();
        }
        return partList;
    }

    @RequestMapping(value = "/novyUzivatel", method = RequestMethod.POST)
    public String addUser(Model model, @RequestParam("userName") String userName,
                                @RequestParam("password") String password,
                                @RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName,
                                @RequestParam("telefon") String telefon,
                                @RequestParam("email") String email, @RequestParam("role") int newRole) {

        Employee employee = admin.findUserByEmail(email);
        String statusText="";
        if(employee!=null){
            statusText="email už je pouzivan";
        }
        else{
            admin.addUser(userName, firstName, lastName, telefon, email, password, newRole);

            statusText="uzivatel vytvoren";
        }

        return statusText;

    }

    @RequestMapping(value = "/editUserRole", method = RequestMethod.POST)
    public String editUserRole(Model model, @RequestParam("email") String email, @RequestParam("role") int newRole) {

        Employee employee = admin.findUserByEmail(email);
       employee = (Employee) admin.editUserRole(employee.getEmail(),newRole);
        String statusText="";
        if(employee!=null){

            statusText="role zmenena";
        }
        else{

            statusText="role nezmenena";
        }

        return statusText;
    }

    @RequestMapping(value = "/editPassword", method = RequestMethod.POST)
    public String editPassword(Model model, @RequestParam("email") String email, @RequestParam("password") String password) {
        String statusString;
        Employee employee = admin.findUserByEmail(email);
        System.out.println(employee.getUserName());
        System.out.println("heslo"+password);
         employee=(Employee) admin.editPassword(employee.getEmail(), password);

        if(employee!=null){
            statusString="heslo zmeneno";
        }
        else {
            statusString="ne heslo zmeneno";
        }


        return statusString;
    }

    @RequestMapping(value = "/novaRekalamace", method = RequestMethod.POST)
    public  String addComplaint(Model model, @RequestParam("kodReklamace") String codeComplaint, @RequestParam("popisReklamace") String description,
                                     @RequestParam("datumVytvorení") String criateDate, @RequestParam("client") int client, @RequestParam("stavReklamace") int stav
    ) {

        Object rezult =complaint.add(codeComplaint, description, criateDate, client, stav, userId);
        String statusText="";
        if(rezult==null){
            statusText="reklamace nevytvoren";
        }
        else {
            statusText="reklamace vytvoren";
        }
        return statusText;

    }

    @RequestMapping(value = "/editRekalamace", method = RequestMethod.POST)
    public  String ediComplaint(Model model, @RequestParam("kodReklamace") String codeComplaint, @RequestParam("infoReklamace") String infoCmoplaint,
                                     @RequestParam("datumVyreseni") String settlementDate, @RequestParam("stavReklamace") int stav)
    {
        System.out.println("kodReklamace: "+ codeComplaint);
        Object rezult = complaint.edit(codeComplaint,stav, userId, infoCmoplaint, settlementDate);
        String statusText="";
        if(rezult==null){
            statusText="reklamace neupravena";
        }
        else {
            statusText="reklamace upravena";
        }
        return statusText;
    }

    @RequestMapping(value = "/addItem", method = RequestMethod.POST)
    public String addItem(Model model, @RequestParam("druhDilu") String typePart, @RequestParam("typDilu") String subtypePart,
                                @RequestParam("nazevdilu") String namePart, @RequestParam("parametryDilu") String parametrsPart, @RequestParam("vyrobceDilu") String manufacturePart,
                                @RequestParam("pocetKusu") int countPart) {

        String statusText = "";
        Object rezult = depot.addPart(namePart, typePart, subtypePart, parametrsPart, manufacturePart, countPart);
        if(rezult==null){
            statusText="ne pridan novy dill";
        }
        else {
            statusText="pridan novy dill";
        }
       return statusText;
    }

    @RequestMapping(value = "/addItemApp", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public JSONObject addItemApp(Model model, @RequestParam("druhDilu") String typePart, @RequestParam("typDilu") String subtypePart,
                                 @RequestParam("nazevdilu") String namePart, @RequestParam("parametryDilu") String parametrsPart, @RequestParam("vyrobceDilu") String manufacturePart,
                                 @RequestParam("pocetKusu") int countPart) throws JSONException {

        String statusText = "";
        Object rezult = depot.addPart(namePart, typePart, subtypePart, parametrsPart, manufacturePart, countPart);
        if(rezult==null){
            statusText="ne pridan novy dill";
        }
        else {
            statusText="pridan novy dill";
        }


        JSONObject jsonObj = new JSONObject();
        jsonObj.put("statusText", statusText);
        return jsonObj;
    }



    @RequestMapping(value = "/addItemPiece", method = RequestMethod.POST)
    public String addItemPiece(Model model, @RequestParam("nazevdilu") String namePart, @RequestParam("pocetKusu") int countPart
    ) {

        String statusText="";
        Object rezult= depot.addPiecePart(namePart, countPart);

        if(rezult!=null){
            statusText="dil ne naskladnen";
        }
        else {
            statusText="dil naskladnen";
        }
        return statusText;
    }

    @RequestMapping(value = "/addItemPieceApp", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public JSONObject addItemPieceApp(Model model, @RequestParam("nazevdilu") String namePart, @RequestParam("pocetKusu") int countPart
    ) throws JSONException {

        String statusText="";
        Object rezult= depot.addPiecePart(namePart, countPart);

        if(rezult!=null){
            statusText="dil ne naskladnen";
        }
        else {
            statusText="dil naskladnen";
        }
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("statusText", statusText);
        return jsonObj;
    }


    @RequestMapping(value = "/removeItemPiece", method = RequestMethod.POST)
    public String removeItemPiece(Model model, @RequestParam("nazevdilu") String namePart, @RequestParam("pocetKusu") int countPart) {
        String statusText="";
        Depot rezult= (Depot) depot.findAll(namePart);

        if(rezult==null){
            statusText="nazev dilui neni evidenci skladu";
        }
        else {
            if(rezult.getCountPart()>=countPart) {
                depot.removePiecePart(namePart, countPart);
                statusText = "dil vyskladnen";
            }
            else {
                statusText = "dil ne vyskladnen";
            }
        }

        return statusText;
    }

    @RequestMapping(value = "/removeItemPieceApp", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public JSONObject removeItemPieceApp(Model model, @RequestParam("nazevdilu") String namePart, @RequestParam("pocetKusu") int countPart) throws JSONException {
        String statusText="";
        Depot rezult= (Depot) depot.findAll(namePart);

        if(rezult==null){
            statusText="nazev dilui neni evidenci skladu";
        }
        else {
            if(rezult.getCountPart()>=countPart) {
                depot.removePiecePart(namePart, countPart);
                statusText = "dil vyskladnen";
            }
            else {
                statusText = "dil ne vyskladnen";
            }
        }
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("statusText", statusText);
        return jsonObj;

    }
    @RequestMapping(value = "/klientList", method = RequestMethod.GET)
    public List<Client> clientView(){

        List<Client> clients = new ArrayList<>();
        if(role==3) {
            clients= client.findAll();
        }
        return clients;
    }


}
