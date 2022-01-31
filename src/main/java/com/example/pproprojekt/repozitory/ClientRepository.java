package com.example.pproprojekt.repozitory;

import com.example.pproprojekt.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
