package service;

import com.example.pproprojekt.entity.Depot;
import org.springframework.stereotype.Service;
import repozitory.ComplaintRepository;
import repozitory.DepotRepozitory;
import repozitory.DepotRepozitoryOracel;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepotService {
    private DepotRepozitory depotRepo = new DepotRepozitoryOracel();
    private Depot depot;
    private List<Depot> listPart;
    public DepotService() {
    }

    public DepotService(DepotRepozitory depotRepo) {
        this.depotRepo = depotRepo;
    }

    public Object addPart(String namePart, String typePart, String subtypePart, String parametrsPart, String manufacturePart, int countPart) {

        depot = new Depot(namePart,typePart,subtypePart,parametrsPart,manufacturePart,countPart);
        System.out.println("nazevDilu: " + depot.getNamePart());
        depotRepo.save(depot);
        return depot;
    }

    public Object addPiecePart(String namePart, int countPart) {


        listPart = new ArrayList<>();
        listPart=depotRepo.findAll();
        for (Depot part: listPart) {
            if(namePart.equals(part.getNamePart()))
            {
                depot=part;
            }

        }
        depotRepo.delete(depot);
        int countPartOld = depot.getCountPart();
        int countPartNew = countPartOld+countPart;
        depot.setCountPart(countPartNew);
        depotRepo.save(depot);

        return null;
    }

    public Object removePiecePart(String namePart, int countPart) {

        listPart = new ArrayList<>();
        listPart = depotRepo.findAll();
        for (Depot part : listPart) {
            if (namePart.equals(part.getNamePart())) {
                depot = part;
            }

        }
        depotRepo.delete(depot);
        int countPartOld = depot.getCountPart();
        int countPartNew = countPartOld - countPart;
        if (countPartNew >= 0){
            depot.setCountPart(countPartNew);
        }
        else {
            System.out.println("malodilu na skladu");
            depot.setCountPart(0);
        }
        depotRepo.save(depot);

        return null;
    }

}
