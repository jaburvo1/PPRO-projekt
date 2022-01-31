package com.example.pproprojekt.service;

import com.example.pproprojekt.entity.Client;
import com.example.pproprojekt.repozitory.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepo;

    public ClientService() {
    }
    public List<Client> findAll(){
        List<Client> clientLisst;
        clientLisst=clientRepo.findAll();
        return clientLisst;
    }
}
