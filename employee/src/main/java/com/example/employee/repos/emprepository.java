package com.example.employee.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.employee.enteties.employee;

@Repository

public interface emprepository extends JpaRepository<employee, Long> {

}
