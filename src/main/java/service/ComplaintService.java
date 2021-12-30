package service;

import com.example.pproprojekt.entity.Complaint;
import org.springframework.stereotype.Service;
import repozitory.ComplaintRepository;

@Service
public class ComplaintService {
    private Complaint complaint;
    private ComplaintRepository complaintRepo = new ComplaintRepository();

    public ComplaintService() {
    }


    public Object add(String codeComplaint, String description, String criateDate, int client, int stav, int employeId) {
        complaint =new Complaint();
        complaint.setDeiscription(description);
        complaint.setClient(client);
        complaint.setCodeCmplaint(codeComplaint);
        complaint.setCriateDate(criateDate);
        complaint.setEmployId(employeId);
        complaint.setStav(stav);
        addCompalintdb();
        System.out.println("ok");
        return complaint;

    }

    public Object edit(int stav, int employeId, String infoComplaint, String settlementDate, int id){
        complaint = findCompalintdb(id);
        System.out.println("ok");
        complaint.setStav(stav);
        complaint.setInfoComplaint(infoComplaint);
        complaint.setEmployId(employeId);
        complaint.setSettlementDate(settlementDate);
        if(id == complaint.getId()){
            editCompalintdb();
        }
        else{
            System.out.println("spatne id rekalamce");
        }


        return complaint;

    }

    private void addCompalintdb(){
        complaintRepo.add(complaint);


    }
    private Complaint findCompalintdb(int id){
       complaint = (Complaint) complaintRepo.findById(id);
        return complaint;
    }

    private void editCompalintdb(){
        complaintRepo.edit(complaint);
    }

}
