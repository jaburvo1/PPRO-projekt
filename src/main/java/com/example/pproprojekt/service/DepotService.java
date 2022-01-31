package com.example.pproprojekt.service;

import com.example.pproprojekt.entity.Depot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.pproprojekt.repozitory.DepotRepozitory;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepotService {
    @Autowired
    private DepotRepozitory depotRepo;
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
        System.out.println("ok");
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
        int countPartOld = depot.getCountPart();
        int countPartNew = countPartOld+countPart;
        depot.setCountPart(countPartNew);
        depotRepo.save(depot);

        return depot;
    }

    public Object removePiecePart(String namePart, int countPart) {

        Depot depot=null;
        listPart = new ArrayList<>();
        listPart = depotRepo.findAll();
        for (Depot part : listPart) {
            if (namePart.equals(part.getNamePart())) {
                depot = part;
            }

        }
        if(depot!=null) {

            int countPartOld = depot.getCountPart();
            int countPartNew = countPartOld - countPart;
            if (countPartNew >= 0) {
                depot.setCountPart(countPartNew);
                depotRepo.save(depot);
            } else {
                System.out.println("malodilu na skladu");
                depot=null;
            }


        }
        else{
            depot=null;
        }
        return depot;
    }

    public List<Depot> getAllPart() {
        List<Depot> partsList = new ArrayList<>();
        partsList = depotRepo.findAll();
        return partsList;
    }
    public Object findAll(String namePart){
        Depot depot=null;
        listPart = new ArrayList<>();
        listPart = depotRepo.findAll();
        for (Depot part : listPart) {
            if (namePart.equals(part.getNamePart())) {
                depot = part;
            }
        }
        return depot;
    }
}
