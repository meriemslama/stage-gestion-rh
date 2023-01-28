package com.example.employee.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.employee.enteties.departement;

import jakarta.transaction.Transactional;
@Transactional
@Repository

public interface deptrepository extends JpaRepository<departement, Long> {

}
