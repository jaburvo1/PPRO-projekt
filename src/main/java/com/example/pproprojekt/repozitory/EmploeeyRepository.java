package com.example.pproprojekt.repozitory;

import com.example.pproprojekt.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmploeeyRepository  extends JpaRepository<Employee, Long> {

    List<Employee> findByEmailAndPassword(String email, String password);
}