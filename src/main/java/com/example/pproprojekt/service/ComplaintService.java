package com.example.pproprojekt.service;

import com.example.pproprojekt.entity.Complaint;
import com.example.pproprojekt.repozitory.ComplaintRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ComplaintService {

    private Complaint complaint;
    //private List<Complaint> listCoplaint;

    private List<Complaint> complains;
  @Autowired
    private ComplaintRepository complaintRepo;


    public Object add(String codeComplaint, String description, String criateDate, int client, int stav, int employeId) {
        Complaint pomComplaint = findByCodeCoplaint(codeComplaint);
        if (pomComplaint == null) {
        System.out.println("kodReklamace: " + codeComplaint + "stav: " + stav);
        complaint = new Complaint();
        complaint.setDeiscription(description);
        complaint.setClient(client);
        complaint.setCodeCmplaint(codeComplaint);
        complaint.setCriateDate(criateDate);
        complaint.setEmployId(employeId);
        complaint.setStav(stav);
        complaintRepo.save(complaint);
        System.out.println("ok");
        //return complaint;
    }
         else {
            System.out.println("kod rkalame již exzistuje");
            complaint=null;
            //return complaint;
        }
         return complaint;
    }

    public Object edit(String codeComplaint, int stav, int employeId, String infoComplaint, String settlementDate){
        Complaint pomComplaint = findByCodeCoplaint(codeComplaint);

        System.out.println(employeId);
        if(pomComplaint==null){
            complaint =null;
        }
        else {

            complaint=pomComplaint;
            complaint.setCodeCmplaint(codeComplaint);
            complaint.setInfoComplaint(infoComplaint);
            complaint.setStav(stav);
            complaint.setEmployId(employeId);
            complaint.setSettlementDate(settlementDate);
            complaintRepo.save(complaint);
        }
        return complaint;

    }

    public List<Complaint> getComplaintAccepted() {
        complains =new ArrayList<>();

        try {
            complains = complaintRepo.findAll();
            System.out.println("ok");
        }
        catch (Exception e) {
            complaint =new Complaint();
            complaint.setCodeCmplaint("chyba komunikace z dbs");
            complaint.setDeiscription("výjimak: " + e);
            complains.add(complaint);
        }

        return complains;
    }


    public List<Complaint> getComplaintSettled() {
        complains =new ArrayList<>();

        try {
            complains = complaintRepo.findAll();
            System.out.println("ok");
        }
        catch (Exception e) {
            complaint =new Complaint();
            complaint.setCodeCmplaint("chyba komunikace z dbs");
            complaint.setDeiscription("výjimak: " + e);
            complains.add(complaint);
        }

        return complains;
    }


    public List<Complaint> getComplaintRejected() {
        complains =new ArrayList<>();
        try {
            complains = complaintRepo.findAll();
            System.out.println("ok");
        }
        catch (Exception e) {
            complaint =new Complaint();
            complaint.setCodeCmplaint("chyba komunikace z dbs");
            complaint.setDeiscription("výjimak: " + e);
            complains.add(complaint);
        }

        return complains;
    }


    private Complaint findByCodeCoplaint(String codeCoplaint){
        List<Complaint> complaints = new ArrayList<>();
        complaints=complaintRepo.findAll();
        System.out.println(complaints.get(1));
        for(Complaint complaint : complaints){
            if(codeCoplaint.equals(complaint.getCodeCmplaint())){
                return complaint;
            }
        }
        return null;

    }



}
