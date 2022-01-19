package com.example.pproprojekt.service;

import com.example.pproprojekt.entity.Complaint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.pproprojekt.repozitory.ComplaintRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComplaintService {
    private Complaint complaint;

    private ComplaintRepository complaintRepo;

    private List<Complaint> listCoplaint;


    public ComplaintService(ComplaintRepository complaintRepo) {
        this.complaintRepo = complaintRepo;
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
        listCoplaint= new ArrayList<>();
        for (Complaint complaint:listCoplaint) {
            if(codeComplaint.equals(complaint.getCodeCmplaint())){
                this.complaint=complaint;
            }

        }
        complaintRepo.delete(complaint);
        complaint.setInfoComplaint(infoComplaint);
        complaint.setStav(stav);
        complaint.setEmployId(employeId);
        complaint.setSettlementDate(settlementDate);
        complaintRepo.save(complaint);


        return complaint;

    }

    public List<Complaint> getAllComplaint(int stav) {
        List<Complaint> complains = new ArrayList<>();
        complains =complaintRepo.findAll();
        for(Complaint complaint : complains){
            if(complaint.getStav()!=stav){
                complains.remove(complaint);
            }
        }
        System.out.println("ok");
        return complains;

    }
}