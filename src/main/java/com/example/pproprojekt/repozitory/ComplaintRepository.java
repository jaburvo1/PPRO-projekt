package com.example.pproprojekt.repozitory;

import com.example.pproprojekt.entity.Complaint;
import com.example.pproprojekt.entity.Depot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
}