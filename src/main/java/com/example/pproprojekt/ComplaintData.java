package com.example.pproprojekt;

import com.example.pproprojekt.entity.Complaint;

import java.util.List;

public class ComplaintData {
    private List<Complaint> acceptedList;
    private List<Complaint> settledList;
    private List<Complaint> deniedList;

    public ComplaintData(List<Complaint> acceptedList, List<Complaint> settledList, List<Complaint> deniedList) {
        this.acceptedList = acceptedList;
        this.settledList = settledList;
        this.deniedList = deniedList;
    }
}
