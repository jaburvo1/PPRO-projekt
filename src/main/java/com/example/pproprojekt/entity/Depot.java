package com.example.pproprojekt.entity;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;

@EntityScan
public class Depot {
    @Id
   private int idSklad;
    public Depot() {
    }
}
