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
@Autowired
    private ComplaintRepository complaintRepo;
    private List<Complaint> complains;

    public ComplaintService(ComplaintRepository complaintRepo) {
        this.complaintRepo = complaintRepo;
    }

    public ComplaintService() {
    }

    public Object add(String codeComplaint, String description, String criateDate, int client, int stav, int employeId) {
        System.out.println("kodReklamace: "+codeComplaint+"stav: "+stav);
        complaint =new Complaint();
        complaint.setDeiscription(description);
        complaint.setClient(client);
        complaint.setCodeCmplaint(codeComplaint);
        complaint.setCriateDate(criateDate);
        complaint.setEmployId(employeId);
        complaint.setStav(stav);
        complaintRepo.save(complaint);
        System.out.println("ok");
        return complaint;

    }

    public Object edit(String codeComplaint, int stav, int employeId, String infoComplaint, String settlementDate){
       List<Complaint> listCoplaint= new ArrayList<>();
        for (Complaint complaint:listCoplaint) {
            if(codeComplaint.equals(complaint.getCodeCmplaint())){
                this.complaint=complaint;
            }

        }
        complaint.setInfoComplaint(infoComplaint);
        complaint.setStav(stav);
        complaint.setEmployId(employeId);
        complaint.setSettlementDate(settlementDate);
        complaintRepo.save(complaint);


        return complaint;

    }

    public List<Complaint> getComplaintAccepted() {
        complains =new ArrayList<>();

        //complains =complaintRepo.findAll();
        System.out.println("ok");
        for(Complaint complaint : complains) {
            if (complaint.getStav() == 1) {
                complains.remove(complaint);
            }
        }
        return complains;
    }

    public List<Complaint> getComplaintsettled() {
        complains =new ArrayList<>();

        //complains =complaintRepo.findAll();
        System.out.println("ok");
        for(Complaint complaint : complains) {
            if (complaint.getStav() ==2) {
                complains.remove(complaint);
            }
        }
        return complains;
    }


    public List<Complaint> getComplaintRejected() {
        complains =new ArrayList<>();

        //complains =complaintRepo.findAll();
        System.out.println("ok");
        for(Complaint complaint : complains) {
            if (complaint.getStav() == 3) {
                complains.remove(complaint);
            }
        }
        return complains;
    }


/*
    public List<Complaint> getAllComplaint(int stav) {
        List<Complaint> complains;
        System.out.println("ok");

        complains =complaintRepo.findAll();
        System.out.println("ok");
        for(Complaint complaint : complains){
            if(complaint.getStav()!=stav){
                complains.remove(complaint);
            }
        }
        System.out.println("ok");
        return complains;

    }*/
}
